package com.hennie.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.hennie.entity.TodoList;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class TodoListRepository {

	private final EntityManager em;
	
	// TodoList 등록
	public void save(TodoList todoList) {
		em.persist(todoList);		
	}
	
	// TodoList 1개 조회
	public TodoList findOne(Long id) {
		return em.find(TodoList.class, id);
	}
	
	// TodoList 전체 조회
	public List<TodoList> findAll() {
		return em.createQuery("select l from TodoList l", TodoList.class)
				.getResultList();
	}
}
