package ifc33b.dwesc.gestor_tareas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifc33b.dwesc.gestor_tareas.dto.TascaRequest;
import ifc33b.dwesc.gestor_tareas.dto.TascaResponse;
import ifc33b.dwesc.gestor_tareas.exception.TascaNotFoundException;
import ifc33b.dwesc.gestor_tareas.model.Tasca;
import ifc33b.dwesc.gestor_tareas.repository.TascaRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class TascaService {

    @Autowired
    public final TascaRepository tascaRepository;

    public TascaService(TascaRepository tascaRepository) {
        this.tascaRepository = tascaRepository;
    }

    // Obtener todas las tareas
    public List<TascaResponse> getAllTasques() {
        return tascaRepository.findAll().stream().map(TascaResponse::new).collect(Collectors.toList());
    }

    // Crear tarea
    public TascaResponse createTasca(TascaRequest request) {
        Tasca tasca = new Tasca(request.getTitol(), request.getDescripcio());
        Tasca savedTasca = tascaRepository.save(tasca);
        return new TascaResponse(savedTasca);
    }

    // Actualizar tarea
    public TascaResponse updateTasca(Long id, TascaRequest request) {
        Tasca searchedTasca = tascaRepository.findById(id).orElseThrow(() -> new TascaNotFoundException(id));
        searchedTasca.setTitol(request.getTitol());
        searchedTasca.setDescripcio(request.getDescripcio());
        searchedTasca.setFeta(request.isFeta());

        Tasca savedTasca = tascaRepository.save(searchedTasca);
        return new TascaResponse(savedTasca);
    }

    // Borrar tarea
    public Boolean deleteTasca(Long id) {
        if (tascaRepository.existsById(id)) {
            tascaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
