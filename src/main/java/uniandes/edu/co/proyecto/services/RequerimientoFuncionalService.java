package uniandes.edu.co.proyecto.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uniandes.edu.co.proyecto.modelo.RequerimientoFuncional;
import uniandes.edu.co.proyecto.repositories.RequerimientoFuncionalRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RequerimientoFuncionalService {

    private final RequerimientoFuncionalRepository repo;

    public List<RequerimientoFuncional> findAll() {
        return repo.findAll();
    }

    public RequerimientoFuncional registrar(RequerimientoFuncional rf) {
        return repo.save(rf);
    }
}