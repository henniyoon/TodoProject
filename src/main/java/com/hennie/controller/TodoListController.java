package com.hennie.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hennie.entity.Todo;
import com.hennie.entity.TodoList;
import com.hennie.service.TodoListService;
import com.hennie.service.TodoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TodoListController {
	
	private final TodoListService todoListService;
	
	@GetMapping("/todo/{todoId}")
	public String list(@PathVariable("todoId") Long todoId, Model model) {
		TodoList todolist = (TodoList) todoListService.findOne(todoId);
		List<TodoList> todoLists = todoListService.findTodoLists();
		model.addAttribute("todoLists", todoLists);
		return "todoList/todoList";
	}
	

}
