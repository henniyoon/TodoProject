package com.hennie.dto.view;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hennie.domain.TodoType;
import com.hennie.entity.Todo;
import com.hennie.entity.TodoList;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TodoListDto {
	private Long todoId;
	private String todoTitle;
	private Date deadline;
	private LocalDateTime regdate;
	private int progressWidth;
	private List<TodoListItemDto> todoListItems;
	
	public TodoListDto(Todo todo) {
		double countTodoDone = 0;
		List<TodoList> todoLists = todo.getTodoLists();
		todoId = todo.getId();
		todoTitle = todo.getTitle();
		deadline = todo.getDeadline();
		regdate = todo.getRegdate();
		todoListItems = new ArrayList<TodoListItemDto>();
		
		for(TodoList todoList : todoLists) {
			todoListItems.add(new TodoListItemDto(todoList)); 
			if(todoList.getType() == TodoType.DONE)
				countTodoDone++;
		}
		
		double countTodoList = todoLists.size();
		
		if(countTodoList == 0) {
			progressWidth = 0;
		}
		else {
			progressWidth = (int)(countTodoDone/countTodoList * 100);
		}
		
	}
	
	@Getter @Setter
	public class TodoListItemDto {
		private Long todoListId;
		private boolean todoDone;
		private String todoListTitle;
		
		public TodoListItemDto(TodoList todoList) {
			todoListId = todoList.getId();
			todoListTitle = todoList.getTitle();
			if(todoList.getType() == TodoType.DONE)
				todoDone = true;
			else
				todoDone = false;
		}
	}
}
