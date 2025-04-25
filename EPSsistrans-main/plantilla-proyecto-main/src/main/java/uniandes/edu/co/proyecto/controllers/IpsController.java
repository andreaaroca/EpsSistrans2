package uniandes.edu.co.proyecto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.Ips;
import uniandes.edu.co.proyecto.services.IpsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ips")
public class IpsController {

    @Autowired
    private IpsService ipsService;

    @GetMapping
    public ResponseEntity<List<Ips>> getAllIps() {
        try {
            return ResponseEntity.ok(ipsService.listarTodas());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ips> getIpsById(@PathVariable Integer id) {
        Optional<Ips> ips = ipsService.obtenerIpsPorId(id);
        return ips.map(ResponseEntity::ok)
                  .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @PostMapping
    public ResponseEntity<Ips> createIps(@RequestBody Ips ips) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(ipsService.guardarIps(ips));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteIps(@PathVariable Integer id) {
        try {
            ipsService.eliminarIps(id);
            return ResponseEntity.ok("IPS eliminada correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar la IPS.");
        }
    }
}
