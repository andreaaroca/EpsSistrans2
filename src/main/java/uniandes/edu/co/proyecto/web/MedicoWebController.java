package uniandes.edu.co.proyecto.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uniandes.edu.co.proyecto.modelo.Medico;
import uniandes.edu.co.proyecto.services.MedicoService;

import java.util.List;
import java.util.Map;

@Controller @RequestMapping("/web/medicos") @RequiredArgsConstructor
public class MedicoWebController {

    private final MedicoService service;

    @GetMapping
    public String list(Model model){
        List<Medico> list = service.findAll();
        model.addAttribute("titleTable","Médicos");
        model.addAttribute("headers", List.of("ID","Nombre","Registro","TipoDoc","NumDoc"));
        model.addAttribute("rows", list.stream()
                .map(m -> List.of(m.getId(), m.getNombre(), m.getRegistro(),
                                  m.getTipoDocumento(), m.getNumeroDocumento()))
                .toList());
        model.addAttribute("addLink","/web/medicos/new");
        return "list";
    }

    @GetMapping("/new")
    public String form(Model model){
        model.addAttribute("titleForm","Registrar Médico");
        model.addAttribute("postUrl","/medicos");
        model.addAttribute("fields", List.of(
            Map.of("label","Nombre","name","nombre"),
            Map.of("label","Registro","name","registro"),
            Map.of("label","Tipo Documento","name","tipoDocumento"),
            Map.of("label","Número Documento","name","numeroDocumento")
        ));
        return "form";
    }
}
