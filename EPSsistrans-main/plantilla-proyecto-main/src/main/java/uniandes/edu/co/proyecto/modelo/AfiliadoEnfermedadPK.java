package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class AfiliadoEnfermedadPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "ID_AFILIADO", referencedColumnName = "id")
    private Afiliado afiliado;

    @ManyToOne
    @JoinColumn(name = "ID_ENFERMEDAD", referencedColumnName = "id")
    private Enfermedad enfermedad;

    public AfiliadoEnfermedadPK() {
        super();
    }

    public AfiliadoEnfermedadPK(Afiliado afiliado, Enfermedad enfermedad) {
        super();
        this.afiliado = afiliado;
        this.enfermedad = enfermedad;
    }

    public Afiliado getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(Afiliado afiliado) {
        this.afiliado = afiliado;
    }

    public Enfermedad getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(Enfermedad enfermedad) {
        this.enfermedad = enfermedad;
    }
}
