package com.form.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class UserAnswerMapper implements RowMapper<UserAnswer>{
	public UserAnswer mapRow(ResultSet result_set, int row_number) throws SQLException {
		UserAnswer user_answer = new UserAnswer();
		
		user_answer.setSelect_answer(result_set.getString("select_answer"));
		user_answer.setTime(result_set.getTimestamp("")); //-> timestampの使い方確認
		return user_answer;
	}
}
