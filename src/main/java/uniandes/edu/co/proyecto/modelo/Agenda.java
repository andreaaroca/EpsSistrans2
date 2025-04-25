package uniandes.edu.co.proyecto.modelo;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "AGENDA")
public class Agenda {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private LocalDateTime fechaHora;

    @ManyToOne @JoinColumn(name = "ID_IPS",      nullable = false) private Ips             ips;
    @ManyToOne @JoinColumn(name = "ID_MEDICO",   nullable = false) private Medico          medico;
    @ManyToOne @JoinColumn(name = "ID_SERVICIO", nullable = false) private ServicioDeSalud servicio;

    /** DISPONIBLE | OCUPADO */
    private String estado = "DISPONIBLE";

    public Agenda() { }

    public Agenda(LocalDateTime fechaHora, Ips ips, Medico medico, ServicioDeSalud servicio) {
        this.fechaHora = fechaHora;
        this.ips       = ips;
        this.medico    = medico;
        this.servicio  = servicio;
    }

    /* ---------- getters & setters ---------- */
    public Integer        getId()          { return id; }
    public LocalDateTime  getFechaHora()   { return fechaHora; }
    public void           setFechaHora(LocalDateTime h){ this.fechaHora = h; }

    public Ips            getIps()        { return ips; }
    public Medico         getMedico()     { return medico; }
    public ServicioDeSalud getServicio()   { return servicio; }

    public String getEstado()             { return estado; }
    public void   setEstado(String e)     { this.estado = e; }
}
