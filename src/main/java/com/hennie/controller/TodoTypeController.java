package com.hennie.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hennie.domain.TodoType;
import com.hennie.dto.ResponseDto;
import com.hennie.service.TodoListService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/rest/v1")
public class TodoTypeController {
	
	private final TodoListService todoListService;
	
	// /api/rest/v1/todo/update/type/1
	@PostMapping("/todo/update/type/{listId}")
	public ResponseDto updateTodoType(@PathVariable("listId") Long listId, @RequestParam("typeId") Integer typeId) {
		// Field
		TodoType todoType;
		
		// Init
		if (typeId == 0)
			todoType = TodoType.TODO;
		else if (typeId == 1)
			todoType = TodoType.DONE;
		else
			todoType = TodoType.TODO;

		// Modify
		if (todoListService.updateTodoType(listId, todoType))
			return new ResponseDto(0, "성공");
		else
			return new ResponseDto(-1, "실패");
	}

}
