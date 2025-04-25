package uniandes.edu.co.proyecto.modelo;

import javax.persistence.*;

/**
 * Requerimiento de Calidad (RQ…)
 */
@Entity
@Table(name = "REQUERIMIENTO_CALIDAD")
public class RequerimientoCalidad {

    /* ===================== Atributos ===================== */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;

    private String codigo;
    private String descripcion;

    /* ===================== Constructores ===================== */

    /** Constructor vacío requerido por JPA */
    public RequerimientoCalidad() { }

    /** Conveniente para crear/actualizar desde código */
    public RequerimientoCalidad(Long id, String codigo, String descripcion) {
        this.id          = id;
        this.codigo      = codigo;
        this.descripcion = descripcion;
    }

    /* ===================== Getters & Setters ===================== */

    public Long   getId() { return id; }
    public void   setId(Long id) { this.id = id; }

    public String getCodigo() { return codigo; }
    public void   setCodigo(String codigo) { this.codigo = codigo; }

    public String getDescripcion() { return descripcion; }
    public void   setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
