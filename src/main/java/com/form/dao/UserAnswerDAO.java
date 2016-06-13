/**
 * 日付 : 2016.06.13
 * 作成者 : キム
 * データベースで必要な作業
 */
package com.form.dao;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import com.form.model.UserAnswer;
import com.form.model.UserAnswerMapper;

public class UserAnswerDAO {
	private DataSource 		dataSource;
	private JdbcTemplate 	jdbcTemplateObject;
	   
	public void setDataSource(DataSource dataSource) {
		this.dataSource 		= dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	//public void create(Collection<T> collection) { -> user_answer_tb collection 
	public void Create( String select_answer ) { // timestamp 使い方 (time)
		String SQL = "insert into user_answer_tb (select_answer, time) values (?,?)";
	      
	    jdbcTemplateObject.update( SQL, select_answer, "time");
	    System.out.println("Created Record select_answer = " + select_answer + " time = " + "");
	    return;
    }
	
	public UserAnswer GetUserAnswer( Integer user_id, Integer content_id, Integer question_id, Integer answer_id ) { // timestamp 使い方 (time)
		 String 	SQL 			= "select select_answer, time from user_answer_tb "
		 							+ "where user_id = ? and "
		 							+ "content_id = ? and "
		 							+ "question_id = ? and "
		 							+ "answer_id = ?";
		 UserAnswer get_user_answer = jdbcTemplateObject.queryForObject(SQL, new Object[]{user_id, content_id, question_id, answer_id}, new UserAnswerMapper());
		 return get_user_answer;
    }

	public List<UserAnswer> ListStudents() {
	    String 				SQL 				= "select select_answer, time from user_answer_tb";
	    List<UserAnswer> 	list_user_answer 	= jdbcTemplateObject.query(SQL, new UserAnswerMapper());
	    return list_user_answer;
	}
	
	public void Delete( Integer user_id, Integer content_id, Integer question_id, Integer answer_id ){
	    String SQL = "delete from user_answer_tb" 
	    		   + "where user_id = ? and "
		 		   + "content_id = ? and "
		 		   + "question_id = ? and "
		 		   + "answer_id = ?";
	      
	    jdbcTemplateObject.update(SQL, user_id, content_id, question_id, answer_id);
	    System.out.println( "Deleted Record with ID = " + user_id + ", " + content_id + ", " + question_id + ", " + answer_id );
	    return;
	}
}
