package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.AtencionMedica;

import java.util.Collection;

/**
 * Repositorio para ATENCION_MEDICA.
 * Corresponde a RF8: Registrar la prestación de un servicio (parte final).
 */
public interface AtencionMedicaRepository extends JpaRepository<AtencionMedica, Integer> {

    @Query(value = "SELECT * FROM ATENCION_MEDICA", nativeQuery = true)
    Collection<AtencionMedica> darAtenciones();

    @Query(value = "SELECT * FROM ATENCION_MEDICA WHERE ID_ATENCION = :id", nativeQuery = true)
    AtencionMedica darAtencionPorId(@Param("id") int id);

    // INSERT
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ATENCION_MEDICA (ID_ATENCION, ID_CITA, DIAGNOSTICO, RESULTADOS) "
                 + "VALUES (:id, :idCita, :diag, :res)", nativeQuery = true)
    void insertarAtencion(@Param("id") int id,
                          @Param("idCita") int idCita,
                          @Param("diag") String diagnostico,
                          @Param("res") String resultados);

    // UPDATE
    @Modifying
    @Transactional
    @Query(value = "UPDATE ATENCION_MEDICA "
                 + "SET ID_CITA = :idCita, DIAGNOSTICO = :diag, RESULTADOS = :res "
                 + "WHERE ID_ATENCION = :id", nativeQuery = true)
    void actualizarAtencion(@Param("id") int id,
                            @Param("idCita") int idCita,
                            @Param("diag") String diagnostico,
                            @Param("res") String resultados);

    // DELETE
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ATENCION_MEDICA WHERE ID_ATENCION = :id", nativeQuery = true)
    void eliminarAtencion(@Param("id") int id);
}

