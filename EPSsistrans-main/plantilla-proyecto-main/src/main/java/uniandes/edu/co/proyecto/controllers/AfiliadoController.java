package uniandes.edu.co.proyecto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.Afiliado;
import uniandes.edu.co.proyecto.services.AfiliadoService;

import java.util.List;

@RestController
@RequestMapping("/afiliados")
public class AfiliadoController {

    @Autowired
    private AfiliadoService afiliadoService;

    @GetMapping
    public ResponseEntity<List<Afiliado>> getAllAfiliados() {
        try {
            return ResponseEntity.ok(afiliadoService.listarAfiliados());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Afiliado> getAfiliadoById(@PathVariable Integer id) {
        try {
            Afiliado afiliado = afiliadoService.obtenerAfiliado(id);
            if (afiliado != null) {
                return ResponseEntity.ok(afiliado);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Afiliado> createAfiliado(@RequestBody Afiliado afiliado) {
        try {
            Afiliado creado = afiliadoService.crearAfiliado(afiliado);
            return ResponseEntity.status(HttpStatus.CREATED).body(creado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAfiliado(@PathVariable Integer id) {
        try {
            afiliadoService.eliminarAfiliado(id);
            return ResponseEntity.ok("Afiliado eliminado correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error al eliminar el afiliado.");
        }
    }
}
