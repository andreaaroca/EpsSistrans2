package uniandes.edu.co.proyecto.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uniandes.edu.co.proyecto.services.IpsService;
import uniandes.edu.co.proyecto.services.ServicioSaludService;

@Controller
@RequestMapping("/web/asignar")
@RequiredArgsConstructor
public class IpsServicioWebController {

    private final IpsService ipsService;
    private final ServicioSaludService servService;

    @GetMapping
    public String form(Model model){
        model.addAttribute("ipses",     ipsService.findAll());
        model.addAttribute("servicios", servService.findAll());
        return "assign_form";
    }
}
