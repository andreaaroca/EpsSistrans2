package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CITA_BASE")
public class Cita {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private Date fechaCita;
    private String horaCita;

    public Cita() {
        // Constructor por defecto
    }

    public Cita(Date fechaCita, String horaCita) {
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(String horaCita) {
        this.horaCita = horaCita;
    }

    @Override
    public String toString() {
        return fechaCita + "|" + horaCita;
    }
}
