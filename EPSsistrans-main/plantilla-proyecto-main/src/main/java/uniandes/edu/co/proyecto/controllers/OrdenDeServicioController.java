package uniandes.edu.co.proyecto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.OrdenDeServicio;
import uniandes.edu.co.proyecto.services.OrdenDeServicioService;

import java.util.List;

@RestController
@RequestMapping("/ordenes")  // o "/ordenes-servicio"
public class OrdenDeServicioController {

    @Autowired
    private OrdenDeServicioService ordenService;

    @GetMapping
    public ResponseEntity<List<OrdenDeServicio>> getAllOrdenes() {
        try {
            return ResponseEntity.ok(ordenService.listarOrdenes());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenDeServicio> getOrdenById(@PathVariable Long id) {
        try {
            OrdenDeServicio orden = ordenService.obtenerOrden(id.intValue());
            if (orden != null) {
                return ResponseEntity.ok(orden);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<OrdenDeServicio> createOrden(@RequestBody OrdenDeServicio orden) {
        try {
            OrdenDeServicio creada = ordenService.crearOrdenDeServicio(orden);
            return ResponseEntity.status(HttpStatus.CREATED).body(creada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrden(@PathVariable Long id) {
        try {
            ordenService.eliminarOrden(id.intValue());
            return ResponseEntity.ok("Orden de servicio eliminada correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error al eliminar la orden de servicio.");
        }
    }
}
