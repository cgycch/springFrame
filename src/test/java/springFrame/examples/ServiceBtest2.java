package springFrame.examples;

import org.junit.Test;

import com.cch.InAppBeanFactory;
import com.cch.service.ServiceB;

import springFrame.BaseUnit;


public class ServiceBtest2 extends BaseUnit{
	
	@Test
	public void test() {
		System.out.println("hhh");
		
		ServiceB bean = (ServiceB) InAppBeanFactory.getBean("serviceB");
		System.out.println(bean);
		
		ServiceB bean2 = InAppBeanFactory.getBean(ServiceB.class);
		System.out.println(bean2);
	}

}
