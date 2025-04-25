package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uniandes.edu.co.proyecto.modelo.Cita;
import uniandes.edu.co.proyecto.repositories.CitaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para manejar la lógica de negocio de Cita.
 */
@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    public List<Cita> listarTodas() {
        return citaRepository.findAll();
    }

    public Optional<Cita> obtenerCitaPorId(Integer id) {
        return citaRepository.findById(id);
    }

    public Cita guardarCita(Cita cita) {
        // Ajustado para verificar el campo existente en la entidad
        if (cita.getFechaCita() == null) {
            throw new IllegalArgumentException("La fecha de la cita no puede ser nula.");
        }
        return citaRepository.save(cita);
    }

    public void eliminarCita(Integer id) {
        citaRepository.deleteById(id);
    }
}
