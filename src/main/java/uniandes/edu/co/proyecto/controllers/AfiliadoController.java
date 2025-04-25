
package uniandes.edu.co.proyecto.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import uniandes.edu.co.proyecto.modelo.Afiliado;
import uniandes.edu.co.proyecto.services.AfiliadoService;
import java.util.List;

@RestController @RequestMapping("/afiliados") @RequiredArgsConstructor
public class AfiliadoController {

    private final AfiliadoService service;

    @GetMapping public List<Afiliado> all(){ return service.findAll(); }

    @PostMapping
    public ResponseEntity<Afiliado> add(@RequestBody Afiliado a){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.registrar(a));
    }
}
