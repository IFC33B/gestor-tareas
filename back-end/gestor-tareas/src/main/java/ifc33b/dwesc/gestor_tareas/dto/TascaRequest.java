package ifc33b.dwesc.gestor_tareas.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;

@Data
public class TascaRequest {
    @NotBlank(message = "Requereix un títol")
    private String titol;

    @NotBlank(message = "Requereix una descripció")
    private String descripcio;

    public TascaRequest(String titol, String descripcio) {
        this.setTitol(titol);
        this.setDescripcio(descripcio);
    }
}
