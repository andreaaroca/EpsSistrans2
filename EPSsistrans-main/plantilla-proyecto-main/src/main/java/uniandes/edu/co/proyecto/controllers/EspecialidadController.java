package uniandes.edu.co.proyecto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.Especialidad;
import uniandes.edu.co.proyecto.services.EspecialidadService;

import java.util.List;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadController {

    @Autowired
    private EspecialidadService especialidadService;

    @GetMapping
    public ResponseEntity<List<Especialidad>> getAllEspecialidades() {
        try {
            return ResponseEntity.ok(especialidadService.listarEspecialidades());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Especialidad> getEspecialidadById(@PathVariable Long id) {
        try {
            Especialidad esp = especialidadService.obtenerEspecialidad(id.intValue());
            if (esp != null) {
                return ResponseEntity.ok(esp);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Especialidad> createEspecialidad(@RequestBody Especialidad especialidad) {
        try {
            Especialidad creada = especialidadService.crearEspecialidad(especialidad);
            return ResponseEntity.status(HttpStatus.CREATED).body(creada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEspecialidad(@PathVariable Long id) {
        try {
            especialidadService.eliminarEspecialidad(id.intValue());
            return ResponseEntity.ok("Especialidad eliminada correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error al eliminar la especialidad.");
        }
    }
}
