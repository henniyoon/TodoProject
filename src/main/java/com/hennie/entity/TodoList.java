package com.hennie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class TodoList {
	
	@Id
	@GeneratedValue // Sequence
	@Column(name = "list_id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "todo_id")
	private Todo todo;
	
	@Column(name = "list_title")
	private String title;
	
	private TodoType type;

}
