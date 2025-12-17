package ifc33b.dwesc.gestor_tareas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifc33b.dwesc.gestor_tareas.model.Tasca;
import ifc33b.dwesc.gestor_tareas.service.TascaService;

// @Autowired()
@RestController
@RequestMapping("/api")
public class HomeController {

    @Autowired
    private TascaService tascaService;

    @GetMapping("/test")
    public String getApiTest() {
        return new Tasca("test", "test").toString();
    }

    @GetMapping("/tasques") // Devolver todas las tareas
    public List<Tasca> getApiTasques() {
        return tascaService.getAllTasques();
    }

    @PostMapping("/tasques") // Crear tarea
    public String postApiTasques() {
        return null;
    }

    @PutMapping("/tasques/{id}") // Editar tarea (Estado, titulo...)
    public String putApiTasques() {
        return null;
    }

    @DeleteMapping("/tasques/{id}") // Elimina una tarea
    public String deleteApiTasques() {
        return null;
    }

}
