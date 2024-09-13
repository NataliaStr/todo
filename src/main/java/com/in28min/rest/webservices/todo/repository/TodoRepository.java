package com.in28min.rest.webservices.todo.repository;

import com.in28min.rest.webservices.todo.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
    List<TodoEntity> findByUsername(String username);
}
