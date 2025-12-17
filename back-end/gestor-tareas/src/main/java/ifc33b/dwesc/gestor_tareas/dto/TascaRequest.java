package ifc33b.dwesc.gestor_tareas.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TascaRequest {

    @NotBlank(message = "Es requereis un titol per la tasca")
    private String titol;

    @NotBlank(message = "Es requereis una descripció per la tasca")
    private String descripcio;

    public TascaRequest(String titol, String descripcio) {
        this.titol = titol;
        this.descripcio = descripcio;
    }
}
