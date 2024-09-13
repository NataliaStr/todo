package com.in28min.rest.webservices.todo.controller;

import com.in28min.rest.webservices.todo.entity.TodoEntity;
import com.in28min.rest.webservices.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/users")
public class TodoController {

    @Autowired
    TodoRepository todoRepository;

    @GetMapping("/{username}/todos")
    public List<TodoEntity> getTodos(@PathVariable String username) {
        return todoRepository.findByUsername(username);
    }

    @PostMapping("/{username}/todos")
    public ResponseEntity<Void> createTodo(@PathVariable String username, @RequestBody TodoEntity todoEntity) {
        TodoEntity createdTodo = todoRepository.save(todoEntity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdTodo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{username}/todos/{id}")
    public TodoEntity getTodoById(@PathVariable String username, @PathVariable Long id) {
        return todoRepository.findById(id).orElse(null);
    }

    @PutMapping("/{username}/todos/{id}")
    public ResponseEntity<TodoEntity> updateTodoById(@PathVariable String username, @PathVariable Long id, @RequestBody TodoEntity todoEntity) {
        return new ResponseEntity<>(todoRepository.save(todoEntity), HttpStatus.OK);
    }

    @PatchMapping("/{username}/todos/{id}")
    public ResponseEntity<TodoEntity> patchTodoById(@PathVariable String username, @PathVariable Long id, TodoEntity todoEntity) {
        if(todoRepository.findById(id).isEmpty()) return ResponseEntity.notFound().build();

        TodoEntity existingTodoEntity = todoRepository.findById(id).orElse(null);

        if (todoEntity.getDescription() != null) {
            existingTodoEntity.setDescription(todoEntity.getDescription());
        }
        if (todoEntity.getTargetDate() != null) {
            existingTodoEntity.setTargetDate(todoEntity.getTargetDate());
        }
        existingTodoEntity.setDone(todoEntity.isDone());
        return new ResponseEntity<>(todoRepository.save(existingTodoEntity), HttpStatus.OK);
    }

    @DeleteMapping("/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodoById(@PathVariable String username, @PathVariable Long id) {
        if(todoRepository.findById(id).isEmpty()) return ResponseEntity.notFound().build();

        todoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
