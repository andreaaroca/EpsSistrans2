package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "AFILIADO_ENFERMEDAD")
public class AfiliadoEnfermedad {

    @EmbeddedId
    private AfiliadoEnfermedadPK pk;  // Clave compuesta (Afiliado + Enfermedad)

    private Date fechaDiagnostico;    // Campo adicional

    public AfiliadoEnfermedad() {
        // Constructor por defecto
    }

    public AfiliadoEnfermedad(AfiliadoEnfermedadPK pk, Date fechaDiagnostico) {
        this.pk = pk;
        this.fechaDiagnostico = fechaDiagnostico;
    }

    public AfiliadoEnfermedadPK getPk() {
        return pk;
    }

    public void setPk(AfiliadoEnfermedadPK pk) {
        this.pk = pk;
    }

    public Date getFechaDiagnostico() {
        return fechaDiagnostico;
    }

    public void setFechaDiagnostico(Date fechaDiagnostico) {
        this.fechaDiagnostico = fechaDiagnostico;
    }

    @Override
    public String toString() {
        return "AfiliadoEnfermedad [pk=" + pk + ", fechaDiagnostico=" + fechaDiagnostico + "]";
    }
}
