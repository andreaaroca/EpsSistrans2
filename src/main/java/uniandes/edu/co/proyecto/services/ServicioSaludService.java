
package uniandes.edu.co.proyecto.services;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import uniandes.edu.co.proyecto.modelo.ServicioDeSalud;
import uniandes.edu.co.proyecto.repositories.ServicioDeSaludRepository;

@Service
@RequiredArgsConstructor
public class ServicioSaludService {

    private final ServicioDeSaludRepository repo;

    public List<ServicioDeSalud> findAll() { return repo.findAll(); }

    public ServicioDeSalud registrar(ServicioDeSalud s) { return repo.save(s); }
}
