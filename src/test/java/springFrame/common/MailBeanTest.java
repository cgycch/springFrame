package springFrame.common;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cch.entities.MailBean;

import springFrame.BaseUnit;

public class MailBeanTest extends BaseUnit{
	
	@Autowired
	private MailBean mailbean;
	
	@Test
	public void test() {
		System.out.println(mailbean);
	}
	
	
}
