package daw.dwes.llistaTasques.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import daw.dwes.llistaTasques.dto.TascaRequest;
import daw.dwes.llistaTasques.dto.TascaResponse;
import daw.dwes.llistaTasques.service.TascaService;

@Controller
@RequestMapping("/api/tasques")
@CrossOrigin(origins = "http://localhost:4200")
public class TascaController {

    @Autowired
    private TascaService tascaService;

    @GetMapping
    public ResponseEntity<List<TascaResponse>> getTasques() {
        List<TascaResponse> tasca = tascaService.getTasques();
        return ResponseEntity.ok(tasca);
    }

    @PostMapping
    public ResponseEntity<TascaResponse> createTasca(@RequestBody TascaRequest tascaRequest ) {
        TascaResponse tasca = tascaService.createTasca(tascaRequest);
        return new ResponseEntity<>(tasca, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TascaResponse> updateTasca(@RequestBody TascaRequest tascaRequest, @PathVariable Long id) {
        TascaResponse tasca = tascaService.updateTasca(tascaRequest, id);
        return ResponseEntity.ok(tasca);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTasca(@PathVariable Long id) {
        tascaService.deleteTasca(id);
        return ResponseEntity.noContent().build();
    }
}