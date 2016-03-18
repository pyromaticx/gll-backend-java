package com.gll.dao.uxfeed;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gll.model.uxfeed.UserModel;


@Repository("UserDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void postUser(UserModel UserModel) {
		sessionFactory.getCurrentSession().saveOrUpdate(UserModel);
		//sessionFactory.getCurrentSession().persist(UserModel);
	}

	@Override
	public List<UserModel> getAllUser() {
		return (List<UserModel>) sessionFactory.getCurrentSession().createCriteria(UserModel.class).list();
		//return (List<UserModel>)sessionFactory.getCurrentSession().createCriteria(UserModel.class).add(Restrictions.idEq(1)).list();
	}

	@Override
	public UserModel getUser(int UserId) {
		return (UserModel) sessionFactory.getCurrentSession().get(UserModel.class, UserId);
	}

	@Override
	public void putUser(UserModel UserModel) {
		sessionFactory.getCurrentSession().saveOrUpdate(UserModel);

	}

	@Override
	public void patchUser(UserModel UserModel) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(String UserId) {
		sessionFactory.getCurrentSession()
				.createQuery("DELETE FROM UserModel WHERE id = " + UserId).executeUpdate();

	}

}