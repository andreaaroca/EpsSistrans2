package uniandes.edu.co.proyecto.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uniandes.edu.co.proyecto.modelo.Ips;
import uniandes.edu.co.proyecto.services.IpsService;

import java.util.List;
import java.util.Map;

@Controller @RequestMapping("/web/ips") @RequiredArgsConstructor
public class IpsWebController {

    private final IpsService service;

    @GetMapping
    public String list(Model model){
        List<Ips> list = service.findAll();
        model.addAttribute("titleTable","IPS");
        model.addAttribute("headers", List.of("ID","Nombre","Dirección","NIT"));
        model.addAttribute("rows", list.stream()
                .map(i -> List.of(i.getId(), i.getNombre(), i.getDireccion(), i.getNit()))
                .toList());
        model.addAttribute("addLink","/web/ips/new");
        return "list";
    }

    @GetMapping("/new")
    public String form(Model model){
        model.addAttribute("titleForm","Registrar IPS");
        model.addAttribute("postUrl","/ips");
        model.addAttribute("fields", List.of(
                Map.of("label","Nombre","name","nombre"),
                Map.of("label","Dirección","name","direccion"),
                Map.of("label","NIT","name","nit")));
        return "form";
    }
}
