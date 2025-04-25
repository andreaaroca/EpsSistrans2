
package uniandes.edu.co.proyecto.services;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import uniandes.edu.co.proyecto.modelo.*;
import uniandes.edu.co.proyecto.repositories.*;

@Service
@RequiredArgsConstructor
public class AgendaService {

    private final AgendaRepository repo;

    public List<Agenda> disponibilidad(Integer idServicio){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime future = now.plusWeeks(4);
        return repo.findAll().stream()
                .filter(a -> a.getServicio().getId().equals(idServicio)
                          && a.getFechaHora().isAfter(now)
                          && a.getFechaHora().isBefore(future))
                .collect(Collectors.toList());
    }
}
