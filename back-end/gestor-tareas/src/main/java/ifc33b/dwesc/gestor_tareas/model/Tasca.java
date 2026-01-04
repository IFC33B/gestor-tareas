package ifc33b.dwesc.gestor_tareas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tasca")
public class Tasca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String titol;

    @NotBlank
    @Column(nullable = false)
    private String descripcio;

    @Column(nullable = false)
    private boolean feta;

    // Constructor vacío
    public Tasca() {}

    // Constructor para crear tareas nuevas
    public Tasca(String titol, String descripcio) {
        this.titol = titol;
        this.descripcio = descripcio;
        this.feta = false;
    }

    // getters y setters
    public Long getId() {
        return id;
    }
    public String getTitol() {
        return titol;
    }
    public void setTitol(String titol) {
        this.titol = titol;
    }
    public String getDescripcio() {
        return descripcio;
    }
    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }
    public boolean isFeta() {
        return feta;
    }
    public void setFeta(boolean feta) {
        this.feta = feta;
    }

}