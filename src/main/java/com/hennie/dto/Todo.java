package com.hennie.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Todo {
	private int no;
	private String title;
	private Date regdate;
	private Date deadline;

}
