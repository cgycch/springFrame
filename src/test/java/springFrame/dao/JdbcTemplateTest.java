package springFrame.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import springFrame.BaseUnit;

public class JdbcTemplateTest extends BaseUnit{
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void test() {
		assertNotNull(jdbcTemplate);
		String sql= "select * from t_report where Upper(rid) like ?";
		System.out.println(sql);
		List<Map<String, Object>> list= jdbcTemplate.queryForList(sql, "%0%");
		System.out.println(list.size());
	}

}
