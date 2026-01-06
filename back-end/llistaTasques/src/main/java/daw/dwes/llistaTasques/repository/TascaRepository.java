package daw.dwes.llistaTasques.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import daw.dwes.llistaTasques.model.Tasca;

@Repository
public interface TascaRepository extends JpaRepository<Tasca,Long> {

    
}
