package com.hennie.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hennie.entity.TodoList;
import com.hennie.entity.TodoType;
import com.hennie.repository.TodoListRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TodoListService {
	
	private final TodoListRepository todoListRepository;

	@Transactional
	public void saveTodoList(TodoList todoList) {
		todoListRepository.save(todoList);
	}
	
	public TodoList findOne(Long listId) {
		return todoListRepository.findOne(listId);
	}
	
	public List<TodoList> findTodoLists() {
		return todoListRepository.findAll();		
	}
	
	@Transactional
	public void updateTodoList(Long id, String title, TodoType type) {
		TodoList todoList = todoListRepository.findOne(id);
		todoList.setTitle(title);
		todoList.setType(type);
	}
}
