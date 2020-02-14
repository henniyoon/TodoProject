package com.hennie.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hennie.dto.view.TodoFormDto;
import com.hennie.dto.view.TodoListDto;
import com.hennie.dto.view.TodoListFormDto;
import com.hennie.entity.Todo;
import com.hennie.service.TodoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TodoController {
	
	private final TodoService todoService;
	
	// Todo 등록
	@GetMapping("/todo/new")
	public String createForm(Model model) {
		model.addAttribute("todoFormDto", new TodoFormDto());
		return "todo/createTodoForm";
	}
	
	@PostMapping("/todo/new")
	public String create(@Valid TodoFormDto form, BindingResult result) {
		if(result.hasErrors()) 
			return "todo/createTodoForm"; // 에러가 있으면 다시 todo 등록 폼으로 보냄
		
		Todo todo = new Todo();
		todo.setTitle(form.getTitle());
		todo.setRegdate(LocalDateTime.now());
		todo.setDeadline(form.getDeadline());

		todoService.saveTodo(todo);
		return "redirect:/todo";
	}
	
	// Todo 메인 리스트
	@GetMapping("/todo")
	public String list(Model model) {
		List<Todo> todos = todoService.findTodos();
		List<TodoListDto> todoList = new ArrayList<TodoListDto>();
		
		for(Todo todo : todos) {
			todoList.add(new TodoListDto(todo));
		}
		// 실무에서 더 복잡해졌을 때 엔티티를 뿌리는 것 보단 DTO를 만들어서 필요한 객체만 뿌리는 것을 권장!
		model.addAttribute("todos", todoList);
		
		if(todos.isEmpty()) {
			return "todo/nullTodo";
		}
		return "todo/todo";
	}
	
	// Todo 수정
	@GetMapping("/todo/{todoId}/edit")
	public String updateTodoForm(@PathVariable("todoId") Long todoId, Model model) {
		Todo todo = (Todo) todoService.findOne(todoId);
		
		TodoFormDto form = new TodoFormDto();
		model.addAttribute("todoFormListDto", new TodoListFormDto());
		form.setId(todo.getId());
		form.setTitle(todo.getTitle());
//		form.setRegdate(todo.getRegdate());
		form.setDeadline(todo.getDeadline());
		
		model.addAttribute("form", form);
		return "todo/updateTodoForm";
	}
	
	@PostMapping("/todo/{todoId}/edit")
	public String updateTodo(@PathVariable("todoId") Long todoId, TodoFormDto form) {
		todoService.updateTodo(form.getId(), form.getTitle(), form.getDeadline());
		return "redirect:/todo/" +todoId;
	}
}
