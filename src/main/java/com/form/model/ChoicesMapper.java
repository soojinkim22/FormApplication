package com.form.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ChoicesMapper implements RowMapper<ChoicesBean>{

	public ChoicesBean mapRow(ResultSet rs,int rowNum) throws SQLException{
		ChoicesBean choicesbean = new ChoicesBean();
		choicesbean.setContent_id(rs.getInt("content_id"));
		choicesbean.setQestion_id(rs.getInt("question_id"));
		choicesbean.setAnswer_id(rs.getInt("answer_id"));
		choicesbean.setAnswer(rs.getString("answer"));
		choicesbean.setIs_answer(rs.getBoolean("is_answer"));
		return choicesbean;

	}
}
