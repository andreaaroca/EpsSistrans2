package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Clave compuesta para la entidad IpsMedico.
 * Supongamos que son dos campos: idIps y idMedico
 */
@Embeddable
public class IpsMedicoPK implements Serializable {

    private Integer idIps;
    private Integer idMedico;

    public IpsMedicoPK() {
    }

    public IpsMedicoPK(Integer idIps, Integer idMedico) {
        this.idIps = idIps;
        this.idMedico = idMedico;
    }

    public Integer getIdIps() {
        return idIps;
    }
    public void setIdIps(Integer idIps) {
        this.idIps = idIps;
    }
    public Integer getIdMedico() {
        return idMedico;
    }
    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IpsMedicoPK that)) return false;
        return Objects.equals(idIps, that.idIps)
            && Objects.equals(idMedico, that.idMedico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idIps, idMedico);
    }
}
