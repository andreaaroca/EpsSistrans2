
package uniandes.edu.co.proyecto.modelo;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "IPS_SERVICIO")
public class IpsServicio {

    @EmbeddedId
    private IpsServicioPK pk = new IpsServicioPK();

    @ManyToOne
    @MapsId("idIps")
    @JoinColumn(name = "ID_IPS")
    private Ips ips;

    @ManyToOne
    @MapsId("idServicio")
    @JoinColumn(name = "ID_SERVICIO")
    private ServicioDeSalud servicio;

    private LocalDate fechaAsignacion = LocalDate.now();

    public IpsServicio() {}

    public IpsServicio(Ips ips, ServicioDeSalud servicio) {
        this.ips = ips;
        this.servicio = servicio;
        this.pk = new IpsServicioPK(ips.getId(), servicio.getId());
    }

    public IpsServicioPK getPk() { return pk; }
    public Ips getIps() { return ips; }
    public ServicioDeSalud getServicio() { return servicio; }
    public LocalDate getFechaAsignacion() { return fechaAsignacion; }
}
