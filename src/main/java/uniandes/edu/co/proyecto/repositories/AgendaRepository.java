
package uniandes.edu.co.proyecto.repositories;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Integer> {

    /** RFC1: Consultar disponibilidad de un servicio en las próximas 4 semanas 
    @Query(value = 
        "SELECT " +
        "TO_CHAR(a.fechaHora, 'DD/MM/YY') AS fecha, " +
        "TO_CHAR(a.fechaHora, 'HH24:MI') AS hora, " +
        "i.nombre AS ipsNombre, " +
        "m.nombre AS medicoNombre " +
        "FROM Agenda a " +
        "JOIN a.ipsMedico im " +
        "JOIN im.servicio s " +
        "JOIN im.ips i " +
        "JOIN im.medico m " +
        "WHERE s.id = :idServicio " +
        "AND a.estado = 'DISPONIBLE' " +
        "AND a.fechaHora >= CURRENT_TIMESTAMP " +
        "ORDER BY a.fechaHora", 
        nativeQuery = true)
    List<Map<String, String>> consultarDisponibilidadServicio(@Param("idServicio") Integer idServicio);
*/

    /** RFC5 y 6: Consultar disponibilidad de un servicio de salud */
    @Query("SELECT NEW map(" +
        "TO_CHAR(a.fechaHora, 'DD/MM/YYYY HH24:MI:SS') AS FECHA_HORA, " +
        "i.nombre AS IPS_NOMBRE, " +
        "m.nombre AS MEDICO_NOMBRE, " +
        "s.descripcion AS SERVICIO_SALUD_DESCRIPCION" +
        ") " +
        "FROM Agenda a " +
        "JOIN a.ips i " +
        "JOIN a.medico m " +
        "JOIN a.servicio s " +
        "WHERE (:fechaInicio IS NULL OR a.fechaHora >= :fechaInicio) " +
        "AND (:fechaFin IS NULL OR a.fechaHora <= :fechaFin) " +
        "AND (:idServicio IS NULL OR s.id = :idServicio) " +
        "AND (:idMedico IS NULL OR m.id = :idMedico) " +
        "AND a.estado = 'DISPONIBLE'")

        List<Map<String, String>> findAgendaDisponible(
            @Param("fechaInicio") LocalDateTime fechaInicio, 
            @Param("fechaFin") LocalDateTime fechaFin,
            @Param("idServicio") Long idServicio,
            @Param("idMedico") Long idMedico
        );


}
