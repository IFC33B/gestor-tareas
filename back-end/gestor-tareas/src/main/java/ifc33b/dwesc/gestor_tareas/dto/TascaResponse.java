package ifc33b.dwesc.gestor_tareas.dto;

import ifc33b.dwesc.gestor_tareas.model.Tasca;
import lombok.Data;

@Data
public class TascaResponse {

    private Long id;
    private String titol;
    private String descripcio;
    private boolean feta;

    public TascaResponse(Tasca tasca) {
        this.id = tasca.getId();
        this.titol = tasca.getTitol();
        this.descripcio = tasca.getDescripcio();
        this.feta = tasca.isFeta();
    }
}
