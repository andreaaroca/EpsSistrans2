package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Especialidad;

import java.util.Collection;

public interface EspecialidadRepository extends JpaRepository<Especialidad, Integer> {

    @Query(value = "SELECT * FROM ESPECIALIDAD", nativeQuery = true)
    Collection<Especialidad> darEspecialidades();

    @Query(value = "SELECT * FROM ESPECIALIDAD WHERE ID_ESPECIALIDAD = :id", nativeQuery = true)
    Especialidad darEspecialidadPorId(@Param("id") int id);

    // INSERT
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ESPECIALIDAD (ID_ESPECIALIDAD, NOMBRE_ESPECIALIDAD) "
                 + "VALUES (:id, :nombre)", nativeQuery = true)
    void insertarEspecialidad(@Param("id") int id,
                              @Param("nombre") String nombre);

    // UPDATE
    @Modifying
    @Transactional
    @Query(value = "UPDATE ESPECIALIDAD "
                 + "SET NOMBRE_ESPECIALIDAD = :nombre "
                 + "WHERE ID_ESPECIALIDAD = :id", 
           nativeQuery = true)
    void actualizarEspecialidad(@Param("id") int id,
                                @Param("nombre") String nombre);

    // DELETE
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ESPECIALIDAD WHERE ID_ESPECIALIDAD = :id", nativeQuery = true)
    void eliminarEspecialidad(@Param("id") int id);
}
