package ifc33b.dwesc.gestor_tareas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Tasca> getAllTasques() {
        return tascaRepository.findAll();
    }

    // Crear tarea
    // public String createTasca(Tasca request) {
    //     Tasca tasca = new Tasca(request.getTitol(), request.getDescripcio());
    //     Tasca savedTasca = tascaRepository.save(tasca);
    // }
}
