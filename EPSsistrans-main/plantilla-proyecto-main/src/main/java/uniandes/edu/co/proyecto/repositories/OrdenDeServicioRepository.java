package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.OrdenDeServicio;

import java.util.Collection;
import java.sql.Date;

/**
 * RF6: Registrar orden de servicio de salud.
 */
public interface OrdenDeServicioRepository extends JpaRepository<OrdenDeServicio, Integer> {

    @Query(value = "SELECT * FROM ORDEN_BASE", nativeQuery = true)
    Collection<OrdenDeServicio> darOrdenes();

    @Query(value = "SELECT * FROM ORDEN_BASE WHERE ID_ORDEN = :id", nativeQuery = true)
    OrdenDeServicio darOrdenPorId(@Param("id") int id);

    // INSERT
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ORDEN_BASE (ID_ORDEN, FECHA_EMISION, ID_AFILIADO, ID_MEDICO, ID_SERVICIO) "
                 + "VALUES (:id, :fecha, :idAfi, :idMed, :idServ)", 
           nativeQuery = true)
    void insertarOrden(@Param("id") int id,
                       @Param("fecha") Date fechaEmision,
                       @Param("idAfi") int idAfiliado,
                       @Param("idMed") int idMedico,
                       @Param("idServ") int idServicio);

    // UPDATE
    @Modifying
    @Transactional
    @Query(value = "UPDATE ORDEN_BASE "
                 + "SET FECHA_EMISION = :fecha, ID_AFILIADO = :idAfi, ID_MEDICO = :idMed, ID_SERVICIO = :idServ "
                 + "WHERE ID_ORDEN = :id",
           nativeQuery = true)
    void actualizarOrden(@Param("id") int id,
                         @Param("fecha") Date fechaEmision,
                         @Param("idAfi") int idAfiliado,
                         @Param("idMed") int idMedico,
                         @Param("idServ") int idServicio);

    // DELETE
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ORDEN_BASE WHERE ID_ORDEN = :id", nativeQuery = true)
    void eliminarOrden(@Param("id") int id);
}
