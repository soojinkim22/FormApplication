package com.form.model;

public class Question {
	
	private int content_id;
	private int question_id;
	private String question;
	private boolean required_flg;
	private String commentary;
	
	public int getContent_id() {
		return content_id;
	}
	public void setContent_id(int content_id) {
		this.content_id = content_id;
	}
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public boolean isRequired_flg() {
		return required_flg;
	}
	public void setRequired_flg(boolean required_flg) {
		this.required_flg = required_flg;
	}
	public String getCommentary() {
		return commentary;
	}
	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}
	
	@Override
	public String toString() {
		return "Question [content_id=" + content_id + ", question_id=" + question_id + ", question=" + question
				+ ", required_flg=" + required_flg + ", commentary=" + commentary + "]";
	}
	
	
}
