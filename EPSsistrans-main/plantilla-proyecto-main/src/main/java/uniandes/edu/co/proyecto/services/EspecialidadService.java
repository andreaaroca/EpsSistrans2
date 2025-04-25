package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uniandes.edu.co.proyecto.modelo.Especialidad;
import uniandes.edu.co.proyecto.repositories.EspecialidadRepository;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para manejar la lógica de negocio de Especialidad.
 */
@Service
public class EspecialidadService {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    public Especialidad crearEspecialidad(Especialidad especialidad) {
        if (especialidad.getNombre() == null || especialidad.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la especialidad no puede ser vacío.");
        }
        return especialidadRepository.save(especialidad);
    }

    public List<Especialidad> listarEspecialidades() {
        return especialidadRepository.findAll();
    }

    // Cambiamos a Integer
    public Especialidad obtenerEspecialidad(Integer id) {
        Optional<Especialidad> op = especialidadRepository.findById(id);
        return op.orElse(null);
    }

    // También Integer aquí
    public Especialidad actualizarEspecialidad(Integer id, Especialidad especialidad) {
        Especialidad old = obtenerEspecialidad(id);
        if (old == null) {
            throw new IllegalArgumentException("No existe la especialidad con id=" + id);
        }
        if (especialidad.getNombre() == null || especialidad.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre inválido");
        }
        old.setNombre(especialidad.getNombre());
        // Eliminamos 'old.setDescripcion(...)' porque no hay campo descripcion
        return especialidadRepository.save(old);
    }

    // Y aquí
    public void eliminarEspecialidad(Integer id) {
        especialidadRepository.deleteById(id);
    }
}
