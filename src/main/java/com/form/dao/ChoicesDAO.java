package com.form.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.form.model.ChoicesBean;
import com.form.model.ChoicesMapper;

public class ChoicesDAO{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public List<ChoicesBean> selectByCode(int question_id) {
		String SQL = "SELECT * FROM choices_tb WHERER question_id = ?";

		List<ChoicesBean> choicesList = jdbcTemplateObject.query(SQL,new Object[]{question_id},new ChoicesMapper());
		return choicesList;
	}

	public void insert (int content_id,int question_id,char answer,boolean is_answer){

		String SQL ="INSERT INTO choices_tb(content_id,question_id,answer,is_answer) values(?,?,?,?)";
		 jdbcTemplateObject.update(SQL, content_id,question_id,answer,is_answer );
		System.out.println("content_id="+content_id);
		 return;
	}

	public void update (int answer_id,char answer,boolean is_answer){
		String SQL = "UPDATE choices_tb SET answer = ? , is_answer = ? WHERE id = ?";
		 jdbcTemplateObject.update(SQL, answer, is_answer,answer_id);
		 System.out.println("answer_id="+answer_id);
		 return;
	}

	public void delete(int answer_id){
		String SQL = "DELETE FROM choices_tb where id = ?";
		 jdbcTemplateObject.update(SQL,answer_id);
		 System.out.println("answer_id="+answer_id);
		 return;
	}
}
