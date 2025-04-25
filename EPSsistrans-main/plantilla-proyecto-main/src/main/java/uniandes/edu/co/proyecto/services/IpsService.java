package uniandes.edu.co.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uniandes.edu.co.proyecto.modelo.Ips;
import uniandes.edu.co.proyecto.repositories.IpsRepository;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para manejar la lógica de negocio de Ips.
 */
@Service
public class IpsService {

    @Autowired
    private IpsRepository ipsRepository;

    public List<Ips> listarTodas() {
        return ipsRepository.findAll();
    }

    public Optional<Ips> obtenerIpsPorId(Integer id) {
        return ipsRepository.findById(id);
    }

    public Ips guardarIps(Ips ips) {
        if (ips.getNombre() == null || ips.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la IPS no puede ser nulo o vacío.");
        }
        return ipsRepository.save(ips);
    }

    public void eliminarIps(Integer id) {
        ipsRepository.deleteById(id);
    }
}
