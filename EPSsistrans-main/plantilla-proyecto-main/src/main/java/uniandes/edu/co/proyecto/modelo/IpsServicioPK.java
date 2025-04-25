package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class IpsServicioPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "ID_IPS", referencedColumnName = "id")
    private Ips ips;

    @ManyToOne
    @JoinColumn(name = "ID_SERVICIO", referencedColumnName = "id")
    private ServicioDeSalud servicio;

    public IpsServicioPK() {
        super();
    }

    public IpsServicioPK(Ips ips, ServicioDeSalud servicio) {
        super();
        this.ips = ips;
        this.servicio = servicio;
    }

    public Ips getIps() {
        return ips;
    }

    public void setIps(Ips ips) {
        this.ips = ips;
    }

    public ServicioDeSalud getServicio() {
        return servicio;
    }

    public void setServicio(ServicioDeSalud servicio) {
        this.servicio = servicio;
    }
}
