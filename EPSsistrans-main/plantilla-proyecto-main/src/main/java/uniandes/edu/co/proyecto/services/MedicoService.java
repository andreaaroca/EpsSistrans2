package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uniandes.edu.co.proyecto.modelo.Especialidad;
import uniandes.edu.co.proyecto.modelo.Medico;
import uniandes.edu.co.proyecto.repositories.EspecialidadRepository;
import uniandes.edu.co.proyecto.repositories.MedicoRepository;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para manejar la lógica de negocio de Medico.
 */
@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private EspecialidadRepository especialidadRepository;

    public Medico crearMedico(Medico medico) {
        if (medico.getNombre() == null || medico.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del médico no puede ser vacío");
        }
        // Validar especialidad si viene
        if (medico.getEspecialidad() != null) {
            Optional<Especialidad> op = especialidadRepository.findById(medico.getEspecialidad().getId());
            if (op.isEmpty()) {
                throw new IllegalArgumentException("La especialidad con ese id no existe");
            }
            medico.setEspecialidad(op.get());
        }
        return medicoRepository.save(medico);
    }

    public List<Medico> listarMedicos() {
        return medicoRepository.findAll();
    }

    // Ajustamos a Integer
    public Medico obtenerMedico(Integer id) {
        Optional<Medico> op = medicoRepository.findById(id);
        return op.orElse(null);
    }

    public Medico actualizarMedico(Integer id, Medico medico) {
        Medico old = obtenerMedico(id);
        if (old == null) {
            throw new IllegalArgumentException("No existe el médico con id=" + id);
        }
        if (medico.getNombre() == null || medico.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre inválido");
        }
        // Actualizamos los campos
        old.setNombre(medico.getNombre());
        old.setRegistro(medico.getRegistro());
        old.setTipoDocumento(medico.getTipoDocumento());
        old.setNumeroDocumento(medico.getNumeroDocumento());

        // Actualizar la especialidad si viene
        if (medico.getEspecialidad() != null) {
            Optional<Especialidad> op = especialidadRepository.findById(medico.getEspecialidad().getId());
            if (op.isEmpty()) {
                throw new IllegalArgumentException("Especialidad no existe");
            }
            old.setEspecialidad(op.get());
        } else {
            old.setEspecialidad(null);
        }
        return medicoRepository.save(old);
    }

    public void eliminarMedico(Integer id) {
        medicoRepository.deleteById(id);
    }
}
