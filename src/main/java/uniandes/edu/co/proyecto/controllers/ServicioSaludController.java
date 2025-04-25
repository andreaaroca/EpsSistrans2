
    package uniandes.edu.co.proyecto.controllers;

    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;
    import lombok.RequiredArgsConstructor;
    import uniandes.edu.co.proyecto.modelo.ServicioDeSalud;
    import uniandes.edu.co.proyecto.services.ServicioSaludService;
    import java.util.List;

    @RestController @RequestMapping("/servicios") @RequiredArgsConstructor
    public class ServicioSaludController {

        private final ServicioSaludService service;

        @GetMapping public List<ServicioDeSalud> all(){ return service.findAll(); }

        @PostMapping
        public ResponseEntity<ServicioDeSalud> add(@RequestBody ServicioDeSalud s){
            return ResponseEntity.status(HttpStatus.CREATED).body(service.registrar(s));
        }
    }
