package ifc33b.dwesc.gestor_tareas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ifc33b.dwesc.gestor_tareas.model.Tasca;

@Repository
// @Autowired
public interface TascaRepository extends JpaRepository<Tasca, Long> {

}
