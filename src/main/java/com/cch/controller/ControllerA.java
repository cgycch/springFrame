package com.cch.controller;

import com.cch.service.BaseService;
import com.cch.service.ServiceA;
import com.cch.spring.SpringProvicer;


public class ControllerA implements BaseService{
	
	public ServiceA service = new ServiceA();
	
	public ControllerA() {
		System.out.println("ControllerA.ControllerA()");
	}

	@Override
	public String doProcess() {
		System.out.println("ControllerA.doProcess()");
		System.out.println("this call loader is: "+ this.getClass().getClassLoader());
		String result = doMytest();
		return "\nthis is a result form AAA:  " + result;
	}

	private String doMytest() {
		String result = "null";
		try {
			ServiceA service = SpringProvicer.getBean(ServiceA.class);
			result = service.sayHello();
		} catch (Exception e) {
			System.out.println("No~~~~~~~~~~"+e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

}
