package com.gll.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gll.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	private static final Logger logger = Logger.getLogger(UserDaoImpl.class);
	
	public UserDaoImpl() {
		logger.info("************************* UserDaoImpl: initializing... ");
	}
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void postUser(User UserModel) {
		sessionFactory.getCurrentSession().saveOrUpdate(UserModel);
		//sessionFactory.getCurrentSession().persist(UserModel);
	}

	@Override
	public List<User> getAllUser() {
		return (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class).list();
		//return (List<UserModel>)sessionFactory.getCurrentSession().createCriteria(UserModel.class).add(Restrictions.idEq(1)).list();
	}

	@Override
	public User getUser(int userId) {
		return (User) sessionFactory.getCurrentSession().get(User.class, userId);
	}

	@Override
	public void putUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Override
	public void patchUser(User user) {
	}

	@Override
	public void deleteUser(String userId) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM User WHERE id = " + userId).executeUpdate();
	}
	
	@Override
	public User findById(int id) {
		logger.info("****************************: UserDaoImpl---->> findById() ");
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	@Override
	public User findBySSO(String ssoId) {
		logger.info("****************************: UserDaoImpl---->> findBySSO() ");
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("ssoId", ssoId));
		List<User> results = criteria.list();
		User user = results.get(0);
		logger.info("*************** UserDaoImpl: findBySSO() : User : " + user);
		return user;
	}

}