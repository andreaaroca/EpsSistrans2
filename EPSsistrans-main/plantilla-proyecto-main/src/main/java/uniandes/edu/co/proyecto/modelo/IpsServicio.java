package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "IPS_SERVICIO")
public class IpsServicio {

    @EmbeddedId
    private IpsServicioPK pk;  // Clave compuesta (Ips + ServicioDeSalud)

    // Campos adicionales si existieran (por ejemplo, fechaContrato)
    // private Date fechaContrato;

    public IpsServicio() {
        // Constructor por defecto
    }

    public IpsServicio(IpsServicioPK pk) {
        this.pk = pk;
    }

    public IpsServicioPK getPk() {
        return pk;
    }

    public void setPk(IpsServicioPK pk) {
        this.pk = pk;
    }

    @Override
    public String toString() {
        return "IpsServicio [pk=" + pk + "]";
    }
}
