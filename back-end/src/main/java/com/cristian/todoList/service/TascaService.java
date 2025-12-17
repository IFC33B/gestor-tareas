package com.cristian.todoList.service;

import com.cristian.todoList.entity.Tasca;
import com.cristian.todoList.repository.TascaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TascaService {

    @Autowired
    private TascaRepository tascaRepository;

    //Obtener todas las tascas
    public List<Tasca> obtenerTodas() {
        return tascaRepository.findAll();
    }

    //Añadimos una tasca a la ddbb
    public Tasca crearTasca(Tasca tasca) {
        return tascaRepository.save(tasca);
    }

    public void eliminarTasca(Long id) {
        tascaRepository.deleteById(id);
    }
}
