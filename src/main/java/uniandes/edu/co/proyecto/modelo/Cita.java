package uniandes.edu.co.proyecto.modelo;

import javax.persistence.*;

@Entity
@Table(name = "CITA")
public class Cita {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne @JoinColumn(name = "ID_AGENDA", nullable = false)
    private Agenda agenda;

    @ManyToOne @JoinColumn(name = "ID_ORDEN", nullable = false)
    private OrdenDeServicio orden;

    public Cita() { }
    public Cita(Agenda agenda, OrdenDeServicio orden) {
        this.agenda = agenda;
        this.orden  = orden;
    }

    public Integer getId()     { return id; }
    public Agenda  getAgenda() { return agenda; }
    public OrdenDeServicio getOrden() { return orden; }
}
