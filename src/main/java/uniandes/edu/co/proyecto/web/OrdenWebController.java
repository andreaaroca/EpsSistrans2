package uniandes.edu.co.proyecto.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller @RequestMapping("/web/ordenes")
public class OrdenWebController {

    @GetMapping("/form")
    public String form(){ return "orden_form"; }
}
