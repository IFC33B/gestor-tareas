package ifc33b.dwesc.gestor_tareas.repository;

import ifc33b.dwesc.gestor_tareas.model.Tasca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TascaRepository extends JpaRepository<Tasca, Long> {

}
