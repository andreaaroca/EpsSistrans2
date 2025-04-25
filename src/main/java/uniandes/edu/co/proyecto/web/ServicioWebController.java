package uniandes.edu.co.proyecto.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uniandes.edu.co.proyecto.modelo.ServicioDeSalud;
import uniandes.edu.co.proyecto.services.ServicioSaludService;

import java.util.List;
import java.util.Map;

@Controller @RequestMapping("/web/servicios") @RequiredArgsConstructor
public class ServicioWebController {

    private final ServicioSaludService service;

    @GetMapping
    public String list(Model model){
        List<ServicioDeSalud> list = service.findAll();
        model.addAttribute("titleTable","Servicios");
        model.addAttribute("headers", List.of("ID","Descripción"));
        model.addAttribute("rows", list.stream()
                .map(s -> List.of(s.getId(), s.getDescripcion()))
                .toList());
        model.addAttribute("addLink","/web/servicios/new");
        return "list";
    }

    @GetMapping("/new")
    public String form(Model model){
        model.addAttribute("titleForm","Registrar Servicio");
        model.addAttribute("postUrl","/servicios");
        model.addAttribute("fields", List.of(Map.of("label","Descripción","name","descripcion")));
        return "form";
    }
}
