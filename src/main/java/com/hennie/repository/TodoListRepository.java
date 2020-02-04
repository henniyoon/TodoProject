package com.hennie.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hennie.entity.Todo;
import com.hennie.entity.TodoList;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList, Long> {
    
    List<TodoList> findByTodo(Todo todo);
    

}