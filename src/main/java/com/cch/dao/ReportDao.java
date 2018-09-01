package com.cch.dao;

import java.util.List;

import com.cch.entities.BeanOne;

public interface ReportDao {
	List<BeanOne> findAll();
	void insertReoprt();
}
