package uniandes.edu.co.proyecto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.Eps;
import uniandes.edu.co.proyecto.services.EpsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/eps")
public class EpsController {

    @Autowired
    private EpsService epsService;

    @GetMapping
    public ResponseEntity<List<Eps>> getAllEps() {
        try {
            return ResponseEntity.ok(epsService.listarTodas());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Eps> getEpsById(@PathVariable Integer id) {
        Optional<Eps> eps = epsService.obtenerEpsPorId(id);
        return eps.map(ResponseEntity::ok)
                  .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @PostMapping
    public ResponseEntity<Eps> createEps(@RequestBody Eps eps) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(epsService.guardarEps(eps));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEps(@PathVariable Integer id) {
        try {
            epsService.eliminarEps(id);
            return ResponseEntity.ok("EPS eliminada correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar la EPS.");
        }
    }
}
