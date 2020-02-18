package com.hennie.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hennie.domain.TodoType;
import com.hennie.dto.ResponseDto;
import com.hennie.dto.view.TodoListDto;
import com.hennie.entity.Todo;
import com.hennie.service.TodoListService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/rest/v1")
public class TodoTypeController {
	
	private final TodoListService todoListService;
	
	// /api/rest/v1/todo/update/type/1
	@PostMapping("/todo/update/type/{listId}")
	public TodoListDto updateTodoType(@PathVariable("listId") Long listId, @RequestParam("typeId") Integer typeId) {
		// Field
		TodoType todoType;
		Todo todo;
		
		// Init
		if (typeId == 0)
			todoType = TodoType.TODO;
		else if (typeId == 1)
			todoType = TodoType.DONE;
		else
			todoType = TodoType.TODO;

		// Modify
		todo = todoListService.updateTodoType(listId, todoType);
		if(todo == null) 
			return null;
		return new TodoListDto(todo);
	}

}
