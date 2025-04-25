package uniandes.edu.co.proyecto.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.sql.Date;

@Entity
@Table(name = "AFILIADO")
public class Afiliado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank                     private String nombre;
    @Past                         private Date   fechaNacimiento;
    @NotBlank                     private String tipoAfiliacion;   // Contributivo | Beneficiario
    @NotBlank                     private String tipoDocumento;
    @NotBlank @Column(unique=true)private String numeroDocumento;

    /** Si es beneficiario → id del afiliado contribuyente */
    private Integer idContribuyente;

    public Afiliado() { }

    public Afiliado(String nombre, Date fechaNacimiento, String tipoAfiliacion,
                    String tipoDocumento, String numeroDocumento, Integer idContribuyente) {
        this.nombre            = nombre;
        this.fechaNacimiento   = fechaNacimiento;
        this.tipoAfiliacion    = tipoAfiliacion;
        this.tipoDocumento     = tipoDocumento;
        this.numeroDocumento   = numeroDocumento;
        this.idContribuyente   = idContribuyente;
    }

    /* ---------- getters & setters ---------- */
    public Integer getId()                 { return id; }
    public void    setId(Integer id)       { this.id = id; }

    public String  getNombre()             { return nombre; }
    public void    setNombre(String n)     { this.nombre = n; }

    public Date    getFechaNacimiento()    { return fechaNacimiento; }
    public void    setFechaNacimiento(Date d){ this.fechaNacimiento = d; }

    public String  getTipoAfiliacion()     { return tipoAfiliacion; }
    public void    setTipoAfiliacion(String t){ this.tipoAfiliacion = t; }

    public String  getTipoDocumento()      { return tipoDocumento; }
    public void    setTipoDocumento(String t){ this.tipoDocumento = t; }

    public String  getNumeroDocumento()    { return numeroDocumento; }
    public void    setNumeroDocumento(String n){ this.numeroDocumento = n; }

    public Integer getIdContribuyente()    { return idContribuyente; }
    public void    setIdContribuyente(Integer id){ this.idContribuyente = id; }
}
