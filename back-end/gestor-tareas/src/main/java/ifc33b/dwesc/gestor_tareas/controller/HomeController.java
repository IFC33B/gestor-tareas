package ifc33b.dwesc.gestor_tareas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifc33b.dwesc.gestor_tareas.dto.TascaRequest;
import ifc33b.dwesc.gestor_tareas.dto.TascaResponse;
import ifc33b.dwesc.gestor_tareas.model.Tasca;
import ifc33b.dwesc.gestor_tareas.service.TascaService;

// @Autowired()
@RestController
@RequestMapping("/api")
public class HomeController {

    @Autowired
    private TascaService tascaService;

    // Testing route
    @GetMapping("/test")
    public String getApiTest() {
        return new Tasca("test", "test").toString();
    }

    @GetMapping("/tasques") // Devolver todas las tareas
    public ResponseEntity<List<TascaResponse>> getApiTasques() {
        // Service Logic
        List<TascaResponse> tasques = tascaService.getAllTasques();

        // Http Response
        if (tasques.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(tasques, HttpStatus.OK);
        }
    }

    @PostMapping("/tasques") // Crear tarea
    public ResponseEntity<TascaResponse> postApiTasques(@RequestBody TascaRequest tascaRequest) {
        // Service Logic
        TascaResponse tascaResponse = tascaService.createTasca(tascaRequest);

        // Http Response
        return new ResponseEntity<>(tascaResponse, HttpStatus.CREATED);
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
