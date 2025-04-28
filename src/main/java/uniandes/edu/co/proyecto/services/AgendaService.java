
package uniandes.edu.co.proyecto.services;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import uniandes.edu.co.proyecto.repositories.*;

@Service
@RequiredArgsConstructor
public class AgendaService {

    private final AgendaRepository repo;
 
    /* * RFC 1: 
    @Transactional(readOnly = true)
    public List<Map<String, String>> consultarDisponibilidadServicio(Integer idServicio) {
        return repo.consultarDisponibilidadServicio(idServicio);
    }
    */


    // RFC5: Consulta con aislamiento SERIALIZABLE
    @Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class)
    public List<Map<String, String>> consultarAgendaSerializable(LocalDateTime  fechaInicio, LocalDateTime fechaFin, Long idServicio, Long idMedico) throws InterruptedException {
        return ejecutarConsultaConTemporizador(fechaInicio, fechaFin, idServicio, idMedico);
    }

    // RFC6: Consulta con aislamiento READ_COMMITTED
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public List<Map<String, String>> consultarAgendaReadCommitted(LocalDateTime  fechaInicio, LocalDateTime  fechaFin, Long idServicio, Long idMedico) throws InterruptedException {
        return ejecutarConsultaConTemporizador(fechaInicio, fechaFin, idServicio, idMedico);
    }
    
    //funcion general para ambos
    private List<Map<String, String>> ejecutarConsultaConTemporizador(LocalDateTime fechaInicio, LocalDateTime  fechaFin, Long idServicio, Long idMedico) throws InterruptedException {
        
        long tiempoInicio = System.currentTimeMillis();
        List<Map<String, String>> resultado = repo.findAgendaDisponible(fechaInicio, fechaFin, idServicio, idMedico);

        long tiempoTranscurrido = System.currentTimeMillis() - tiempoInicio;
        long tiempoRestante = 30000 - tiempoTranscurrido;

        if (tiempoRestante > 0) {
            TimeUnit.MILLISECONDS.sleep(tiempoRestante);
        } else {
            throw new RuntimeException("La consulta excedió el tiempo límite de 30 segundos.");
        }

        return resultado;
    }
    
}
