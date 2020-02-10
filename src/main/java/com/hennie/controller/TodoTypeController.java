package com.hennie.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hennie.entity.TodoList;
import com.hennie.service.TodoListService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TodoTypeController {
	
	private final TodoListService todoListService;
	
	@GetMapping("/todo/update/type/{listId}")
	public String updateTodo(@PathVariable("listId") Long listId, Model model) {
		TodoList todoList = (TodoList) todoListService.findOne(listId);
		
		TodoListForm form = new TodoListForm();
		form.setType(todoList.getType());
		
		model.addAttribute("form", form);
		
		return null ;
	}

}
