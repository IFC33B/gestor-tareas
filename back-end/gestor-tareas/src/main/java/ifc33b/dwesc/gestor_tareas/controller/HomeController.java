package ifc33b.dwesc.gestor_tareas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifc33b.dwesc.gestor_tareas.service.TascaService;
import ifc33b.dwesc.gestor_tareas.model.Tasca;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/tasques")
public class HomeController {
    @Autowired
    private TascaService tascaService;

    @GetMapping
    public List<Tasca> llistarTasques() {
        return tascaService.llistarTasques();
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
