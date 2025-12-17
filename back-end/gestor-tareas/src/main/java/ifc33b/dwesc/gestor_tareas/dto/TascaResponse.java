package ifc33b.dwesc.gestor_tareas.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TascaResponse {
    @NotBlank(message = "Requereix un títol")
    private String titol;

    @NotBlank(message = "Requereix una descripció")
    private String descripcio;

    public TascaResponse(String titol, String descripcio) {
        this.setTitol(titol);
        this.setDescripcio(descripcio);
    }
}
