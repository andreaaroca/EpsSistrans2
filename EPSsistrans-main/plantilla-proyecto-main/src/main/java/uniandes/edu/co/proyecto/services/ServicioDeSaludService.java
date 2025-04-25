package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uniandes.edu.co.proyecto.modelo.ServicioDeSalud;
import uniandes.edu.co.proyecto.repositories.ServicioSaludRepository;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para manejar la lógica de negocio de ServicioDeSalud.
 */
@Service
public class ServicioDeSaludService {

    @Autowired
    private ServicioSaludRepository servicioRepository;

    public List<ServicioDeSalud> listarTodos() {
        return servicioRepository.findAll();
    }

    public Optional<ServicioDeSalud> obtenerServicioPorId(Integer id) {
        return servicioRepository.findById(id);
    }

    public ServicioDeSalud guardarServicio(ServicioDeSalud servicio) {
        // Cambiar getNombreServicio() => getDescripcion()
        if (servicio.getDescripcion() == null || servicio.getDescripcion().trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción del servicio no puede ser nula o vacía.");
        }
        return servicioRepository.save(servicio);
    }

    public void eliminarServicio(Integer id) {
        servicioRepository.deleteById(id);
    }
}
