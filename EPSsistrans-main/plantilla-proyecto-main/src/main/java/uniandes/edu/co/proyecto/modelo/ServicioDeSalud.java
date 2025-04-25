package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="SERVICIO_SALUD")
public class ServicioDeSalud {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String descripcion;

    public ServicioDeSalud(){
        // Constructor por defecto
    }

    public ServicioDeSalud(String descripcion){
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    @Override
    public String toString(){
        return id + "|" + descripcion;
    }
}
