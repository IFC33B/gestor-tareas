package daw.dwes.llistaTasques.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tasques")
public class Tasca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titol;

    @Column(nullable = false)
    private String descripcio;

    @Column(nullable = false)
    private boolean feta;

    public Tasca() {
        
    }

    public Tasca(String titol, String descripcio) {
        this.setTitol(titol);
        this.setDescripcio(descripcio);
        this.setFeta(false);
    }
}
