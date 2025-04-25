
package uniandes.edu.co.proyecto.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "IPS", uniqueConstraints = @UniqueConstraint(columnNames = "nit"))
public class Ips {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String direccion;

    @NotBlank
    @Pattern(regexp="^[0-9]{9,10}(-[0-9])?$")
    @Column(nullable = false, unique = true, length = 12)
    private String nit;

    public Ips() {}

    public Ips(String nombre, String direccion, String nit) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.nit = nit;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getNit() { return nit; }
    public void setNit(String nit) { this.nit = nit; }
}
