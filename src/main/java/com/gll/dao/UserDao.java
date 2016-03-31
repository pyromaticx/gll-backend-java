package com.gll.dao;

import java.util.List;

import com.gll.model.User;

public interface UserDao {
	public void postUser(User user);

	public List<User> getAllUser();

	public User getUser(int userId);

	public void putUser(User user);

	public void patchUser(User user);

	public void deleteUser(String userId);

	User findById(int id);

	User findBySSO(String ssoId);
}
