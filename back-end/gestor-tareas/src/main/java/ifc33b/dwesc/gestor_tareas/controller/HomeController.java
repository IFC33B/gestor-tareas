package ifc33b.dwesc.gestor_tareas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifc33b.dwesc.gestor_tareas.service.TascaService;
import ifc33b.dwesc.gestor_tareas.dto.TascaRequest;
import ifc33b.dwesc.gestor_tareas.dto.TascaResponse;
import ifc33b.dwesc.gestor_tareas.model.Tasca;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/tasques")
public class HomeController {
    @Autowired
    private TascaService tascaService;

    @GetMapping // Devolver todas las tareas
    public ResponseEntity<List<TascaResponse>> getAllTasques() {
        List<TascaResponse> tasques = tascaService.getAllTasques();
        return ResponseEntity.ok(tasques);
    }
    
    @PostMapping // Crear tarea
    public ResponseEntity<TascaResponse> createTasca(@RequestBody TascaRequest tascaRequest) {
        // Servicio
        TascaResponse tascaResponse = tascaService.createTasca(tascaRequest);

        // HTTP response
        return new ResponseEntity<>(tascaResponse, HttpStatus.CREATED);
    }
    
    // Actualizar tasca
    @PutMapping("/{id}")
    public ResponseEntity<TascaResponse> updateTasca(@RequestBody TascaRequest tascaRequest, @PathVariable Long id) {
        // Servicio
        TascaResponse tascaResponse = tascaService.updateTasca(tascaRequest, id);

        // HTTP response
        return ResponseEntity.ok(tascaResponse);
    }

    @DeleteMapping("/{id}")
    public int deleteApiTasca() {
        return 0;
    }
}
