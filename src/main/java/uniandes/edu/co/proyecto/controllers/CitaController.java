
package uniandes.edu.co.proyecto.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import uniandes.edu.co.proyecto.modelo.Cita;
import uniandes.edu.co.proyecto.services.CitaService;

@RestController @RequestMapping("/citas") @RequiredArgsConstructor
public class CitaController {

    private final CitaService service;

    @PostMapping
    public ResponseEntity<Cita> agendar(@RequestParam Integer idAgenda,
                                        @RequestParam Integer idOrden){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.agendar(idAgenda,idOrden));
    }
}
