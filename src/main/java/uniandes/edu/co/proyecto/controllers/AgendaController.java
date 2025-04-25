
package uniandes.edu.co.proyecto.controllers;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;
import uniandes.edu.co.proyecto.modelo.Agenda;
import uniandes.edu.co.proyecto.services.AgendaService;

@RestController @RequestMapping("/agenda") @RequiredArgsConstructor
public class AgendaController {

    private final AgendaService service;

    /** RFC1 disponibilidad servicio 4 semanas */
    @GetMapping("/disponibilidad")
    public List<Agenda> disponibilidad(@RequestParam Integer idServicio){
        return service.disponibilidad(idServicio);
    }
}
