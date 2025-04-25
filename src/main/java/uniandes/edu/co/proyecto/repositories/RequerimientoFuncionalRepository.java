package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.proyecto.modelo.RequerimientoFuncional;

@Repository
public interface RequerimientoFuncionalRepository extends JpaRepository<RequerimientoFuncional, Long> {
}