package com.cch.service.demo.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cch.dao.UserDao;

@Service
public class ServiceOut {
	
	@Autowired
	private UserDao dao;
	
	@Autowired
	private ServiceInt serviceInt;
	
	//@Transactional
	public void doUpdateOut_n(boolean outSuccess,boolean inSuccess) {
		dao.update("out","10002");
		serviceInt.doUpdateInt(inSuccess);
		if(outSuccess) {
			System.out.println("ServiceOut.doUpdateOut() success");
		}else {
			System.out.println("ServiceOut.doUpdateOut() failed");
			int i = 1/0;
			System.out.println("error on out..."+i);
		}
	}
	
	@Transactional
	public void doUpdateOut_y(boolean outSuccess,boolean inSuccess) {
		dao.update("out","10002");
		serviceInt.doUpdateInt(inSuccess);
		if(outSuccess) {
			System.out.println("ServiceOut.doUpdateOut() success");
		}else {
			System.out.println("ServiceOut.doUpdateOut() failed");
			int i = 1/0;
			System.out.println("error on out..."+i);
		}
	}
	
	//不同个service 方法级别的嵌套失误  生效
	@Transactional
	public void doUpdateOutWithCatch(boolean outSuccess,boolean inSuccess) {
		//dao.update("out","10001");//嵌套事务 可能会发生死锁！！！ 当更新同一记录时
		dao.update("out","10002");
		try {
			serviceInt.doUpdateInt(inSuccess);
		} catch (Exception e) {
			System.out.println("ServiceOut.doUpdateOutWithCatch() catch error on : serviceInt.doUpdateInt; " + e.getMessage());
		}
		
		if(outSuccess) {
			System.out.println("ServiceOut.doUpdateOutWithCatch() success");
		}else {
			System.out.println("ServiceOut.doUpdateOutWithCatch()  failed");
			int i = 1/0;
			System.out.println("error on out..."+i);
		}
	}
	
	//同个service 方法级别的嵌套失误 不生效
	@Transactional
	public void methodA(boolean a,boolean b) {
		dao.update("a", "10001");
		try {
			methodB(b);
		} catch (Exception e) {
			System.out.println("ServiceOut.methodA() catch error on : methodB ");
		}
		if(a) {
			System.out.println("ServiceOut.methodA() success");
		}else {
			System.out.println("ServiceOut.methodA()  failed");
			System.out.println("error"+1/0);
		}
	}
	
	//同个service 方法级别的嵌套失误 不生效
	//@Transactional
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void methodB(boolean b) {
		dao.update("b", "10002");
		if(b) {
			System.out.println("ServiceOut.methodB() success");
		}else {
			System.out.println("ServiceOut.methodB()  failed");
			System.out.println("error"+1/0);
		}
	}
	
	@Transactional
	public void methodFor() {
		for (int i = 1; i < 5; i++) {
			try {
				boolean flag = true;
				if(i==3) {
					flag = false;
				}
				//itemofFor(i, flag);//not effective
				serviceInt.itemofFor(i, flag);//effective
			} catch (Exception e) {
				System.out.println("error:>>>>> "+ e.getMessage());
			}
		}
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void itemofFor(int i, boolean success) {
		dao.update("10001", "1000"+1);
		if(success) {
			System.out.println("ServiceOut.methodB() success on "+ i);
		}else {
			System.out.println("ServiceOut.methodB()  failed "+ i);
			System.out.println("error"+1/0);
		}
	}
}
