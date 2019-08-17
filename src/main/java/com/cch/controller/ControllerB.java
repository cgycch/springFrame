package com.cch.controller;

import com.cch.InAppBeanFactory;
import com.cch.service.BaseService;
import com.cch.service.ServiceB;

public class ControllerB implements BaseService{
	
	public ServiceB service = new ServiceB();
	
	public ControllerB() {
		System.out.println("ControllerB.ControllerB()");
	}

	@Override
	public String doProcess() {
		System.out.println("ControllerB.doProcess()");
		System.out.println("this call loader is: "+ this.getClass().getClassLoader());
		String result = doMytest();
		return "\nthis is a result form BBB:  " + result;
	}

	private String  doMytest() {
		String result = "null";
		try {
			ServiceB service = InAppBeanFactory.getBean(ServiceB.class);
			result = service.sayHello();
		} catch (Exception e) {
			System.out.println("No~~~~~~~~~~"+e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

}
