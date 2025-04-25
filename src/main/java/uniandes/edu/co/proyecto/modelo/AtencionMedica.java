
package uniandes.edu.co.proyecto.modelo;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ATENCION_MEDICA")
public class AtencionMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private LocalDateTime fechaHora = LocalDateTime.now();

    @ManyToOne @JoinColumn(name = "ID_CITA", nullable = false)
    private Cita cita;

    private String diagnostico;
    private String resultados;

    public AtencionMedica() {}
    public AtencionMedica(Cita cita, String diagnostico, String resultados) {
        this.cita = cita;
        this.diagnostico = diagnostico;
        this.resultados = resultados;
    }
}
