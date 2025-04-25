
package uniandes.edu.co.proyecto.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "SERVICIO_SALUD", uniqueConstraints = @UniqueConstraint(columnNames = "descripcion"))
public class ServicioDeSalud {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String descripcion;

    public ServicioDeSalud() {}

    public ServicioDeSalud(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
