
package uniandes.edu.co.proyecto.services;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import uniandes.edu.co.proyecto.modelo.Afiliado;
import uniandes.edu.co.proyecto.repositories.AfiliadoRepository;

@Service
@RequiredArgsConstructor
public class AfiliadoService {

    private final AfiliadoRepository repo;

    public List<Afiliado> findAll(){ return repo.findAll(); }

    @Transactional
    public Afiliado registrar(Afiliado a){ return repo.save(a); }
}
