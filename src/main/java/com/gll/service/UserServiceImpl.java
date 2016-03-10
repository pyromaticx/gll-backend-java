package com.gll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gll.dao.UserDao;
import com.gll.model.UserModel;

@Service("UserService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao UserDao;

	@Override
	public void postUser(UserModel UserModel) {
		UserDao.postUser(UserModel);
	}

	@Override
	public List<UserModel> getAllUser() {
		return UserDao.getAllUser();
	}

	@Override
	public UserModel getUser(int UserId) {
		return UserDao.getUser(UserId);
	}

	@Override
	public void putUser(UserModel UserModel) {
		UserDao.putUser(UserModel);
		
	}

	@Override
	public void patchUser(UserModel UserModel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String UserId) {
		UserDao.deleteUser(UserId);
		
	}


}
