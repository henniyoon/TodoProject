package com.hennie.dto.view;

import javax.validation.constraints.NotEmpty;

import com.hennie.domain.TodoType;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TodoListFormDto {
	
	private Long id;
	
	@NotEmpty(message = "세부 계획을 입력하세요.")
	private String title;
	
	private TodoType type;
}
