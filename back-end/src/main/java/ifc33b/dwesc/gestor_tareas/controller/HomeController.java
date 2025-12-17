package ifc33b.dwesc.gestor_tareas.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasques")
public class HomeController {

    @GetMapping
    public String inicio() {
        return "";
    }

    @PostMapping
    public String afegirTasques() {
        return "";
    }

    @PutMapping("/{id}")
    public String actualitzarTasques() {
        return "";
    }

    @DeleteMapping("/{id}")
    public String eliminarTasques() {
        return "";
    }

}
