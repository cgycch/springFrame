package com.cch.entities;

import java.util.Date;

public class BeanOne {
	private String id;
	private String name;
	private String name2;
	private String name3;
	private String name4;
	private String name5;
	private String name6;
	private String name7;
	private String name8;
	private int rint;
	private int rint2;
	private Date date;
	private Date date2;
	private double rdouble;
	private double rdouble2;
	private float rfloat;
	private float rfloat2;
	
	
	public BeanOne() {
		super();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public String getName3() {
		return name3;
	}

	public void setName3(String name3) {
		this.name3 = name3;
	}

	public String getName4() {
		return name4;
	}

	public void setName4(String name4) {
		this.name4 = name4;
	}

	public String getName5() {
		return name5;
	}

	public void setName5(String name5) {
		this.name5 = name5;
	}

	public String getName6() {
		return name6;
	}

	public void setName6(String name6) {
		this.name6 = name6;
	}

	public String getName7() {
		return name7;
	}

	public void setName7(String name7) {
		this.name7 = name7;
	}

	public String getName8() {
		return name8;
	}

	public void setName8(String name8) {
		this.name8 = name8;
	}

	public int getRint() {
		return rint;
	}

	public void setRint(int rint) {
		this.rint = rint;
	}

	public int getRint2() {
		return rint2;
	}

	public void setRint2(int rint2) {
		this.rint2 = rint2;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate2() {
		return date2;
	}

	public void setDate2(Date date2) {
		this.date2 = date2;
	}

	public double getRdouble() {
		return rdouble;
	}

	public void setRdouble(double rdouble) {
		this.rdouble = rdouble;
	}

	public double getRdouble2() {
		return rdouble2;
	}

	public void setRdouble2(double rdouble2) {
		this.rdouble2 = rdouble2;
	}

	public float getRfloat() {
		return rfloat;
	}

	public void setRfloat(float rfloat) {
		this.rfloat = rfloat;
	}

	public float getRfloat2() {
		return rfloat2;
	}

	public void setRfloat2(float rfloat2) {
		this.rfloat2 = rfloat2;
	}

	@Override
	public String toString() {
		return "BeanOne [id=" + id + ", name=" + name + ", rint=" + rint + ", date=" + date + ", rdouble=" + rdouble
				+ ", rfloat=" + rfloat + "]";
	}
	
	
	
}
