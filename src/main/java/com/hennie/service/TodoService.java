package com.hennie.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
	public Todo findOne(Long id) {
		// Field
		Optional<Todo> optTodo;

		// Init
		optTodo = todoRepository.findById(id);

		// Exception
		if (!optTodo.isPresent())
			return null;
		
		return optTodo.get();
	}
	
	// Todo 전체 조회
	public List<Todo> findTodos() {
		return todoRepository.findAll();
	}
	
	/**
	 * Todo 수정 (영속성 컨텍스트가 자동 변경)
	 */
	@Transactional
	public void updateTodo(Long id, String title, Date deadline) {
		// Field
		Optional<Todo> optTodo = todoRepository.findById(id);
		Todo todo;
		
		// Exception
		if (!optTodo.isPresent()) // 검색된 데이터가 없으면
			return; // 응 반영 못해~~
		
		// Load
		todo = optTodo.get(); // todo 객체 받아옴

		todo.setTitle(title);
		todo.setDeadline(deadline);
	}
	
	// Todo 삭제
	@Transactional
	public boolean deleteTodo(Long id) {
		// Field
		Optional<Todo> optTodo;

		// Init
		optTodo = todoRepository.findById(id);

		// Exception
		if (!optTodo.isPresent())
			return false;
		
		// DB - Delete
		todoRepository.delete(optTodo.get()); // delete 메서드에 todo 객체 넘겨주면 삭제됨
		return true;
	}

}
