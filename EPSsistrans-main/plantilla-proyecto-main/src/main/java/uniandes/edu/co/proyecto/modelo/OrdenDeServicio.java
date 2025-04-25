package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ORDEN_BASE")
public class OrdenDeServicio {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private Date fechaEmision;

    // Relación con Afiliado
    @ManyToOne
    @JoinColumn(name = "ID_AFILIADO")
    private Afiliado afiliado;

    // Relación con Medico
    @ManyToOne
    @JoinColumn(name = "ID_MEDICO")
    private Medico medico;

    // Relación con ServicioSalud
    // (o un simple Integer si es un ID suelto)
    private Integer idServicio;

    // Si quieres un campo "estado"
    // private String estado;

    public OrdenDeServicio() {}

    public OrdenDeServicio(Date fechaEmision, Afiliado afiliado, Medico medico, Integer idServicio) {
        this.fechaEmision = fechaEmision;
        this.afiliado = afiliado;
        this.medico = medico;
        this.idServicio = idServicio;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }
    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Afiliado getAfiliado() {
        return afiliado;
    }
    public void setAfiliado(Afiliado afiliado) {
        this.afiliado = afiliado;
    }

    public Medico getMedico() {
        return medico;
    }
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Integer getIdServicio() {
        return idServicio;
    }
    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    // public String getEstado() { ... }
    // public void setEstado(String estado) { ... }

    @Override
    public String toString() {
        return fechaEmision + "|" 
               + (afiliado != null ? afiliado.getId() : "sinAfiliado") + "|"
               + (medico != null ? medico.getId() : "sinMedico") + "|"
               + idServicio;
    }
}
