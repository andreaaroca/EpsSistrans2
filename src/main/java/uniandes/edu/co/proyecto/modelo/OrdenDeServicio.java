package uniandes.edu.co.proyecto.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "ORDEN_BASE")
public class OrdenDeServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private Date fechaEmision;

    @ManyToOne @JoinColumn(name = "ID_AFILIADO", nullable = false)
    private Afiliado afiliado;

    @ManyToOne @JoinColumn(name = "ID_MEDICO", nullable = false)
    private Medico medico;

    @ManyToOne @JoinColumn(name = "ID_SERVICIO", nullable = false)
    private ServicioDeSalud servicio;

    public OrdenDeServicio() {}

    public OrdenDeServicio(Date fechaEmision, Afiliado afiliado, Medico medico, ServicioDeSalud servicio) {
        this.fechaEmision = fechaEmision;
        this.afiliado = afiliado;
        this.medico = medico;
        this.servicio = servicio;
    }

    public Date getFechaEmision() { return fechaEmision; }
    public ServicioDeSalud getServicio() { return servicio; }
}
