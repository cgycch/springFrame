package springFrame.dao;

import static org.junit.Assert.assertNotNull;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import springFrame.BaseUnit;

public class JdbcTemplateTest extends BaseUnit{
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void test() {
		assertNotNull(jdbcTemplate);
		String sql= "select * from t_user where Upper(user_id) like ?";
		System.out.println(sql);
		List<Map<String, Object>> list= jdbcTemplate.queryForList(sql, "%10001%");
		System.out.println(list.size());
	}
	@Test
	public void test2() {
		assertNotNull(jdbcTemplate);
	
	}

}
