package com.explore.sourceCodeTest.spring.tx.propagation.dao;

import com.explore.sourceCodeTest.spring.tx.propagation.UserA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ADao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insert(UserA record) {
		String sql = "INSERT INTO `tbl_user_a` (username) VALUES(?)";
		return jdbcTemplate.update(sql, record.getName());
	}

	public int update(UserA record) {
		String sql = "UPDATE `tbl_user_a` SET  username = ? WHERE id = ?";
		return jdbcTemplate.update(sql, record.getName(),record.getId());
	}

	public UserA selectByPrimaryKey(Integer id) {
		String sql = "SELECT id,username FROM `tbl_user_a` WHERE id= ?";
		return jdbcTemplate.queryForObject(sql,UserA.class,id);
	}

}
