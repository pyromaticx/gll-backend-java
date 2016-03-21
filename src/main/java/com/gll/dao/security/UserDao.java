package com.gll.dao.security;


import java.util.List;

import com.gll.model.security.UserModel;

public interface UserDao {
	public void postUser(UserModel UserModel);
	public List<UserModel> getAllUser();
	public UserModel getUser(int UserId);
	public void putUser(UserModel UserModel);
	public void patchUser(UserModel UserModel);
	public void deleteUser(String UserId);
}
