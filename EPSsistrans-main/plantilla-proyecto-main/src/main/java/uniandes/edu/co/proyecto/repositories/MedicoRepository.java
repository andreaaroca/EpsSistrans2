package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Medico;

import java.util.Collection;

/**
 * RF4: Registrar médico.
 */
public interface MedicoRepository extends JpaRepository<Medico, Integer> {

    @Query(value = "SELECT * FROM MEDICO", nativeQuery = true)
    Collection<Medico> darMedicos();

    @Query(value = "SELECT * FROM MEDICO WHERE ID_MEDICO = :id", nativeQuery = true)
    Medico darMedicoPorId(@Param("id") int id);

    // INSERT
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO MEDICO (ID_MEDICO, NOMBRE_MEDICO, REGISTRO_MEDICO, ID_ESPECIALIDAD) "
                 + "VALUES (:id, :nombre, :registro, :idEsp)", nativeQuery = true)
    void insertarMedico(@Param("id") int id,
                        @Param("nombre") String nombre,
                        @Param("registro") String registroMedico,
                        @Param("idEsp") Integer idEspecialidad);

    // UPDATE
    @Modifying
    @Transactional
    @Query(value = "UPDATE MEDICO "
                 + "SET NOMBRE_MEDICO = :nombre, REGISTRO_MEDICO = :registro, ID_ESPECIALIDAD = :idEsp "
                 + "WHERE ID_MEDICO = :id", 
           nativeQuery = true)
    void actualizarMedico(@Param("id") int id,
                          @Param("nombre") String nombre,
                          @Param("registro") String registroMedico,
                          @Param("idEsp") Integer idEspecialidad);

    // DELETE
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM MEDICO WHERE ID_MEDICO = :id", nativeQuery = true)
    void eliminarMedico(@Param("id") int id);
}
