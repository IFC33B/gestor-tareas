package ifc33b.dwesc.gestor_tareas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifc33b.dwesc.gestor_tareas.dto.TascaResponse;
import ifc33b.dwesc.gestor_tareas.model.Tasca;

import ifc33b.dwesc.gestor_tareas.repository.TascaRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class TascaService {
    @Autowired
    private final TascaRepository tascaRepository;

    public TascaService(TascaRepository tascaRepository) {
        this.tascaRepository = tascaRepository;
    }

    public List<Tasca> llistarTasques() {
        return tascaRepository.findAll();
    }

    public TascaResponse afegirTasca(String titol, String descripcio) {
        Tasca savedTasca = tascaRepository.save(new Tasca(titol, descripcio));
        TascaResponse tascaResponse = new TascaResponse(savedTasca.getTitol(), savedTasca.getDescripcio());
        return tascaResponse;
    }
}
