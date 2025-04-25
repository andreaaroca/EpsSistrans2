package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;
import java.sql.Timestamp;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;

@Embeddable
public class AgendaPK implements Serializable {

    // Mapeamos la PK compuesta: en la tabla AGENDA
    // existirán 2 columnas: ID_IPS, ID_MEDICO
    // que apuntan a IpsMedico.pk.idIps y IpsMedico.pk.idMedico
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "ID_IPS",     referencedColumnName = "idIps"),
        @JoinColumn(name = "ID_MEDICO",  referencedColumnName = "idMedico")
    })
    private IpsMedico ipsMedico;

    private Timestamp fechaHora;

    public AgendaPK() {
    }

    public AgendaPK(IpsMedico ipsMedico, Timestamp fechaHora) {
        this.ipsMedico = ipsMedico;
        this.fechaHora = fechaHora;
    }

    public IpsMedico getIpsMedico() {
        return ipsMedico;
    }

    public void setIpsMedico(IpsMedico ipsMedico) {
        this.ipsMedico = ipsMedico;
    }

    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Timestamp fechaHora) {
        this.fechaHora = fechaHora;
    }

    // equals / hashCode si la PK incluye ipsMedico + fechaHora
}
