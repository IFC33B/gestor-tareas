package ifc33b.dwesc.gestor_tareas.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public class HomeController {

    @GetMapping("/api/tasques") // Devolver todas las tareas
    public String getApiTasques() {
        return null;
    }

    @PostMapping("/api/tasques") // Crear tarea
    public String postApiTasques() {
        return null;
    }

    @PutMapping("/api/tasques/{id}") // Editar tarea (Estado, titulo...)
    public String putApiTasques() {
        return null;
    }

    @DeleteMapping("/api/tasques/{id}") // Elimina una tarea
    public String deleteApiTasques() {
        return null;
    }

}
