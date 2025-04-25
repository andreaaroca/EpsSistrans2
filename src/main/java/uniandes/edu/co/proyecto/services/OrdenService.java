
package uniandes.edu.co.proyecto.services;

import java.sql.Date;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import uniandes.edu.co.proyecto.modelo.*;
import uniandes.edu.co.proyecto.repositories.*;

@Service
@RequiredArgsConstructor
public class OrdenService {

    private final OrdenDeServicioRepository repo;
    private final AfiliadoRepository afiliadoRepo;
    private final MedicoRepository medicoRepo;
    private final ServicioDeSaludRepository servRepo;

    public OrdenDeServicio emitir(Integer idAfiliado, Integer idMedico, Integer idServicio) {
        Afiliado a = afiliadoRepo.findById(idAfiliado).orElseThrow(() -> new IllegalArgumentException("Afiliado not found with id: " + idAfiliado));
        Medico m = medicoRepo.findById(idMedico).orElseThrow(() -> new IllegalArgumentException("Medico not found with id: " + idMedico));
        ServicioDeSalud s = servRepo.findById(idServicio).orElseThrow(() -> new IllegalArgumentException("ServicioDeSalud not found with id: " + idServicio));
        OrdenDeServicio o = new OrdenDeServicio(new Date(System.currentTimeMillis()), a, m, s);
        return repo.save(o);
    }
}
