package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "MEDICO")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nombre;
    private String registro;

    // Campos adicionales
    private String tipoDocumento;
    private String numeroDocumento;

    // Relación con Especialidad
    @ManyToOne
    @JoinColumn(name = "ID_ESPECIALIDAD")  // FK en la tabla MEDICO
    private Especialidad especialidad;

    public Medico() {
        // Constructor por defecto
    }

    public Medico(String nombre, String registro) {
        this.nombre = nombre;
        this.registro = registro;
    }

    // Getters & Setters

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRegistro() {
        return registro;
    }
    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }
    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return nombre + "|" + registro + "|" + tipoDocumento + "|" + numeroDocumento +
               (especialidad != null ? "|" + especialidad.getNombre() : "");
    }
}
