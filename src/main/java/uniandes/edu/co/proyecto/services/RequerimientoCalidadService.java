package uniandes.edu.co.proyecto.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uniandes.edu.co.proyecto.modelo.RequerimientoCalidad;
import uniandes.edu.co.proyecto.repositories.RequerimientoCalidadRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RequerimientoCalidadService {

    private final RequerimientoCalidadRepository repo;

    public List<RequerimientoCalidad> findAll() {
        return repo.findAll();
    }

    public RequerimientoCalidad registrar(RequerimientoCalidad rfc) {
        return repo.save(rfc);
    }
}