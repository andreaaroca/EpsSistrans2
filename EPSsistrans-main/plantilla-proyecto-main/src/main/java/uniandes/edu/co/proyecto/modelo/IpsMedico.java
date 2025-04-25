package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Entidad que representa la tabla IPS_MEDICO usando la PK compuesta IpsMedicoPK.
 */
@Entity
@Table(name = "IPS_MEDICO")
public class IpsMedico {

    @EmbeddedId
    private IpsMedicoPK pk;

    // Otros campos si los hubiera (ej: fechaAsignacion, estado, etc.)
    // private String estado;

    public IpsMedico() {
    }

    public IpsMedico(IpsMedicoPK pk) {
        this.pk = pk;
    }

    public IpsMedicoPK getPk() {
        return pk;
    }

    public void setPk(IpsMedicoPK pk) {
        this.pk = pk;
    }

    // getters y setters de campos adicionales
}
