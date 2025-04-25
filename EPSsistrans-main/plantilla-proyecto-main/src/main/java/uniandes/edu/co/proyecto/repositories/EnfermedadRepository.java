package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Enfermedad;

import java.util.Collection;

public interface EnfermedadRepository extends JpaRepository<Enfermedad, Integer> {

    @Query(value = "SELECT * FROM ENFERMEDAD", nativeQuery = true)
    Collection<Enfermedad> darEnfermedades();

    @Query(value = "SELECT * FROM ENFERMEDAD WHERE ID_ENFERMEDAD = :id", nativeQuery = true)
    Enfermedad darEnfermedadPorId(@Param("id") int id);

    // INSERT
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ENFERMEDAD (ID_ENFERMEDAD, NOMBRE_ENFERMEDAD, DESCRIPCION, SINTOMAS) "
                 + "VALUES (:id, :nombre, :descr, :sint)", 
           nativeQuery = true)
    void insertarEnfermedad(@Param("id") int id,
                            @Param("nombre") String nombre,
                            @Param("descr") String descripcion,
                            @Param("sint") String sintomas);

    // UPDATE
    @Modifying
    @Transactional
    @Query(value = "UPDATE ENFERMEDAD "
                 + "SET NOMBRE_ENFERMEDAD = :nombre, DESCRIPCION = :descr, SINTOMAS = :sint "
                 + "WHERE ID_ENFERMEDAD = :id", 
           nativeQuery = true)
    void actualizarEnfermedad(@Param("id") int id,
                              @Param("nombre") String nombre,
                              @Param("descr") String descripcion,
                              @Param("sint") String sintomas);

    // DELETE
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ENFERMEDAD WHERE ID_ENFERMEDAD = :id", nativeQuery = true)
    void eliminarEnfermedad(@Param("id") int id);
}
