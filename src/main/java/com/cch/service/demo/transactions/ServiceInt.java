package com.cch.service.demo.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cch.dao.UserDao;

@Service
public class ServiceInt {
	
	@Autowired
	private UserDao dao;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void doUpdateInt(boolean success) {
		dao.update("int","10001");
		if(success){
			System.out.println("ServiceInt.doUpdateInt() success");
		}else {
			System.out.println("ServiceInt.doUpdateInt()  failed");
			int i = 1/0;
			System.out.println("cound not go here i="+i);
		}
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void itemofFor(int i, boolean success) {
		dao.update("10001", "1000"+i);
		if(success) {
			System.out.println("ServiceOut.methodB() success on "+ i);
		}else {
			System.out.println("ServiceOut.methodB()  failed "+ i);
			System.out.println("error"+1/0);
		}
	}

}
