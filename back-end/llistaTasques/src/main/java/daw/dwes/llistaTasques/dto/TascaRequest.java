package daw.dwes.llistaTasques.dto;

import lombok.Data;

@Data
public class TascaRequest {
    private String titol;

    private String descripcio;

    private boolean feta;

    public TascaRequest (String titol, String descripcio, boolean feta) {
        this.setTitol(titol);
        this.setDescripcio(descripcio);
        this.setFeta(feta);
    }
}
