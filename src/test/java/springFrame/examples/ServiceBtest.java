package springFrame.examples;

import org.junit.Test;

import com.cch.service.ServiceB;
import com.cch.spring.SpringProvicer;


public class ServiceBtest{
	
	@Test
	public void test() {
		System.out.println("hhh");
		SpringProvicer.init();
		
		ServiceB bean = (ServiceB) SpringProvicer.getBean("serviceB");
		System.out.println(bean);
		
		ServiceB bean2 = SpringProvicer.getBean(ServiceB.class);
		System.out.println(bean2);
	}

}
