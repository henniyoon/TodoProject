package com.hennie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hennie.domain.TodoType;
import com.hennie.entity.Todo;
import com.hennie.entity.TodoList;
import com.hennie.repository.TodoListRepository;
import com.hennie.repository.TodoRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TodoListService {
	private final TodoRepository todoRepo;
	private final TodoListRepository todoListRepo;

	// TodoList 저장
	@Transactional
	public void saveTodoList(TodoList todoList) {
		todoListRepo.save(todoList);
	}
	
	// TodoList 1개 조회
	public TodoList findOne(Long id) {
		// Field
		TodoList todoList;
		Optional<TodoList> optTodoList;
		
		// Init
		optTodoList = todoListRepo.findById(id);
		
		// Exception
		if (!optTodoList.isPresent())
			return null;
		
		// Load
		todoList = optTodoList.get();
		
		return todoList;
	}
	
	// TodoList 전체 조회
	public List<TodoList> findTodoLists(Long id) {
		// Field
		List<TodoList> todoList;
		Optional<Todo> optTodo;
		Todo todo;

		// Init
		optTodo = todoRepo.findById(id);

		// Exception
		if (!optTodo.isPresent())
			return null;

		// Load
		todo = optTodo.get();
		
		// DB - Select
		todoList = todoListRepo.findByTodo(todo);

		return todoList;
	}
	
	// TodoList 전체 개수 조회
	public Long countTodoId(Todo todo) {
		Long countList;
		
		countList = todoListRepo.countByTodo(todo);
		
		return countList;
	}
	
	// TodoList TodoType.DONE 개수 조회
	public Long countType(TodoType type) {
		Long countDoneList;
	
		countDoneList = todoListRepo.countByType(TodoType.DONE);
		
		return countDoneList;
	}
	
	
	// TodoList 수정
	@Transactional
	public void updateTodoList(Long id, String title, TodoType type) {
		// Field
		Optional<TodoList> optTodoList = todoListRepo.findById(id);
		TodoList todoList;
		
		// Exception
		if (!optTodoList.isPresent())
			return;
		
		// Load
		todoList = optTodoList.get();
		
		todoList.setTitle(title);
		todoList.setType(type);
	}
	
	// TodoList 타입 수정
	@Transactional
	public Todo updateTodoType(Long id, TodoType type) {
		// Field
		Optional<TodoList> optTodoType = todoListRepo.findById(id);
		TodoList todoList;
		
		// Exception
		if(!optTodoType.isPresent())
			return null;
		
		// Load
		todoList = optTodoType.get();
		
		todoList.setType(type);

		// Return
		return todoList.getTodo();
	}
	
	// TodoList DeletefindById
	@Transactional
	public boolean deleteTodoList(Long id) {
		// Field
		Optional<TodoList> optTodoList;
		
		// Init
		optTodoList = todoListRepo.findById(id);
		
		// Exception
		if (!optTodoList.isPresent())
			return false;
		
		// DB - Delete
		todoListRepo.delete(optTodoList.get());
		return true;
	}
	
	// TodoList DeleteFindByTodo
	@Transactional
	public boolean deleteTodoListAll(Long id) {
		// Field
		Optional<Todo> optTodo;
		Todo todo;
		
		// Init
		optTodo = todoRepo.findById(id);
		
		// Exception
		if (!optTodo.isPresent())
			return false;

		// Load
		todo = optTodo.get();
		
		// DB - Delete - TodoList
		for (TodoList todoList : todo.getTodoLists())
			todoListRepo.delete(todoList);

		// DB - Delete - Todo
		todoRepo.delete(todo);

		// Return
		return true;
	}
}
