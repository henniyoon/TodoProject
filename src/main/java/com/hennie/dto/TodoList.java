package com.hennie.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class TodoList {
	private int todoNo;
	private int listNo;
	private String listTitle;
	private String type;

}
