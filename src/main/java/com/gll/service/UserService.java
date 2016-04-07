package com.gll.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.gll.model.User;

public interface UserService extends UserDetailsService {

	public void postUser(User user);

	public List<User> getAllUser();

	public User getUser(int userId);

	public void putUser(User user);

	public void patchUser(User user);

	public void deleteUser(String userId);

	User findById(int id);

	User findBySSO(String sso);
	
	List<String> getPermissions(String username);

    User getCurrentUser();

    Boolean isCurrentUserLoggedIn();
}
