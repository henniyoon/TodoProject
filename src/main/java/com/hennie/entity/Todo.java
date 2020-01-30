package com.hennie.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Todo {
	
	@Id
	@GeneratedValue // Sequence
	@Column(name = "todo_id")
	private Long id;
	
	@Column(name = "todo_title")
	private String title;
	
	private LocalDateTime regdate;
	private Date deadline;
	
	@OneToMany(mappedBy = "todo") // TodoList table의 todo에 의해 매핑된 거울이다.
	private List<TodoList> todoLists = new ArrayList<>();
	
}


