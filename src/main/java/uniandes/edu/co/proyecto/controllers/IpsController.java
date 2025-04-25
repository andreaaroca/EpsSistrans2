package uniandes.edu.co.proyecto.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import uniandes.edu.co.proyecto.modelo.Ips;
import uniandes.edu.co.proyecto.services.IpsService;

import javax.validation.Valid;

@Controller
@RequestMapping("/ips")
@RequiredArgsConstructor
public class IpsController {

    private final IpsService service;

    /* -------- REST JSON ---------- */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                 produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Ips> addJson(@RequestBody @Valid Ips ips){
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(service.registrar(ips));
    }

    /* -------- Alta desde formulario ---------- */
    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addWeb(@Valid Ips ips,
                         BindingResult br,
                         RedirectAttributes ra) {

        if (br.hasErrors()) {
            // devolver al formulario mostrando errores
            ra.addFlashAttribute("org.springframework.validation.BindingResult.ips", br);
            ra.addFlashAttribute("ips", ips);
            return "redirect:/web/ips/new";
        }

        try {
            service.registrar(ips);
            ra.addFlashAttribute("message", "IPS registrada correctamente");
        } catch (Exception ex) {
            ra.addFlashAttribute("error", "Error al guardar: " + ex.getMessage());
        }
        return "redirect:/web/ips";
    }
}
