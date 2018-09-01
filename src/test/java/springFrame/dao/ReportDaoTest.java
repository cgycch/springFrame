package springFrame.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cch.common.utils.RunUtils;
import com.cch.dao.ReportDao;
import com.cch.entities.BeanOne;

import springFrame.BaseUnit;

public class ReportDaoTest extends BaseUnit {
	
	@Autowired
	private ReportDao userDao;
	
	
	@Test
	public void findAllTest() {
		long stime = System.currentTimeMillis();
		System.out.println("startTime: "+stime);
		System.out.println("showMemory: "+RunUtils.showMemoryInfo());
		List<BeanOne> list = userDao.findAll();
		long etime = System.currentTimeMillis();
		System.out.println("list.size() "+list.size());
		System.out.println("showMemory: "+RunUtils.showMemoryInfo());
		System.out.println("takes time(S): "+(etime-stime)/1000d);
	}
	@Test
	public void batchInsertTest() {
		System.out.println("start");
		userDao.insertReoprt();
		System.out.println("ok");
	}

}
