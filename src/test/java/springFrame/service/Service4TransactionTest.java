package springFrame.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cch.service.demo.transactions.ServiceOut;

import springFrame.BaseUnit;

public class Service4TransactionTest extends BaseUnit{
	
	@Autowired
	private ServiceOut serviceOut;
	
	@Test
	public void test() {
		boolean out = true;
		boolean in = false;
		serviceOut.doUpdateOut_n(out,in);
	}
	
	@Test
	public void test1() {
		boolean out = true;
		boolean in = false;
		serviceOut.doUpdateOut_y(out,in);
	}
	
	@Test
	public void doUpdateOutWithCatch() {
		boolean out = true;
		boolean in = false;
		serviceOut.doUpdateOutWithCatch(out,in);
	}
	
	@Test
	public void methodA() {
		boolean a = true;
		boolean b = false;
		serviceOut.methodA(a,b);
	}
	@Test
	public void methodFor() {
		serviceOut.methodFor();
	}
	

}
