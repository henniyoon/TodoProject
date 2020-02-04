package com.hennie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hennie.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
