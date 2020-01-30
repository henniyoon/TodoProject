package com.hennie.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hennie.entity.Todo;
import com.hennie.repository.TodoRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TodoService {
	
	private final TodoRepository todoRepository;
	
	// Todo 저장
	@Transactional
	public void saveTodo(Todo todo) {
		todoRepository.save(todo);
	}
	
	// Todo 1개 조회
	public Todo findOne(Long todoId) {
		return todoRepository.findOne(todoId);
	}
	
	// Todo 전체 조회
	public List<Todo> findTodos() {
		return todoRepository.findAll();
	}
	
	/**
	 * 영속성 컨텍스트가 자동 변경
	 */
	@Transactional
	public void updateTodo(Long id, String title, Date deadline) {
		Todo todo = todoRepository.findOne(id);
		todo.setTitle(title);
		todo.setDeadline(deadline);
	}

}
