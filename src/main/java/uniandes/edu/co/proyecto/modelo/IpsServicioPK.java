
package uniandes.edu.co.proyecto.modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class IpsServicioPK implements Serializable {

    @Column(name = "ID_IPS")
    private Integer idIps;

    @Column(name = "ID_SERVICIO")
    private Integer idServicio;

    public IpsServicioPK() {}

    public IpsServicioPK(Integer idIps, Integer idServicio) {
        this.idIps = idIps;
        this.idServicio = idServicio;
    }

    public Integer getIdIps() { return idIps; }
    public void setIdIps(Integer idIps) { this.idIps = idIps; }

    public Integer getIdServicio() { return idServicio; }
    public void setIdServicio(Integer idServicio) { this.idServicio = idServicio; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IpsServicioPK)) return false;
        IpsServicioPK that = (IpsServicioPK) o;
        return Objects.equals(idIps, that.idIps) && Objects.equals(idServicio, that.idServicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idIps, idServicio);
    }
}
