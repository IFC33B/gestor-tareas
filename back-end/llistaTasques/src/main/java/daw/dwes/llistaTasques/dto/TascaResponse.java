package daw.dwes.llistaTasques.dto;

import daw.dwes.llistaTasques.model.Tasca;
import lombok.Data;

@Data
public class TascaResponse {
    private Long id;

    private String titol;

    private String descripcio;

    private boolean feta;

    public TascaResponse (Tasca tasca) {
        this.setId(tasca.getId());
        this.setTitol(tasca.getTitol());
        this.setDescripcio(tasca.getDescripcio());
        this.setFeta(tasca.isFeta());
    }
}
