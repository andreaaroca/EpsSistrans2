package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uniandes.edu.co.proyecto.modelo.Enfermedad;
import uniandes.edu.co.proyecto.repositories.EnfermedadRepository;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para manejar la lógica de negocio de Enfermedad.
 */
@Service
public class EnfermedadService {

    @Autowired
    private EnfermedadRepository enfermedadRepository;

    // Crea enfermedad
    public Enfermedad crearEnfermedad(Enfermedad enfermedad) {
        // Cambiamos getNombreEnfermedad() -> getNombre()
        if (enfermedad.getNombre() == null || enfermedad.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la enfermedad no puede ser vacío.");
        }
        return enfermedadRepository.save(enfermedad);
    }

    // Lista todas las enfermedades
    public List<Enfermedad> listarEnfermedades() {
        return enfermedadRepository.findAll();
    }

    // Busca una enfermedad por ID (Integer)
    public Enfermedad obtenerEnfermedad(Integer id) {
        Optional<Enfermedad> op = enfermedadRepository.findById(id);
        return op.orElse(null);
    }

    // Actualiza enfermedad
    public Enfermedad actualizarEnfermedad(Integer id, Enfermedad enfermedad) {
        Enfermedad old = obtenerEnfermedad(id);
        if (old == null) {
            throw new IllegalArgumentException("No existe una enfermedad con id=" + id);
        }
        // getNombreEnfermedad() -> getNombre()
        if (enfermedad.getNombre() == null || enfermedad.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre inválido");
        }
        // old.setNombreEnfermedad(...) -> old.setNombre(...)
        old.setNombre(enfermedad.getNombre());
        old.setDescripcion(enfermedad.getDescripcion());
        old.setSintomas(enfermedad.getSintomas());
        return enfermedadRepository.save(old);
    }

    // Elimina enfermedad por ID (Integer)
    public void eliminarEnfermedad(Integer id) {
        enfermedadRepository.deleteById(id);
    }
}
