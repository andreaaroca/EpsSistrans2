package uniandes.edu.co.proyecto.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uniandes.edu.co.proyecto.modelo.Afiliado;
import uniandes.edu.co.proyecto.services.AfiliadoService;

import java.util.List;
import java.util.Map;

@Controller @RequestMapping("/web/afiliados") @RequiredArgsConstructor
public class AfiliadoWebController {

    private final AfiliadoService service;

    @GetMapping
    public String list(Model model){
        List<Afiliado> list = service.findAll();
        model.addAttribute("titleTable","Afiliados");
        model.addAttribute("headers", List.of("ID","Nombre","Tipo","NumDoc"));
        model.addAttribute("rows", list.stream()
                .map(a -> List.of(a.getId(), a.getNombre(),
                                  a.getTipoAfiliacion(), a.getNumeroDocumento()))
                .toList());
        model.addAttribute("addLink","/web/afiliados/new");
        return "list";
    }

    @GetMapping("/new")
    public String form(Model model){
        model.addAttribute("titleForm","Registrar Afiliado");
        model.addAttribute("postUrl","/afiliados");
        model.addAttribute("fields", List.of(
            Map.of("label","Nombre","name","nombre"),
            Map.of("label","Fecha Nacimiento (yyyy-mm-dd)","name","fechaNacimiento"),
            Map.of("label","Tipo Afiliación","name","tipoAfiliacion"),
            Map.of("label","Tipo Documento","name","tipoDocumento"),
            Map.of("label","Número Documento","name","numeroDocumento"),
            Map.of("label","ID Contribuyente (opcional)","name","idContribuyente")
        ));
        return "form";
    }
}
