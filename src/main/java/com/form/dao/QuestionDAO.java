package com.form.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.form.model.Question;
import com.form.model.QuestionMapper;

public class QuestionDAO {
	private DataSource dataSource;
	   private JdbcTemplate jdbcTemplateObject;
	   
	   public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	   }

	   public void create(int content_id, String question, boolean require_flag, String commentary) {
	      String SQL = "insert into question_tb (content_id, question, required_flag, commentary) values (?, ?, ?, ?)";
	      
	      jdbcTemplateObject.update( SQL, content_id, question, require_flag, commentary);
//	      System.out.println("Created Record Name = " + name + " Age = " + age);
	      return;
	   }

/*	   public List<Question> questionList(int content_id) {
	      String SQL = "select * from question_tb where content_id = ?";
	      List <Question> questions = jdbcTemplateObject.query(SQL, 
	    		  					content_id,
	                                new QuestionMapper());
	      return questions;
	   }*/

	   public void delete(int question_id){
	      String SQL = "delete from question_tb where question_id = ?";
	      jdbcTemplateObject.update(SQL, question_id);
//	      System.out.println("Deleted Record with ID = " + id );
	      return;
	   }

	   public void update(int question_id, String question, boolean required_flag, String commentary){
	      String SQL = "update Student set question = ?, required_flag = ?, commentary = ? where question_id = ?";
	      jdbcTemplateObject.update(SQL, question, required_flag, commentary, question_id);
	  //    System.out.println("Updated Record with ID = " + id );
	      return;
	   }
}
