package com.explore.sourceCodeTest.spring.tx.propagation.dao;

import com.explore.sourceCodeTest.spring.tx.propagation.UserB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//@Repository
public class BDao {
//	@Autowired
//	private JdbcTemplate jdbcTemplate;

//	public int insert(UserB record) {
//		String sql = "INSERT INTO `tbl_user_b`(username) VALUES(?)";
//		return jdbcTemplate.update(sql, record.getName());
//	}
//
//	public int update(UserB record) {
//		String sql = "UPDATE `tbl_user_b` SET  username = ? WHERE id = ?";
//		return jdbcTemplate.update(sql, record.getName(),record.getId());
//	}
//
//	public UserB selectByPrimaryKey(Integer id) {
//		String sql = "SELECT id,username FROM `tbl_user_b` WHERE id= ?";
//		return jdbcTemplate.queryForObject(sql, UserB.class,id);
//	}
}
