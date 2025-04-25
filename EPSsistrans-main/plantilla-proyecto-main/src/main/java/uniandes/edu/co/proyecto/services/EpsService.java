package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uniandes.edu.co.proyecto.modelo.Eps;
import uniandes.edu.co.proyecto.repositories.EpsRepository;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para manejar la lógica de negocio de Eps.
 */
@Service
public class EpsService {

    @Autowired
    private EpsRepository epsRepository;

    public List<Eps> listarTodas() {
        return epsRepository.findAll();
    }

    public Optional<Eps> obtenerEpsPorId(Integer id) {
        return epsRepository.findById(id);
    }

    public Eps guardarEps(Eps eps) {
        if (eps.getNombre() == null || eps.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la EPS no puede ser nulo o vacío.");
        }
        return epsRepository.save(eps);
    }

    public void eliminarEps(Integer id) {
        epsRepository.deleteById(id);
    }
}
