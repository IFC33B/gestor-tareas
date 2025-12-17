package ifc33b.dwesc.gestor_tareas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tasques")
public class Tasca{

    //Atributos de la clase Tasca

    //ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Titulo
    @Column(nullable = false)
    private String titol;

    //Descripción
    @Column(nullable = true)
    private String descripcio;

    //Estado
    @Column(nullable = false)
    private String estat;

    

    //Constructores
    public Tasca() {
    }

    public Tasca(Long id, String titol, String descripcio, String estat) {
        this.id = id;
        this.titol = titol;
        this.descripcio = descripcio;
        this.estat = estat;
    }



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

    public String getEstat() {
        return estat;
    }

    public void setEstat(String estat) {
        this.estat = estat;
    }
}