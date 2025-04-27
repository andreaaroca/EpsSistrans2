
package uniandes.edu.co.proyecto.controllers;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import uniandes.edu.co.proyecto.services.AgendaService;

@RestController @RequestMapping("/agenda") @RequiredArgsConstructor
public class AgendaController {

    private final AgendaService service;

    /** RFC1 disponibilidad servicio 4 semanas 
    @GetMapping("/disponibilidad")
    public List<Map<String, String>> consultarDisponibilidadServicio(@RequestParam Integer idServicio) {
        return service.consultarDisponibilidadServicio(idServicio);
    }
    */

    /** RFC5: Consulta SERIALIZABLE */
    @GetMapping("/disponibilidad-serializable")
    public List<Map<String, String>> consultarAgendaSerializable(
            @RequestParam LocalDateTime fechaInicio,
            @RequestParam LocalDateTime fechaFin,
            @RequestParam(required = false) Long idServicio,
            @RequestParam(required = false) Long idMedico) throws InterruptedException {
        return service.consultarAgendaSerializable(fechaInicio, fechaFin, idServicio, idMedico);
    }
 
    /** RFC6: Consulta READ_COMMITTED */
    @GetMapping("/disponibilidad-readcommitted")
    public List<Map<String, String>> consultarAgendaReadCommitted(
            @RequestParam LocalDateTime  fechaInicio,
            @RequestParam LocalDateTime  fechaFin,
            @RequestParam(required = false) Long idServicio,
            @RequestParam(required = false) Long idMedico) throws InterruptedException {
        return service.consultarAgendaReadCommitted(fechaInicio, fechaFin, idServicio, idMedico);
    }
}
