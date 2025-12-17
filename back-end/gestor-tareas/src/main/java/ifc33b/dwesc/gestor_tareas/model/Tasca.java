package ifc33b.dwesc.gestor_tareas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tasques")
public class Tasca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String titol;
    private String descripcio;
    private Boolean feta = false;

    public Tasca() {}

    //Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getFeta() {
        return feta;
    }

    public void setFeta(Boolean feta) {
        this.feta = feta;
    }
}
