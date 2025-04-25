package uniandes.edu.co.proyecto.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import uniandes.edu.co.proyecto.modelo.RequerimientoFuncional;
import uniandes.edu.co.proyecto.services.RequerimientoFuncionalService;

@Controller
@RequestMapping("/rf")
@RequiredArgsConstructor
public class RequerimientoFuncionalController {

    private final RequerimientoFuncionalService service;

    /* ---------- Formulario web ---------- */
    @GetMapping("/form")
    public String form() { return "rf_form"; }

    /* ---------- Crear ---------- */
    @PostMapping
    public String add(@RequestParam String codigo,
                      @RequestParam String descripcion,
                      RedirectAttributes ra) {
        service.registrar(new RequerimientoFuncional(null,codigo,descripcion));
        ra.addFlashAttribute("message","RF creada");
        return "redirect:/";
    }

    /* ---------- Actualizar (AJAX) ---------- */
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Void> update(@PathVariable Long id,
                                       @RequestBody RequerimientoFuncional body) {
        var rf = service.findAll().stream()
                        .filter(r -> r.getId().equals(id))
                        .findFirst()
                        .orElseThrow();
        rf.setCodigo(body.getCodigo());
        rf.setDescripcion(body.getDescripcion());
        service.registrar(rf);
        return ResponseEntity.ok().build();
    }
}
