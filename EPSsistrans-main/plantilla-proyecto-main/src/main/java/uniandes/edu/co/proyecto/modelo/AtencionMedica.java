package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "ATENCION_MEDICA")
public class AtencionMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String diagnostico;
    private String resultados;

    // Nuevo campo para almacenar la fecha
    private Date fecha;

    // Constructor por defecto
    public AtencionMedica() {
    }

    // Constructor con parámetros
    public AtencionMedica(String diagnostico, String resultados, Date fecha) {
        this.diagnostico = diagnostico;
        this.resultados = resultados;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getResultados() {
        return resultados;
    }

    public void setResultados(String resultados) {
        this.resultados = resultados;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "AtencionMedica{" +
                "id=" + id +
                ", diagnostico='" + diagnostico + '\'' +
                ", resultados='" + resultados + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}
