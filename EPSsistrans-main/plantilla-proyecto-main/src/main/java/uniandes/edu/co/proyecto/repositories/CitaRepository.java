package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Cita;

import java.util.Collection;
import java.sql.Date;

/**
 * Repositorio para CITA_BASE.
 * Corresponde a RF7: Agendar un servicio por parte de un afiliado (si se usa esta tabla).
 */
public interface CitaRepository extends JpaRepository<Cita, Integer> {

    @Query(value = "SELECT * FROM CITA_BASE", nativeQuery = true)
    Collection<Cita> darCitas();

    @Query(value = "SELECT * FROM CITA_BASE WHERE ID_CITA = :id", nativeQuery = true)
    Cita darCitaPorId(@Param("id") int id);

    // INSERT
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO CITA_BASE (ID_CITA, FECHA_CITA, HORA_CITA, ID_AFILIADO, ID_MEDICO, ID_IPS, ID_SERVICIO) "
                 + "VALUES (:id, :fecha, :hora, :idAfi, :idMed, :idIps, :idServ)", 
           nativeQuery = true)
    void insertarCita(@Param("id") int id,
                      @Param("fecha") Date fechaCita,
                      @Param("hora") String horaCita,
                      @Param("idAfi") int idAfiliado,
                      @Param("idMed") int idMedico,
                      @Param("idIps") int idIps,
                      @Param("idServ") Integer idServicio);

    // UPDATE
    @Modifying
    @Transactional
    @Query(value = "UPDATE CITA_BASE "
                 + "SET FECHA_CITA = :fecha, HORA_CITA = :hora, ID_AFILIADO = :idAfi, "
                 + "    ID_MEDICO = :idMed, ID_IPS = :idIps, ID_SERVICIO = :idServ "
                 + "WHERE ID_CITA = :id", 
           nativeQuery = true)
    void actualizarCita(@Param("id") int id,
                        @Param("fecha") Date fechaCita,
                        @Param("hora") String horaCita,
                        @Param("idAfi") int idAfiliado,
                        @Param("idMed") int idMedico,
                        @Param("idIps") int idIps,
                        @Param("idServ") Integer idServicio);

    // DELETE
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM CITA_BASE WHERE ID_CITA = :id", nativeQuery = true)
    void eliminarCita(@Param("id") int id);
}
