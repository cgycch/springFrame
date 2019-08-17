package com.cch.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceB {
	public ServiceB() {
		System.out.println("ServiceB.ServiceB()");
	}
	
	public String sayHello() {
		System.out.println("ServiceB.sayHello()");
		return "hello, this is BBB";
	}
}
