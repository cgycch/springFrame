package com.cch.dao;

import com.cch.entities.User;

public interface UserDao {
	public User getUser();

	void update(String name, String id);

}
