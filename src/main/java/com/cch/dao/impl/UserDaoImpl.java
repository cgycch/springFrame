package com.cch.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cch.dao.UserDao;
import com.cch.entities.User;
@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	protected RowMapper<User> mapper() {
		return (rs, rowNum) -> {
			User user = new User();
			user.setUserName(rs.getString("user_name"));
			user.setPassword(rs.getString("pasword"));
		    return user;
		};
		
	}

	@Override
	public User getUser() {
		
		PreparedStatementCallback<User> action =new PreparedStatementCallback<User>() {
			@Override
			public User doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, "hhh");
				return new User();
			}
		};
		String callString ="";
		jdbcTemplate.execute(callString, action);
		return jdbcTemplate.execute(callString, action);
	}
	
	@Override
	public void update(String name,String id) {
		String sql ="update t_user set user_name = ? where user_id = ?";
		Object[] args = new Object[] {name+"_"+System.currentTimeMillis(),id};
		jdbcTemplate.update(sql, args);
	}

}
