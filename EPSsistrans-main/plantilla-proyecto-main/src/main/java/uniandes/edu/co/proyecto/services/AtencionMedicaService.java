package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uniandes.edu.co.proyecto.modelo.AtencionMedica;
import uniandes.edu.co.proyecto.repositories.AtencionMedicaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para manejar la lógica de negocio de AtencionMedica.
 */
@Service
public class AtencionMedicaService {

    @Autowired
    private AtencionMedicaRepository atencionRepository;

    public List<AtencionMedica> listarTodas() {
        return atencionRepository.findAll();
    }

    public Optional<AtencionMedica> obtenerAtencionPorId(Integer id) {
        return atencionRepository.findById(id);
    }

    public AtencionMedica guardarAtencion(AtencionMedica atencion) {
        
        if (atencion.getFecha() == null) {
            throw new IllegalArgumentException("La fecha de atención es obligatoria.");
        }
        return atencionRepository.save(atencion);
    }

    public void eliminarAtencion(Integer id) {
        atencionRepository.deleteById(id);
    }
}
