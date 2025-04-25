
package uniandes.edu.co.proyecto.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import uniandes.edu.co.proyecto.modelo.AtencionMedica;
import uniandes.edu.co.proyecto.services.AtencionService;

@RestController @RequestMapping("/prestaciones") @RequiredArgsConstructor
public class AtencionController {

    private final AtencionService service;

    @PostMapping
    public ResponseEntity<AtencionMedica> registrar(@RequestParam Integer idCita,
                                                    @RequestParam String dx,
                                                    @RequestParam String resultados){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.registrar(idCita,dx,resultados));
    }
}
