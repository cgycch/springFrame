package com.cch;

public class Hello {
	public String name;
	public Hello() {
		System.out.println("Hello.name: "+this.name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Hello.setName: "+this.name);
	}

}
