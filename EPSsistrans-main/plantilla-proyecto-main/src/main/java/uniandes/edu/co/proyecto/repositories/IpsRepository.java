package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Ips;

import java.util.Collection;

public interface IpsRepository extends JpaRepository<Ips, Integer> {

    @Query(value = "SELECT * FROM IPS", nativeQuery = true)
    Collection<Ips> darIps();

    @Query(value = "SELECT * FROM IPS WHERE ID_IPS = :id", nativeQuery = true)
    Ips darIpsPorId(@Param("id") int id);

    // INSERT (RF1: Registrar IPS)
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO IPS (ID_IPS, NOMBRE_IPS, DIRECCION_IPS, ID_EPS) "
                 + "VALUES (:id, :nombre, :direccion, :idEps)", 
           nativeQuery = true)
    void insertarIps(@Param("id") int id,
                     @Param("nombre") String nombre,
                     @Param("direccion") String direccion,
                     @Param("idEps") Integer idEps);

    // UPDATE
    @Modifying
    @Transactional
    @Query(value = "UPDATE IPS "
                 + "SET NOMBRE_IPS = :nombre, DIRECCION_IPS = :direccion, ID_EPS = :idEps "
                 + "WHERE ID_IPS = :id", 
           nativeQuery = true)
    void actualizarIps(@Param("id") int id,
                       @Param("nombre") String nombre,
                       @Param("direccion") String direccion,
                       @Param("idEps") Integer idEps);

    // DELETE
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM IPS WHERE ID_IPS = :id", nativeQuery = true)
    void eliminarIps(@Param("id") int id);

    // (RF3) Asignar un servicio de salud a la IPS => Insertar en IPS_SERVICIO
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO IPS_SERVICIO (ID_IPS, ID_SERVICIO) "
                 + "VALUES (:idIps, :idServicio)", 
           nativeQuery = true)
    void asignarServicioAIPS(@Param("idIps") int idIps,
                             @Param("idServicio") int idServicio);
}
