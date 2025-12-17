

@Entity
public class Tasca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titol;
    private String descripcio;
    private boolean feta;

    // constructor
    public Tasca() {}

    // constructor con todos los parametros
    public Tasca(String titol, String descripcio, boolean feta) {
        this.titol = titol;
        this.descripcio = descripcio;
        this.feta = feta;
    }

    // getters y setters
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
    public boolean isFeta() {
        return feta;
    }
    public void setFeta(boolean feta) {
        this.feta = feta;
    }

}