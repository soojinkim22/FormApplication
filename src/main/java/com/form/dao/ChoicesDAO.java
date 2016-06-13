package com.form.dao;

import java.util.ArrayList;

import javax.sql.DataSource;


public class ChoicesDAO{

	public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public ArrayList<choicesDAO> selectByAll() {
		String SQL = "select * from choices_tb";

		ArrayList<choicesDAO> choicesDAO = jdbcTemplateObject.query(SQL.new choicesMapper());

		return choicesDAO;
	}
}
