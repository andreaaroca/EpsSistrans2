
package uniandes.edu.co.proyecto.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import uniandes.edu.co.proyecto.modelo.Medico;
import uniandes.edu.co.proyecto.services.MedicoService;
import java.util.List;

@RestController @RequestMapping("/medicos") @RequiredArgsConstructor
public class MedicoController {

    private final MedicoService service;

    @GetMapping public List<Medico> all(){ return service.findAll(); }

    @PostMapping
    public ResponseEntity<Medico> add(@RequestBody Medico m){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.registrar(m));
    }
}
