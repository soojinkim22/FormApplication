/**
 * 日付 : 2016.06.13
 * 作成者 : キム
 * データベースで必要な作業
 */
package com.form.dao;

import java.util.Calendar;
import java.util.List;
import java.sql.Timestamp;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.form.model.UserAnswer;
import com.form.model.UserAnswerMapper;

@Service
public class UserAnswerDAO {
	private DataSource 		dataSource;
	private JdbcTemplate 	jdbcTemplateObject;
   
	public void setDataSource(DataSource dataSource) {
		this.dataSource 		= dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	//public void create(Collection<T> collection) { -> user_answer_tb collection 
	public void InsertUserAnswer( Integer user_id, Integer content_id, Integer question_id, Integer answer_id, String select_answer ) { // timestamp 使い方 (time)
		Calendar calendar = Calendar.getInstance();
	    Timestamp time = new Timestamp(calendar.getTime().getTime());
	    
		String SQL = "insert into user_answer_tb (user_id, content_id, question_id, answer_id, select_answer, time) values (?,?,?,?,?,?)";
	      
	    jdbcTemplateObject.update( SQL, user_id, content_id, question_id, answer_id, select_answer, time);
	    System.out.println("Created Record user_id = " + user_id +
	    					"content_id = " + content_id + "question_id = " + question_id +   
	    					"answer_id = " + answer_id + "select_answer = " + select_answer + " time = " + time);
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

	public List<UserAnswer> ListUserAnswers( Integer user_id, Integer content_id, Integer question_id, Integer answer_id ) {
	    String 				SQL 				= "select select_answer, time from user_answer_tb "
	    										+ "where user_id = ? and"
	    										+ "content_id = ? and "
	    				 						+ "question_id = ? and "
	    				 						+ "answer_id = ?";
	    List<UserAnswer> 	list_user_answer 	= jdbcTemplateObject.query(SQL, new Object[]{user_id, content_id, question_id, answer_id}, new UserAnswerMapper());
	    
	    System.out.println(list_user_answer);
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
