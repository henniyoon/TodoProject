package com.hennie.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hennie.domain.TodoType;
import com.hennie.dto.view.TodoListDto;
import com.hennie.dto.view.TodoListFormDto;
import com.hennie.entity.Todo;
import com.hennie.entity.TodoList;
import com.hennie.service.TodoListService;
import com.hennie.service.TodoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TodoListController {
	
	private final TodoService todoService;
	private final TodoListService todoListService;
	
	// TodoList 등록	
	@PostMapping("/todoList/{todoId}/new")
	public String create(@PathVariable("todoId") Long todoId, @Valid TodoListFormDto form, BindingResult result, Model model) {
		if(result.hasErrors())
			return "todoList/" + todoId + "/new"; 
		TodoList todoList = new TodoList();
		Todo todo = todoService.findOne(todoId);
		todoList.setTodo(todo);
		todoList.setTitle(form.getTitle());
		todoList.setType(TodoType.TODO);
		
		todoListService.saveTodoList(todoList);
		return "redirect:/todo/" + todoId;
	}
	
	// TodoList
	@GetMapping("/todo/{todoId}")
	public String list(@PathVariable("todoId") Long todoId, Model model) {
		Todo todo = todoService.findOne(todoId);
		
		model.addAttribute("todo", new TodoListDto(todo));
		
		return "todoList/todoList";
	}
	
	// TodoList 1개 삭제
	@GetMapping("/todoList/{todoId}/{listId}/delete")
	public String deleteTodoList(@PathVariable("todoId") Long todoId, @PathVariable("listId") Long listId) {
		// Field
		boolean isDeleted;
		
		// Process
		isDeleted = todoListService.deleteTodoList(listId);
		
		// Redirect
		if (isDeleted)
			return "redirect:/todo/" + todoId;
		else
			return "redirect:/todoList?error";
	}
	
	// Todo 삭제
	@GetMapping("/todo/{todoId}/delete")
	public String deleteTodo(@PathVariable("todoId") Long todoId) {
		// Field
		boolean isDeletedList;
		boolean isDeletedTodo;
		
		// Process
		isDeletedList = todoListService.deleteTodoListAll(todoId);
		
		if (isDeletedList)
			isDeletedTodo = todoService.deleteTodo(todoId);
		else
			return "redirect:/todo?error";
		
		return "redirect:/todo";
		
	}

}
