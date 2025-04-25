package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class EspecialidadServicioPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "ID_ESPECIALIDAD", referencedColumnName = "id")
    private Especialidad especialidad;

    @ManyToOne
    @JoinColumn(name = "ID_SERVICIO", referencedColumnName = "id")
    private ServicioDeSalud servicio;

    public EspecialidadServicioPK() {
        super();
    }

    public EspecialidadServicioPK(Especialidad especialidad, ServicioDeSalud servicio) {
        super();
        this.especialidad = especialidad;
        this.servicio = servicio;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public ServicioDeSalud getServicio() {
        return servicio;
    }

    public void setServicio(ServicioDeSalud servicio) {
        this.servicio = servicio;
    }
}
