package daw.dwes.llistaTasques.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daw.dwes.llistaTasques.dto.TascaRequest;
import daw.dwes.llistaTasques.dto.TascaResponse;
import daw.dwes.llistaTasques.model.Tasca;
import daw.dwes.llistaTasques.repository.TascaRepository;

@Service
public class TascaService {
    @Autowired
    private TascaRepository tascaRepository;

    public List<TascaResponse> getTasques() {
        return tascaRepository.findAll().stream()
        .map(TascaResponse::new)
        .collect(Collectors.toList());
    }

    public TascaResponse createTasca(TascaRequest tascaRequest) {
        Tasca tasca = new Tasca(tascaRequest.getTitol(), tascaRequest.getDescripcio());
        tascaRepository.save(tasca);
        return new TascaResponse(tasca);        
    }

    public TascaResponse updateTasca(TascaRequest tascaRequest, Long id) {
        Tasca tasca = tascaRepository.findById(id)
        .orElseThrow(()->new RuntimeException("id not found"));

        tasca.setTitol(tascaRequest.getTitol());
        tasca.setDescripcio(tascaRequest.getDescripcio());
        tasca.setFeta(tascaRequest.isFeta());

        tascaRepository.save(tasca);

        return new TascaResponse(tasca);
    }

    public void deleteTasca(Long id) {
        if (!tascaRepository.existsById(id)) {
            throw new RuntimeException("tasca not found");
        }
        tascaRepository.deleteById(id);
    }
}
