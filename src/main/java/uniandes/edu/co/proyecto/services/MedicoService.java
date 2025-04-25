
package uniandes.edu.co.proyecto.services;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import uniandes.edu.co.proyecto.modelo.Medico;
import uniandes.edu.co.proyecto.repositories.MedicoRepository;

@Service
@RequiredArgsConstructor
public class MedicoService {

    private final MedicoRepository repo;

    public List<Medico> findAll() { return repo.findAll(); }

    public Medico registrar(Medico m) { return repo.save(m); }
}
