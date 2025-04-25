package uniandes.edu.co.proyecto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.RequiredArgsConstructor;
import uniandes.edu.co.proyecto.services.RequerimientoFuncionalService;
import uniandes.edu.co.proyecto.services.RequerimientoCalidadService;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final RequerimientoFuncionalService rfService;
    private final RequerimientoCalidadService rfcService;

    @GetMapping({"/", "/index.html"})
    public String index(Model model) {
        model.addAttribute("rfs", rfService.findAll());
        model.addAttribute("rfcs", rfcService.findAll());
        return "index";
    }
}