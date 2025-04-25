package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Eps;

import java.util.Collection;

public interface EpsRepository extends JpaRepository<Eps, Integer> {

    @Query(value = "SELECT * FROM EPS", nativeQuery = true)
    Collection<Eps> darEps();

    @Query(value = "SELECT * FROM EPS WHERE ID_EPS = :id", nativeQuery = true)
    Eps darEpsPorId(@Param("id") int id);

    // INSERT
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO EPS (ID_EPS, NOMBRE_EPS, DIRECCION_EPS) "
                 + "VALUES (:id, :nombre, :direccion)", nativeQuery = true)
    void insertarEps(@Param("id") int id,
                     @Param("nombre") String nombre,
                     @Param("direccion") String direccion);

    // UPDATE
    @Modifying
    @Transactional
    @Query(value = "UPDATE EPS SET NOMBRE_EPS = :nombre, DIRECCION_EPS = :direccion "
                 + "WHERE ID_EPS = :id", 
           nativeQuery = true)
    void actualizarEps(@Param("id") int id,
                       @Param("nombre") String nombre,
                       @Param("direccion") String direccion);

    // DELETE
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM EPS WHERE ID_EPS = :id", nativeQuery = true)
    void eliminarEps(@Param("id") int id);
}
