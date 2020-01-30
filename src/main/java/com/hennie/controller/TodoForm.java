package com.hennie.controller;

import java.time.LocalDateTime;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TodoForm {
	
	private Long id;
	
	@NotEmpty(message = "todo를 입력하세요.")
	private String title;
	
	private LocalDateTime regdate;
	
	
//	@NotEmpty(message = "마감일을 입력하세요.")
	private @DateTimeFormat(pattern = "yyyy-MM-dd") Date deadline;



}
