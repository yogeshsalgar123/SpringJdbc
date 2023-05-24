package com.springJDBC;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class SpringJdbcApplication {

	public static void main(String[] args) {
		DriverManagerDataSource datasource= new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/bookstore");
		datasource.setUsername("root");
		datasource.setPassword("root");
		
		JdbcTemplate jdbctemplate=new JdbcTemplate(datasource);
		/*
		 * String sql="insert into book(title ,author,price) values(?,?,?)";
		 * 
		 * int result=jdbctemplate.update(sql, "java concurancy2","phillips",23.99f);
		 * if(result>0) { System.out.println("A new book has been inserted!!!"); }
		 */
		/*
		 * String sqlUpdate = "UPDATE book set price=? where title=?"; int updatedresult
		 * =jdbctemplate.update(sqlUpdate, 10.0f,"java concurancy2"); if(updatedresult
		 * >0) { { System.out.println("Price is updated succefully  !!!"); } }
		 */
		
		 String sqlDelete = "DELETE FROM book where author=?";
	       int deleteresult= jdbctemplate.update(sqlDelete, "phillips");
		if(deleteresult > 0)
		{
			System.out.println("1 row Deleted ");
		}
	}

}
