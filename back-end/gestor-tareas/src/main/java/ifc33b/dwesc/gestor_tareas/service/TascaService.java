package ifc33b.dwesc.gestor_tareas.service;

import ifc33b.dwesc.gestor_tareas.model.Tasca;
import ifc33b.dwesc.gestor_tareas.repository.TascaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TascaService {

    @Autowired
    private TascaRepository tascaRepository;

    // obtener todas las tareas
    public List<Tasca> getAllTasques() {
        return tascaRepository.findAll();
    }

    // obtener la tarea por ID
    public Optional<Tasca> getTascaById(Long id) {
        return tascaRepository.findById(id);
    }

    // crear nueva tarea
    public Tasca createTasca(Tasca tasca) {
        return tascaRepository.save(tasca);
    }

    // actualizar la tarea
    public Tasca updateTasca(Long id, Tasca tascaDetails) {
        Tasca tasca = tascaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("tasca no trobada amb id: " + id));

        tasca.setTitol(tascaDetails.getTitol());
        tasca.setDescripcio(tascaDetails.getDescripcio());
        tasca.setFeta(tascaDetails.getFeta());

        return tascaRepository.save(tasca);
    }

    // eliminar tarea
    public void deleteTasca(Long id) {
        tascaRepository.deleteById(id);
    }
}
