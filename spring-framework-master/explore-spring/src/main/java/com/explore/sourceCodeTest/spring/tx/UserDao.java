package com.explore.sourceCodeTest.spring.tx;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public void insert(String username,int age){
		String sql = "INSERT INTO `tbl_user`(username,age) VALUES(?,?)";
		jdbcTemplate.update(sql, username,age);
		
	}

}
