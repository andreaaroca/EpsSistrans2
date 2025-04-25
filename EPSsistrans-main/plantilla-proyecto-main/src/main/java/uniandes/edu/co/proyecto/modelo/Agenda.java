package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Entidad que representa la tabla AGENDA, 
 * usando la PK compuesta (AgendaPK) que incluye IpsMedico + fechaHora.
 */
@Entity
@Table(name = "AGENDA")
public class Agenda {

    @EmbeddedId
    private AgendaPK pk;

    private String estado; // Campo adicional

    public Agenda() {
    }

    public Agenda(AgendaPK pk, String estado) {
        this.pk = pk;
        this.estado = estado;
    }

    public AgendaPK getPk() {
        return pk;
    }

    public void setPk(AgendaPK pk) {
        this.pk = pk;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Agenda [pk=" + pk + ", estado=" + estado + "]";
    }
}
