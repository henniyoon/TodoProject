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

import com.hennie.dto.Todo;
import static com.hennie.dao.TodoDaoSqls.*;



@Repository
// 선언부
public class TodoDao {	
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction; //Insert
	private RowMapper<Todo> rowMapper = BeanPropertyRowMapper.newInstance(Todo.class); //Select

	// 생성자부
	@Autowired
    DataSource dataSource;

	public TodoDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("todo");
	}
	
	// 구현부
	/// SELECT
	public List<Todo> selectAll() {
		return jdbc.query(SELECT_ALL, Collections.emptyMap(), rowMapper);
	}
	
	/// INSERT
	public int insert(Todo todo) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(todo);
		return insertAction.execute(params);
	}
	
	/// UPDATE
	public int update(Todo todo) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(todo);
		return jdbc.update(UPDATE, params);
	}
	
	/// DELETE
	public int deleteByNo(Integer no) {
		Map<String, ?> params = Collections.singletonMap("no", no);
		return jdbc.update(DELETE_BY_TODO_NO, params);
	}
	
	/// SELECT_BY_TODO_NO
	public Todo selectByNo(Integer no) {
		try {
			Map<String, ?> params = Collections.singletonMap("no", no);
			return jdbc.queryForObject(SELECT_BY_TODO_NO, params, rowMapper);
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
}
