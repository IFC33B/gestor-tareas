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
        return "Benvingut al gestor de tasques";
    }

    @PostMapping
    public String afegirTasques() {
        return "Tasques afegides correctament";
    }

    @PutMapping("/{id}")
    public String actualitzarTasques() {
        return "Tasques actualitzades correctament";
    }

    @DeleteMapping("/{id}")
    public String eliminarTasques() {
        return "Tasques eliminades correctament";
    }

}