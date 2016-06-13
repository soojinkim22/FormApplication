package com.form.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class UserMapper implements RowMapper<User>{
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	User user = new User();
	user.setUser_id(rs.getInt("user_id"));
	user.setUsername(rs.getString("username"));
	user.setPassword(rs.getString("password"));
	user.setRole(rs.getString("role"));
	return user;
}
}
