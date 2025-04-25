package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Afiliado;

import java.sql.Date;
import java.util.Collection;

/**
 * Repositorio para la tabla AFILIADO.
 * Corresponde a RF5: Registrar Afiliado y operaciones CRUD.
 */
public interface AfiliadoRepository extends JpaRepository<Afiliado, Integer> {

    @Query(value = "SELECT * FROM AFILIADO", nativeQuery = true)
    Collection<Afiliado> darAfiliados();

    @Query(value = "SELECT * FROM AFILIADO WHERE ID_AFILIADO = :id", nativeQuery = true)
    Afiliado darAfiliadoPorId(@Param("id") int id);

    // INSERT
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO AFILIADO (ID_AFILIADO, NOMBRE_AFILIADO, FECHA_NACIMIENTO, TIPO_AFILIACION) "
                 + "VALUES (:id, :nombre, :fechaNac, :tipo)", nativeQuery = true)
    void insertarAfiliado(@Param("id") int id,
                          @Param("nombre") String nombre,
                          @Param("fechaNac") Date fechaNac,
                          @Param("tipo") String tipoAfiliacion);

    // UPDATE
    @Modifying
    @Transactional
    @Query(value = "UPDATE AFILIADO "
                 + "SET NOMBRE_AFILIADO = :nombre, FECHA_NACIMIENTO = :fechaNac, TIPO_AFILIACION = :tipo "
                 + "WHERE ID_AFILIADO = :id", nativeQuery = true)
    void actualizarAfiliado(@Param("id") int id,
                            @Param("nombre") String nombre,
                            @Param("fechaNac") Date fechaNac,
                            @Param("tipo") String tipoAfiliacion);

    // DELETE
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM AFILIADO WHERE ID_AFILIADO = :id", nativeQuery = true)
    void eliminarAfiliado(@Param("id") int id);
}
