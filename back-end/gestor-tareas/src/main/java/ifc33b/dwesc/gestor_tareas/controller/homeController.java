package ifc33b.dwesc.gestor_tareas.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public class homeController {
    
    @GetMapping("/api/tasques")
        public String llistaTasques() {
        return null;
        }

    @PostMapping("/api/tasques")
        public String afegirTasca() {
        return null;
        }

    @PutMapping("/api/tasques/{id}")
        public String modificarTasca() {
        return null;
        }

    @DeleteMapping("/api/tasques/{id}")
        public String eliminarTasca() {
        return null;
        }
}
