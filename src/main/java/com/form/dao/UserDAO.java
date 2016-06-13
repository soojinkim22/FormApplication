package com.form.dao;

import javax.sql.DataSource;

import com.form.model.User;


public class UserDAO {

	private  DataSource dataSource;
	private  JdbcTmplate jdbcTemplateObject;

	public void setDateSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void create(String name, String password, String role ) {
		String SQL = "insert into user_tb (username,password,role) values (?,?,?)";
		jdbcTemplateObject.update(SQL, name , password, role);
		System.out.println("Created Record Name = " + name + "pass=" + password + "role=" + role);
		return;
	}

	public User getUser(Integer id) {
		String SQL = "select * from user_tb where user_id = ?";
		User user = jdbcTemplateObject.queryForObject(SQL,new Object[]{id}, new UserMapper());
		return user;
	}

	public List<User> listUser() {
		String SQL = "select * from user_tb";
		List<User> users = jdbcTemplateObject.query(SQL, new UserMapper());
		return users;
	}

	public void delete (Integer id) {
		String SQL = "delete from user_tb where user_id = ?";
		jdbcTemplateObject.update(SQL,id);
		System.out.println("Dleted Record with ID = " + id );
		return;
	}

	public void update(Integer id, String password) {
		String SQL = "update user_tb set password = ? where id = ?";
				jdbcTemplateObject.update(SQL, password, id );
				System.out.println("Update Record qith ID = " + id);
				return;
	}





}
