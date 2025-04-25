
package uniandes.edu.co.proyecto.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "MEDICO")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    private String nombre;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String registro;

    @NotBlank
    private String tipoDocumento;

    @NotBlank
    @Column(unique = true)
    private String numeroDocumento;

    public Medico() {}

    public Medico(String nombre, String registro, String tipoDocumento, String numeroDocumento) {
        this.nombre = nombre;
        this.registro = registro;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getRegistro() { return registro; }
    public void setRegistro(String registro) { this.registro = registro; }

    public String getTipoDocumento() { return tipoDocumento; }
    public void setTipoDocumento(String tipoDocumento) { this.tipoDocumento = tipoDocumento; }

    public String getNumeroDocumento() { return numeroDocumento; }
    public void setNumeroDocumento(String numeroDocumento) { this.numeroDocumento = numeroDocumento; }
}
