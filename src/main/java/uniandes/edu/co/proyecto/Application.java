package uniandes.edu.co.proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

import lombok.RequiredArgsConstructor;  
import uniandes.edu.co.proyecto.modelo.RequerimientoFuncional;
import uniandes.edu.co.proyecto.modelo.RequerimientoCalidad;
import uniandes.edu.co.proyecto.repositories.RequerimientoFuncionalRepository;
import uniandes.edu.co.proyecto.repositories.RequerimientoCalidadRepository;

/**
 * Clase principal de arranque (Spring Boot 2.7 / Java 17)
 */
@SpringBootApplication
@RequiredArgsConstructor
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /* ------------------------------------------------------------------
     * Semilla de datos: se ejecuta 1 vez al iniciar la aplicación
     * ------------------------------------------------------------------ */
    @Bean
    CommandLineRunner seedDatabase(RequerimientoFuncionalRepository rfRepo,
                                   RequerimientoCalidadRepository   rfcRepo) {

        return args -> {

            /* ---------- Requerimientos Funcionales ejemplo ---------- */
            if (rfRepo.count() == 0) {
                rfRepo.save(nuevoRF("RF1", "Registrar IPS"));
                rfRepo.save(nuevoRF("RF2", "Registrar Servicio de Salud"));
                rfRepo.save(nuevoRF("RF3", "Asignar Servicio a IPS"));
            }

            /* ---------- Requerimientos de Calidad ejemplo ---------- */
            if (rfcRepo.count() == 0) {
                rfcRepo.save(nuevoRFC("RQ1", "Disponibilidad ≥ 99.8 %"));
                rfcRepo.save(nuevoRFC("RQ2", "Tiempo máximo de respuesta 2 s"));
            }
        };
    }

    /* Helpers para instanciar entidades sin constructor all-args */
    private RequerimientoFuncional nuevoRF(String cod, String desc) {
        RequerimientoFuncional rf = new RequerimientoFuncional();
        rf.setCodigo(cod); rf.setDescripcion(desc);
        return rf;
    }
    private RequerimientoCalidad nuevoRFC(String cod, String desc) {
        RequerimientoCalidad rfc = new RequerimientoCalidad();
        rfc.setCodigo(cod); rfc.setDescripcion(desc);
        return rfc;
    }
}
