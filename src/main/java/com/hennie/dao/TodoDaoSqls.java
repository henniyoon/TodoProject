package com.hennie.dao;

public class TodoDaoSqls {
	public static final String SELECT_ALL = "SELECT no, title, regdate, deadline FROM todo";
	public static final String SELECT_BY_TODO_NO = "SELECT no, title, regdate, deadline FROM todo where no = :no";
//	public static final String INSERT = "INSERT INTO todo(no, title, deadline) values(todo_seq.nextval, :title, :deadline)";
	public static final String DELETE_BY_TODO_NO = "DELETE FROM todo where no = :no";
	public static final String UPDATE = "UPDATE todo SET title = :title, deadline = :deadline where no = :no";
}
