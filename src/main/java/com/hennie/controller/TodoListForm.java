package com.hennie.controller;

import javax.validation.constraints.NotEmpty;

import com.hennie.entity.TodoType;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TodoListForm {
	
	private Long id;
	
	@NotEmpty(message = "세부 계획을 입력하세요.")
	private String title;
	
	private TodoType type;
}
