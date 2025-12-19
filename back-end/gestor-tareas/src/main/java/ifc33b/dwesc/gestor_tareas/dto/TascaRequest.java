package ifc33b.dwesc.gestor_tareas.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TascaRequest {
    @NotBlank(message = "Requereix un títol")
    private String titol;

    @NotBlank(message = "Requereix una descripció")
    private String descripcio;

    private boolean feta;

    public TascaRequest(String titol, String descripcio, boolean feta) {
        this.setTitol(titol);
        this.setDescripcio(descripcio);
        this.setFeta(feta);
    }
}
