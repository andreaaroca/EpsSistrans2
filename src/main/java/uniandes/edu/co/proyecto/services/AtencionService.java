
package uniandes.edu.co.proyecto.services;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import uniandes.edu.co.proyecto.modelo.*;
import uniandes.edu.co.proyecto.repositories.*;

@Service
@RequiredArgsConstructor
public class AtencionService {

    private final CitaRepository citaRepo;
    private final AtencionMedicaRepository repo;

    public AtencionMedica registrar(Integer idCita, String dx, String res){
        Cita c = citaRepo.findById(idCita).orElseThrow(() -> new IllegalArgumentException("Cita not found with id: " + idCita));
        return repo.save(new AtencionMedica(c, dx, res));
    }
}
