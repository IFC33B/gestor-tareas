package ifc33b.dwesc.gestor_tareas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifc33b.dwesc.gestor_tareas.dto.TascaRequest;
import ifc33b.dwesc.gestor_tareas.dto.TascaResponse;
import ifc33b.dwesc.gestor_tareas.model.Tasca;

import ifc33b.dwesc.gestor_tareas.repository.TascaRepository;

@Service
public class TascaService {
    @Autowired
    private final TascaRepository tascaRepository;

    public TascaService(TascaRepository tascaRepository) {
        this.tascaRepository = tascaRepository;
    }

    // Listar todas las tareas
    public List<TascaResponse> getAllTasques() {
        return tascaRepository.findAll().stream()
                .map(TascaResponse::new)
                .collect(Collectors.toList());
    }

    // Crear tarea
    public TascaResponse createTasca(TascaRequest tascaRequest) {
        Tasca tasca = new Tasca(tascaRequest.getTitol(), tascaRequest.getDescripcio());
        tascaRepository.save(tasca);
        return new TascaResponse(tasca);
    }
}
