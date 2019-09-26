package com.cch.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceA {
	public ServiceA() {
		//System.out.println("ServiceA.ServiceA()");
	}
	
	public String sayHello() {
		System.out.println("ServiceA.sayHello()");
		return "hello, this is AAA";
	}

}
