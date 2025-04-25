
package uniandes.edu.co.proyecto.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import uniandes.edu.co.proyecto.modelo.IpsServicio;
import uniandes.edu.co.proyecto.services.IpsServicioService;

@RestController
@RequestMapping("/ips/{idIps}/servicios")
@RequiredArgsConstructor
public class IpsServicioController {

    private final IpsServicioService service;

    @PostMapping("/{idServicio}")
    public ResponseEntity<IpsServicio> assign(@PathVariable Integer idIps, @PathVariable Integer idServicio){
        return ResponseEntity.ok(service.asignar(idIps, idServicio));
    }
}
