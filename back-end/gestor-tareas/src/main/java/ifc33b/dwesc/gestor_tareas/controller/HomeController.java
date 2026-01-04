package ifc33b.dwesc.gestor_tareas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/tasques")
public class HomeController {

    // GET /api/tasques
    // devuelve lista de tareas
    @GetMapping
    public int getAll() {
        return 0;
    }

    // POST /api/tasques
    // añade tarea
    @PostMapping
    public int createTasca() {
        return 0;
    }

    // PUT /api/tasques/{id}
    // acutailizar tarea
    @PutMapping("/{id}")
    public int updateTasca() {
        return 0;
    }

    // DELETE /api/tasques/{id}
    @DeleteMapping("/{id}")
    public int deleteTasca() {
        return 0;
    }
}