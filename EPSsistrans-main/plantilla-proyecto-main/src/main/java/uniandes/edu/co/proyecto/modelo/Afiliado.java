package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="AFILIADO")
public class Afiliado {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String nombre;
    private Date fechaNacimiento;
    private String tipoAfiliacion; // "Contributivo" o "Beneficiario"

    public Afiliado() {
        // Constructor por defecto
    }

    public Afiliado(String nombre, Date fechaNacimiento, String tipoAfiliacion) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoAfiliacion = tipoAfiliacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTipoAfiliacion() {
        return tipoAfiliacion;
    }

    public void setTipoAfiliacion(String tipoAfiliacion){
        this.tipoAfiliacion = tipoAfiliacion;
    }

    @Override
    public String toString() {
        return nombre + "|" + fechaNacimiento + "|" + tipoAfiliacion;
    }
}
