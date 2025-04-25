
package uniandes.edu.co.proyecto.services;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import uniandes.edu.co.proyecto.modelo.Ips;
import uniandes.edu.co.proyecto.repositories.IpsRepository;

@Service
@RequiredArgsConstructor
public class IpsService {

    private final IpsRepository repo;

    public List<Ips> findAll() { return repo.findAll(); }

    @Transactional
    public Ips registrar(Ips ips) {
        if (repo.existsById(ips.getId()!=null? ips.getId(): -1))
            throw new IllegalArgumentException("IPS ya existe");
        return repo.save(ips);
    }
}
