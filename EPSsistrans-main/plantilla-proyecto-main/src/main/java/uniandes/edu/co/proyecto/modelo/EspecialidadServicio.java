package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ESPECIALIDAD_SERVICIO")
public class EspecialidadServicio {

    @EmbeddedId
    private EspecialidadServicioPK pk; // Clave compuesta (Especialidad + ServicioDeSalud)

    // Campos extra si los hubiera

    public EspecialidadServicio() {
        // Constructor por defecto
    }

    public EspecialidadServicio(EspecialidadServicioPK pk) {
        this.pk = pk;
    }

    public EspecialidadServicioPK getPk() {
        return pk;
    }

    public void setPk(EspecialidadServicioPK pk) {
        this.pk = pk;
    }

    @Override
    public String toString() {
        return "EspecialidadServicio [pk=" + pk + "]";
    }
}
