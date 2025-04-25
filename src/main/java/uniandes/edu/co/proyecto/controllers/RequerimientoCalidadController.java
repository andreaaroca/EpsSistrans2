package uniandes.edu.co.proyecto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import uniandes.edu.co.proyecto.modelo.RequerimientoCalidad;
import uniandes.edu.co.proyecto.services.RequerimientoCalidadService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.http.ResponseEntity;

@Controller
@RequestMapping("/rfc")
@RequiredArgsConstructor
public class RequerimientoCalidadController {

    private final RequerimientoCalidadService service;

    @GetMapping("/form")
    public String form() { return "rfc_form"; }

    @PostMapping
    public String add(@RequestParam String codigo,
                      @RequestParam String descripcion,
                      RedirectAttributes ra) {
        service.registrar(new RequerimientoCalidad(null,codigo,descripcion));
        ra.addFlashAttribute("message","RFC creada");
        return "redirect:/";
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Void> update(@PathVariable Long id,
                                       @RequestBody RequerimientoCalidad body) {
        var rfc = service.findAll().stream()
                         .filter(r -> r.getId().equals(id))
                         .findFirst()
                         .orElseThrow();
        rfc.setCodigo(body.getCodigo());
        rfc.setDescripcion(body.getDescripcion());
        service.registrar(rfc);
        return ResponseEntity.ok().build();
    }
}
