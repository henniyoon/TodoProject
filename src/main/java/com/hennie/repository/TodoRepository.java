package com.hennie.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.hennie.entity.Todo;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class TodoRepository {
	
	private final EntityManager em;
	
	// Todo 등록
	public void save(Todo todo) {
		em.persist(todo);
	}
	
	// Todo 1개 조회
	public Todo findOne(Long id) {
		return em.find(Todo.class, id);
	}
	
	// Todo 전체 조회
	public List<Todo> findAll() {
		return em.createQuery("select t from Todo t", Todo.class)
				.getResultList();
	}
	

}
