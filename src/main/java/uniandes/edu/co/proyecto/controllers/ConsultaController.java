package uniandes.edu.co.proyecto.controllers;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import uniandes.edu.co.proyecto.repositories.*;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.stream.Collectors;
import uniandes.edu.co.proyecto.modelo.*;

@RestController @RequestMapping("/consultas") @RequiredArgsConstructor
public class ConsultaController {

    private final AgendaRepository agendaRepo;
    private final OrdenDeServicioRepository ordenRepo;
    private final ServicioDeSaludRepository servRepo;

    /** RFC2 - top 20 servicios más solicitados en periodo */
    @GetMapping("/top-servicios")
    public List<Map<String,Object>> topServicios(@RequestParam String ini, @RequestParam String fin){
        Date iniD = Date.valueOf(ini);
        Date finD = Date.valueOf(fin);
        Map<Integer, Long> counts = new HashMap<>();
        ordenRepo.findAll().stream()
            .filter(o -> !o.getFechaEmision().before(iniD) && !o.getFechaEmision().after(finD))
            .forEach(o -> counts.merge(o.getServicio().getId(),1L, Long::sum));

        return counts.entrySet().stream()
            .sorted(Map.Entry.<Integer,Long>comparingByValue().reversed())
            .limit(20)
            .map(e -> {
                Map<String,Object> m = new HashMap<>();
                m.put("servicio", servRepo.findById(e.getKey()).map(ServicioDeSalud::getDescripcion).orElse(""));
                m.put("cantidad", e.getValue());
                return m;
            })
            .collect(Collectors.toList());
    }

    /** RFC3 - índice de uso de cada servicio */
    @GetMapping("/indice-uso")
    public List<Map<String,Object>> indiceUso(@RequestParam String ini, @RequestParam String fin){
        Date iniD = Date.valueOf(ini);
        Date finD = Date.valueOf(fin);

        long totalServicios = servRepo.count();
        Map<Integer, Long> counts = new HashMap<>();
        ordenRepo.findAll().stream()
            .filter(o -> !o.getFechaEmision().before(iniD) && !o.getFechaEmision().after(finD))
            .forEach(o -> counts.merge(o.getServicio().getId(),1L, Long::sum));

        List<Map<String,Object>> res = new ArrayList<>();
        servRepo.findAll().forEach(s -> {
            long usados = counts.getOrDefault(s.getId(),0L);
            double indice = totalServicios == 0 ? 0 : (double) usados / totalServicios;
            Map<String,Object> m = new HashMap<>();
            m.put("servicio", s.getDescripcion());
            m.put("usados", usados);
            m.put("indice", indice);
            res.add(m);
        });
        return res;
    }
}
