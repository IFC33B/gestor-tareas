package ifc33b.dwesc.gestor_tareas.controller;

import ifc33b.dwesc.gestor_tareas.model.Tasca;

import java.util.List;

@RestController
@RequestMapping("/api/tasques")
public class HomeController {

    // GET /api/tasques
    // devuelve lista de tareas
    @GetMapping
    public List<Tasca> getAll() {
        return service.findAll();
    }

    // POST /api/tasques
    // añade tarea
    @PostMapping
    publci Tasca create(@RequestBody Tasca tasca) {
        return service.save(tasca);
    }

    // PUT /api/tasques/{id}
    // acutailizar tarea
    @PutMapping("/{id}")
    public Tasca update(@PathVariable Long id, @RequestBody Tasca tasca) {
        return service.update(id, tasca);
    }

    // DELETE /api/tasques/{id}
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
