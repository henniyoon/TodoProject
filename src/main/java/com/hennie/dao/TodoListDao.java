package com.hennie.dao;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.hennie.dto.TodoList;
import static com.hennie.dao.TodoListDaoSqls.*;

@Repository
// 선언부
public class TodoListDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction; // Insert
	private RowMapper<TodoList> rowMapper = BeanPropertyRowMapper.newInstance(TodoList.class);
	
	// 생성자부
	@Autowired
	DataSource dataSource;
	
	public TodoListDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource);
	}
	
	// 구현부
	/// SELECT_BY_TODO_LIST_NO
	public TodoList selectByNo(Integer no) {
		try {
			Map<String, ?> params = Collections.singletonMap("todo_no", no);
			return jdbc.queryForObject(SELECT_BY_TODO_LIST_NO, params, rowMapper);		
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	/// INSERT
	public int insert(TodoList todoList) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(todoList);
		return insertAction.execute(params);
	}
	
	/// UPDATE
	public int update(TodoList todoList) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(todoList);
		return jdbc.update(UPDATE, params);
	}
	
	/// DELETE_BY_TODO_LIST_NO
		public int deleteByNo(Integer no) {
			Map<String, ?> params = Collections.singletonMap("todo_no", no);
			return jdbc.update(DELETE_BY_TODO_LIST_NO, params);	
	}
	
	/// DELETE_BY_TODO_LIST_LISTNO
	public int deleteByListNo(Integer no) {
		Map<String, ?> params = Collections.singletonMap("list_no", no);
		return jdbc.update(DELETE_BY_TODO_LIST_LISTNO, params);	
	}
	
}
