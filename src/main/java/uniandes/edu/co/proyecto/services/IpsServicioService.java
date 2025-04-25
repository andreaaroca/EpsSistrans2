
package uniandes.edu.co.proyecto.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import uniandes.edu.co.proyecto.modelo.*;
import uniandes.edu.co.proyecto.repositories.*;

@Service
@RequiredArgsConstructor
public class IpsServicioService {

    private final IpsRepository ipsRepo;
    private final ServicioDeSaludRepository servRepo;
    private final IpsServicioRepository relRepo;

    @Transactional
    public IpsServicio asignar(Integer idIps, Integer idServ) {
        Ips ips = ipsRepo.findById(idIps).orElseThrow(() -> new IllegalArgumentException("Ips not found with id: " + idIps));
        ServicioDeSalud serv = servRepo.findById(idServ).orElseThrow(() -> new IllegalArgumentException("ServicioDeSalud not found with id: " + idServ));
        IpsServicio rel = new IpsServicio(ips, serv);
        return relRepo.save(rel);
    }
}
