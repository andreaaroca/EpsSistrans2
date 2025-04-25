package uniandes.edu.co.proyecto.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uniandes.edu.co.proyecto.services.AgendaService;

@Controller @RequestMapping("/web/agenda") @RequiredArgsConstructor
public class AgendaWebController {

    private final AgendaService service;

    /* Formulario para ingresar idServicio */
    @GetMapping("/buscar")
    public String buscar(Model model){
        model.addAttribute("titleForm","Consultar disponibilidad");
        model.addAttribute("postUrl","#");   // manejado por JS
        model.addAttribute("fields", java.util.List.of(
            java.util.Map.of("label","ID Servicio","name","idServicio")));
        return "agendar_form";
    }
}
