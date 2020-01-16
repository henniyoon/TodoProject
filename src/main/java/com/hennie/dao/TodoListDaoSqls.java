package com.hennie.dao;

public class TodoListDaoSqls {
	public static final String SELECT_BY_TODO_LIST_NO = "SELECT todo_no, list_no, list_title, type FROM todo_list where todo_no = :todo_no";
//	public static final String INSERT = "INSERT INTO todo_list(todo_no, list_no, list_title) values(:todo_no, list_seq.nextval, :list_title)";
	public static final String DELETE_BY_TODO_LIST_NO = "DELETE FROM todo_list where todo_no = :todo_no";
	public static final String DELETE_BY_TODO_LIST_LISTNO = "DELETE FROM todo_list where lilst_no = :list_no";
	public static final String UPDATE = "UPDATE todo_list SET list_title = :list_title where list_no = :list_no";

}
