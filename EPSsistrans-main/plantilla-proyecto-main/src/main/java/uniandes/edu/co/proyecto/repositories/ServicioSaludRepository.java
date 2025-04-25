package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.ServicioDeSalud;

import java.util.Collection;

/**
 * RF2: Registrar un servicio de salud.
 */
public interface ServicioSaludRepository extends JpaRepository<ServicioDeSalud, Integer> {

    @Query(value = "SELECT * FROM SERVICIO_SALUD", nativeQuery = true)
    Collection<ServicioDeSalud> darServicios();

    @Query(value = "SELECT * FROM SERVICIO_SALUD WHERE ID_SERVICIO = :id", nativeQuery = true)
    ServicioDeSalud darServicioPorId(@Param("id") int id);

    // INSERT
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO SERVICIO_SALUD (ID_SERVICIO, DESCRIPCION) "
                 + "VALUES (:id, :descr)", 
           nativeQuery = true)
    void insertarServicio(@Param("id") int id,
                          @Param("descr") String descripcion);

    // UPDATE
    @Modifying
    @Transactional
    @Query(value = "UPDATE SERVICIO_SALUD "
                 + "SET DESCRIPCION = :descr "
                 + "WHERE ID_SERVICIO = :id", 
           nativeQuery = true)
    void actualizarServicio(@Param("id") int id,
                            @Param("descr") String descripcion);

    // DELETE
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM SERVICIO_SALUD WHERE ID_SERVICIO = :id", nativeQuery = true)
    void eliminarServicio(@Param("id") int id);
}
