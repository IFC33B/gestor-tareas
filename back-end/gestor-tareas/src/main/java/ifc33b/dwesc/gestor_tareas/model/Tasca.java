package ifc33b.dwesc.gestor_tareas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tasca")
public class Tasca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long id;

    @NotBlank(message = "Es requereix un titol de la tasca")
    @Column(nullable = false)
    @Getter
    @Setter
    private String titol;

    @NotBlank(message = "Es requereix una descripció de la tasca")
    @Column(nullable = false)
    @Getter
    @Setter
    private String descripcio;

    @Column(nullable = false)
    @Getter
    @Setter
    private boolean feta;

    public Tasca(String titol, String descripcio) {
        this.setTitol(titol);
        this.setDescripcio(descripcio);
        this.setFeta(false);
    }
}
