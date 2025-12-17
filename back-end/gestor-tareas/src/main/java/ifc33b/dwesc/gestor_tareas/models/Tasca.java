package ifc33b.dwesc.gestor_tareas.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tasca {
    private Long id;
    private String nom;
    private String descripcio;
    private boolean feta;
}