package ifc33b.dwesc.gestor_tareas.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TascaResponse {
    private Long id;
    private String titol;
    private String descripcio;
    private boolean feta;

    public TascaResponse(Long id, String titol, String descripcio, boolean feta) {
        this.setId(id);
        this.setTitol(titol);
        this.setDescripcio(descripcio);
        this.setFeta(feta);
    }
}
