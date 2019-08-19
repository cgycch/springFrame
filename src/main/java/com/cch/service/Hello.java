package com.cch.service;

import java.lang.reflect.Method;

public class Hello {
	
	public void func(String[] args) {
		System.out.println((args == null) ? "null" : args.length);
	}
	
	public void func2(String key, String[] args) {
		System.out.println((args == null) ? "null" : args.length);
	}
	
	public void func3(Object[][] args) {
		System.out.println((args == null) ? "null" : args.length);
	}

	public static void main(String[] args) throws Exception {
		Hello obj = new Hello();
		
//		Method m = obj.getClass().getMethod("func", String[].class);
//		m.invoke(obj, new String[1]); // 1 ok (null)
//	    m.invoke(obj, new String[2]);  //2 error since number arguments is two(null,null)
//		m.invoke(obj, new String[] { "a" }); // 3 error since class is string "a", not array
//	    m.invoke(obj, new String[] {"a", "b"}); //4 error since number arguments is two("a","b")
//		m.invoke(obj, new Object[] { new String[] { "a", "b" } }); // 5 ok
//		m.invoke(obj, (Object) new String[] { "a" }); // 6 ok
//		m.invoke(obj, (Object) new String[] { "a", "b" }); // 7 ok
		
		
//		Method m2 = obj.getClass().getMethod("func2", String.class, String[].class);
//        m2.invoke(obj, new String(), new String[1]);  //1 ok
//        m2.invoke(obj, new String(), new String[2]);  //2 ok
//        m2.invoke(obj, new String(), new String[] {"a"});  //3 ok
//        m2.invoke(obj, new String(), new String[] {"a", "b"}); //4 ok
		  // Object 是任意对象类型的基类，且被强转类型实质是 String 数组，所以在运行时不存在影响
//		  m2.invoke(obj, new String(), (Object) new String[] {"a", "b"}); //5 ok
//        m2.invoke(obj, new String(), new Object[]{new String[] {"a", "b"}}); //6 error type mismatch

//        Method m3 = obj.getClass().getMethod("func3", Object[][].class);
//        m3.invoke(obj, new String[1]);//ok(null)
//        m3.invoke(obj, new Object[][]{new String[] {"a", "b"}});//ok(null)
	
	}
}
