package ifc33b.dwesc.gestor_tareas.controller;

import ifc33b.dwesc.gestor_tareas.model.Tasca;
import ifc33b.dwesc.gestor_tareas.service.TascaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasques")
@CrossOrigin(origins = "http://localhost:4200")
public class HomeController {

    @Autowired
    private TascaService tascaService;

    //get
    @GetMapping
    public List<Tasca> getAllTasques() {
        return tascaService.getAllTasques();
    }

    // post
    @PostMapping
    public Tasca createTasca(@RequestBody Tasca tasca) {
        return tascaService.createTasca(tasca);
    }

    // put
    @PutMapping("/{id}")
    public Tasca updateTasca(@PathVariable Long id, @RequestBody Tasca tascaDetails) {
        return tascaService.updateTasca(id, tascaDetails);
    }

    // delete
    @DeleteMapping("/{id}")
    public void deleteTasca(@PathVariable Long id) {
        tascaService.deleteTasca(id);
    }
}
