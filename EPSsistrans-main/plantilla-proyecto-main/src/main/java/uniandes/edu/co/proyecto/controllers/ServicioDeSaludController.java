package uniandes.edu.co.proyecto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.ServicioDeSalud;
import uniandes.edu.co.proyecto.services.ServicioDeSaludService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servicios")
public class ServicioDeSaludController {

    @Autowired
    private ServicioDeSaludService servicioService;

    @GetMapping
    public ResponseEntity<List<ServicioDeSalud>> getAllServices() {
        try {
            return ResponseEntity.ok(servicioService.listarTodos());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicioDeSalud> getServiceById(@PathVariable Integer id) {
        Optional<ServicioDeSalud> servicio = servicioService.obtenerServicioPorId(id);
        return servicio.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @PostMapping
    public ResponseEntity<ServicioDeSalud> createService(@RequestBody ServicioDeSalud servicio) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(servicioService.guardarServicio(servicio));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteService(@PathVariable Integer id) {
        try {
            servicioService.eliminarServicio(id);
            return ResponseEntity.ok("Servicio de salud eliminado correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el servicio.");
        }
    }
}
