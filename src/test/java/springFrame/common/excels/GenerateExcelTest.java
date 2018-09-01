package springFrame.common.excels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cch.common.excels.PTREncryptExcelGenerator;
import com.cch.common.utils.RunUtils;
import com.cch.dao.ReportDao;
import com.cch.entities.BeanOne;

import springFrame.BaseUnit;

public class GenerateExcelTest extends BaseUnit{
	
	@Autowired
	public ReportDao dao;

	@Test
	public void test() throws Exception {
		List<BeanOne> data = dao.findAll();
		Map<String,List<BeanOne>> groupMap = new HashMap<>();
		for (BeanOne beanOne : data) {
			if(groupMap.containsKey(beanOne.getName())){
				groupMap.get(beanOne.getName()).add(beanOne);
			}else {
				List<BeanOne> newGroup = new ArrayList<>();
				newGroup.add(beanOne);
				groupMap.put(beanOne.getName(), newGroup);
			}
		}
		//step 2
		String filePath = "D:\\MyExcel\\";
		String password = "123456";
		PTREncryptExcelGenerator<BeanOne> generator = new PTREncryptExcelGenerator<>();

		for (String group : groupMap.keySet()) {
			System.out.println("group:"+group+"  size:"+groupMap.get(group).size());
			String filename = filePath + "hello_"+group+".xlsx";
			generator.generateEncryptExcel(groupMap.get(group), filename, password, null);
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	static long startTime = 0;
	static long endTime = 0;
	@Before
	public void bef() {
		startTime = System.currentTimeMillis();
		System.out.println("begin time at : "+ startTime);
		System.out.println(RunUtils.showMemoryInfo());
	}
	@After
	public void aft() {
		endTime = System.currentTimeMillis();
		System.out.println(RunUtils.showMemoryInfo());
		System.out.println("end time at : "+ endTime);
		System.out.println("takes times : "+ (endTime-startTime)/1000d);
	}

}
