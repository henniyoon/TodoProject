package com.hennie.controller;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TodoListForm {
	
	private Long id;
	
	@NotEmpty(message = "세부 계획을 입력하세요.")
	private String title;

}
