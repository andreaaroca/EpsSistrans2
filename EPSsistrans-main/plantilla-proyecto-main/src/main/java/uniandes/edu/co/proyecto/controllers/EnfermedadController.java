package uniandes.edu.co.proyecto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.Enfermedad;
import uniandes.edu.co.proyecto.services.EnfermedadService;

import java.util.List;

@RestController
@RequestMapping("/enfermedades")
public class EnfermedadController {

    @Autowired
    private EnfermedadService enfermedadService;

    @GetMapping
    public ResponseEntity<List<Enfermedad>> getAllEnfermedades() {
        try {
            return ResponseEntity.ok(enfermedadService.listarEnfermedades());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enfermedad> getEnfermedadById(@PathVariable Integer id) {
        try {
            Enfermedad enf = enfermedadService.obtenerEnfermedad(id);
            if (enf != null) {
                return ResponseEntity.ok(enf);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Enfermedad> createEnfermedad(@RequestBody Enfermedad enfermedad) {
        try {
            Enfermedad creada = enfermedadService.crearEnfermedad(enfermedad);
            return ResponseEntity.status(HttpStatus.CREATED).body(creada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEnfermedad(@PathVariable Integer id) {
        try {
            enfermedadService.eliminarEnfermedad(id);
            return ResponseEntity.ok("Enfermedad eliminada correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error al eliminar la enfermedad.");
        }
    }
}
