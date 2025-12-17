package com.cristian.todoList.repository;

import com.cristian.todoList.entity.Tasca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TascaRepository  extends JpaRepository<Tasca,Long> {

}