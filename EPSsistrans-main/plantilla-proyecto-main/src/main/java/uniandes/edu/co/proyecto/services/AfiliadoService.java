package uniandes.edu.co.proyecto.services;

import uniandes.edu.co.proyecto.modelo.Afiliado;
import uniandes.edu.co.proyecto.repositories.AfiliadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para manejar la lógica de negocio de Afiliado.
 */
@Service
public class AfiliadoService {

    @Autowired
    private AfiliadoRepository afiliadoRepository;

    /**
     * Crea un afiliado en la base de datos.
     * @param afiliado Objeto Afiliado con datos completos (nombre, fechaNacimiento, tipoAfiliacion, etc.)
     * @return El Afiliado guardado, con su nuevo ID asignado.
     */
    @Transactional
    public Afiliado crearAfiliado(Afiliado afiliado) {
        // Validación básica: nombre no nulo ni vacío
        if (afiliado.getNombre() == null || afiliado.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del afiliado no puede ser nulo o vacío.");
        }
        return afiliadoRepository.save(afiliado);
    }

    /**
     * Lista todos los afiliados existentes.
     * @return Lista de todos los afiliados en la base de datos.
     */
    @Transactional
    public List<Afiliado> listarAfiliados() {
        return afiliadoRepository.findAll();
    }

    /**
     * Obtiene un Afiliado por ID. Retorna null si no existe.
     * @param id ID del Afiliado que se quiere buscar.
     * @return El Afiliado encontrado, o null si no existe.
     */
    @Transactional
    public Afiliado obtenerAfiliado(Integer id) {
        Optional<Afiliado> op = afiliadoRepository.findById(id);
        return op.orElse(null);
    }

    /**
     * Actualiza los datos de un afiliado, siempre que exista.
     * @param id           ID del afiliado a actualizar.
     * @param nuevosDatos  Afiliado con los campos que se desean actualizar.
     * @return El Afiliado ya actualizado.
     */
    @Transactional
    public Afiliado actualizarAfiliado(Integer id, Afiliado nuevosDatos) {
        Afiliado afiliadoExistente = obtenerAfiliado(id);
        if (afiliadoExistente == null) {
            throw new IllegalArgumentException("No existe el afiliado con id=" + id);
        }
        if (nuevosDatos.getNombre() == null || nuevosDatos.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre inválido.");
        }
        // Actualizar campos existentes
        afiliadoExistente.setNombre(nuevosDatos.getNombre());
        afiliadoExistente.setFechaNacimiento(nuevosDatos.getFechaNacimiento());
        afiliadoExistente.setTipoAfiliacion(nuevosDatos.getTipoAfiliacion());

        // Guardar cambios
        return afiliadoRepository.save(afiliadoExistente);
    }

    /**
     * Elimina un afiliado por ID, si existe.
     * @param id ID del afiliado que se eliminará.
     */
    @Transactional
    public void eliminarAfiliado(Integer id) {
        // Si no existe, el deleteById de JPA lanza una excepción, o simplemente no hace nada, según configuración.
        afiliadoRepository.deleteById(id);
    }
}
