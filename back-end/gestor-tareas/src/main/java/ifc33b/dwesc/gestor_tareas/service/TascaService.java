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

    // método crear tasca
    public Tasca saveTasca(Tasca tasca) {
        // instanciar nueva tarea
        Tasca tascaNew = new Tasca(tasca.getTitol(), tasca.getDescripcio());

        // guardar tarea
        return repository.save(tascaNew);
    }

    // método actualizar tarea
    public Tasca updateTasca(Tasca tasca, Long id) {

        // buscar tarea por ID
        Tasca tascaEncontrado = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("No se ha encontrado la tarea con id: " + id)
                );

        // actualizar datos
        tascaEncontrado.setTitol(tasca.getTitol());
        tascaEncontrado.setDescripcio(tasca.getDescripcio());
        tascaEncontrado.setFeta(tasca.isFeta());

        // guardar tarea
        return repository.save(tascaEncontrado);
    }

    // método eliminar tarea
    public void deleteTasca(Long id) {
        // comprobar si tarea existe
        repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("No se ha encontrado la tarea con id: " + id)
                );

        // eliminar tarea
        repository.deleteById(id);
    }

}