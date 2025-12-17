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
    @GetMapping
    public int getApiTasques() {
        return 0;
    }
    
    @PostMapping
    public int postApiTasca() {
        return 0;
    }
    
    @PutMapping("/{id}")
    public int putApiTasca() {   
        return 0;
    }

    @DeleteMapping("/{id}")
    public int deleteApiTasca() {
        return 0;
    }
}
