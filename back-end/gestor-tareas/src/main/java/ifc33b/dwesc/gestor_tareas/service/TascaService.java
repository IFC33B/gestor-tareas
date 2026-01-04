package ifc33b.dwesc.gestor_tareas.service;

import ifc33b.dwesc.gestor_tareas.model.Tasca;
import ifc33b.dwesc.gestor_tareas.repository.TascaRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

// logica de negocio
@Service
public class TascaService {

    // permite usar el repositorio de la BBDD
    @Autowired
    private final TascaRepository repository;

    // constructor
    public TascaService(TascaRepository repository) {
        this.repository = repository;
    }

    // método listar tasques
    public List<Tasca> findAll() {
        return repository.findAll();
    }

}