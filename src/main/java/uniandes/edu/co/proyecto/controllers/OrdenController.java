
package uniandes.edu.co.proyecto.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import uniandes.edu.co.proyecto.modelo.OrdenDeServicio;
import uniandes.edu.co.proyecto.services.OrdenService;

@RestController @RequestMapping("/ordenes") @RequiredArgsConstructor
public class OrdenController {

    private final OrdenService service;

    @PostMapping
    public ResponseEntity<OrdenDeServicio> emitir(@RequestParam Integer idAfiliado,
                                                  @RequestParam Integer idMedico,
                                                  @RequestParam Integer idServicio){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.emitir(idAfiliado,idMedico,idServicio));
    }
}
