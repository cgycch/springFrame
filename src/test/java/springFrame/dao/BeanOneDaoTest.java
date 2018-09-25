package springFrame.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cch.dao.BeanOneDao;

import springFrame.BaseUnit;

public class BeanOneDaoTest extends BaseUnit{
	@Autowired
	private BeanOneDao dao;
	
	@Test
	public void test() {
		assertNotNull(dao);
		
		System.out.println(dao.findALl().size());
	}

}
