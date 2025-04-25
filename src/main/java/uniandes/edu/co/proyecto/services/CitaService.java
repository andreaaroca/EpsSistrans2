
package uniandes.edu.co.proyecto.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import uniandes.edu.co.proyecto.modelo.*;
import uniandes.edu.co.proyecto.repositories.*;

@Service
@RequiredArgsConstructor
public class CitaService {

    private final AgendaRepository agendaRepo;
    private final OrdenDeServicioRepository ordenRepo;
    private final CitaRepository citaRepo;

    @Transactional
    public Cita agendar(Integer idAgenda, Integer idOrden){
        Agenda agenda = agendaRepo.findById(idAgenda).orElseThrow(() -> new IllegalArgumentException("Agenda not found"));
        if(!"DISPONIBLE".equals(agenda.getEstado()))
            throw new IllegalStateException("Agenda no disponible");
        OrdenDeServicio orden = ordenRepo.findById(idOrden).orElseThrow(() -> new IllegalArgumentException("OrdenDeServicio not found"));
        agenda.setEstado("OCUPADO");
        Cita c = new Cita(agenda, orden);
        return citaRepo.save(c);
    }
}
