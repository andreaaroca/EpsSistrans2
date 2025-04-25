package uniandes.edu.co.proyecto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.AtencionMedica;
import uniandes.edu.co.proyecto.services.AtencionMedicaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/atencion")
public class AtencionMedicaController {

    @Autowired
    private AtencionMedicaService atencionService;

    @GetMapping
    public ResponseEntity<List<AtencionMedica>> getAllAtenciones() {
        try {
            return ResponseEntity.ok(atencionService.listarTodas());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<AtencionMedica> registerAtencion(@RequestBody AtencionMedica atencion) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(atencionService.guardarAtencion(atencion));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
