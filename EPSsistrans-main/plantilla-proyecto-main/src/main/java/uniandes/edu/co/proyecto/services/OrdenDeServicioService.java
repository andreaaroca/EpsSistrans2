package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uniandes.edu.co.proyecto.modelo.Afiliado;
import uniandes.edu.co.proyecto.modelo.Medico;
import uniandes.edu.co.proyecto.modelo.OrdenDeServicio;
import uniandes.edu.co.proyecto.repositories.AfiliadoRepository;
import uniandes.edu.co.proyecto.repositories.MedicoRepository;
import uniandes.edu.co.proyecto.repositories.OrdenDeServicioRepository;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para manejar la lógica de negocio de OrdenDeServicio.
 */
@Service
public class OrdenDeServicioService {

    @Autowired
    private OrdenDeServicioRepository ordenRepository;

    @Autowired
    private AfiliadoRepository afiliadoRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    /**
     * Crea una nueva orden de servicio.
     * @param orden Objeto OrdenDeServicio con fechaEmision, afiliado, medico, etc.
     * @return La orden ya guardada en la base de datos.
     */
    public OrdenDeServicio crearOrdenDeServicio(OrdenDeServicio orden) {
        if (orden.getFechaEmision() == null) {
            throw new IllegalArgumentException("La fecha de emisión no puede ser nula");
        }
        // Validar afiliado
        if (orden.getAfiliado() != null) {
            Optional<Afiliado> afi = afiliadoRepository.findById(orden.getAfiliado().getId());
            if (afi.isEmpty()) {
                throw new IllegalArgumentException("El afiliado no existe");
            }
            orden.setAfiliado(afi.get());
        }
        // Validar médico
        if (orden.getMedico() != null) {
            Optional<Medico> med = medicoRepository.findById(orden.getMedico().getId());
            if (med.isEmpty()) {
                throw new IllegalArgumentException("El médico no existe");
            }
            orden.setMedico(med.get());
        }
        return ordenRepository.save(orden);
    }

    /**
     * Retorna la lista de todas las órdenes de servicio.
     */
    public List<OrdenDeServicio> listarOrdenes() {
        return ordenRepository.findAll();
    }

    /**
     * Busca una orden por ID (Integer).
     * @param id ID de la orden
     * @return La orden encontrada o null si no existe
     */
    public OrdenDeServicio obtenerOrden(Integer id) {
        Optional<OrdenDeServicio> op = ordenRepository.findById(id);
        return op.orElse(null);
    }

    /**
     * Actualiza una orden existente.
     * @param id    ID de la orden
     * @param nueva OrdenDeServicio con los campos a modificar
     * @return La orden actualizada
     */
    public OrdenDeServicio actualizarOrden(Integer id, OrdenDeServicio nueva) {
        OrdenDeServicio old = obtenerOrden(id);
        if (old == null) {
            throw new IllegalArgumentException("No existe la orden con id=" + id);
        }
        if (nueva.getFechaEmision() == null) {
            throw new IllegalArgumentException("Fecha de emisión inválida");
        }
        // Actualizar campos que sí existen en OrdenDeServicio
        old.setFechaEmision(nueva.getFechaEmision());
        
        // No se llama old.setEstado(...) porque la entidad no define un campo "estado".

        // Actualizar afiliado
        if (nueva.getAfiliado() != null) {
            Optional<Afiliado> afi = afiliadoRepository.findById(nueva.getAfiliado().getId());
            if (afi.isEmpty()) {
                throw new IllegalArgumentException("Afiliado no existe");
            }
            old.setAfiliado(afi.get());
        } else {
            old.setAfiliado(null);
        }

        // Actualizar médico
        if (nueva.getMedico() != null) {
            Optional<Medico> med = medicoRepository.findById(nueva.getMedico().getId());
            if (med.isEmpty()) {
                throw new IllegalArgumentException("Médico no existe");
            }
            old.setMedico(med.get());
        } else {
            old.setMedico(null);
        }

        // idServicio (si lo tienes):
        old.setIdServicio(nueva.getIdServicio());

        return ordenRepository.save(old);
    }

    /**
     * Elimina una orden por ID (Integer).
     * @param id ID de la orden
     */
    public void eliminarOrden(Integer id) {
        ordenRepository.deleteById(id);
    }
}
