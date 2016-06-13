package com.form.dao;

import java.util.List;

import javax.sql.DataSource;

public interface DAOInterface {
	 /** 
	    * This is the method to be used to initialize
	    * database resources ie. connection.
	    */
	   public void setDataSource(DataSource ds);
	   /** 
	    * This is the method to be used to create
	    * a record in the Student table.
	    */
	   public void create(Integer id);
	   /** 
	    * This is the method to be used to list down
	    * a record from the Student table corresponding
	    * to a passed student id.
	    */
	   
	   /** 
	    * This is the method to be used to list down
	    * all the records from the Student table.
	    */
	   public Boolean update(Integer id);
	   
	   public Boolean delete(Integer id);
}
