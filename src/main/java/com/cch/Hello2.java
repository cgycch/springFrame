package com.cch;

public class Hello2 {
	
	private int id;
	private String name;
	private String envname;
	
	public Hello2() {
		super();
		System.out.println("Hello2.name: "+this.name);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		System.out.println("Hello2.setName: "+this.name);
	}

	public String getEnvname() {
		return envname;
	}

	public void setEnvname(String envname) {
		this.envname = envname;
		System.out.println("Hello2.setEnvname: "+this.envname);
	}
	
	
}
