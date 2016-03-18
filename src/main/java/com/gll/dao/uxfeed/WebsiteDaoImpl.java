package com.gll.dao.uxfeed;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gll.model.uxfeed.UserModel;
import com.gll.model.uxfeed.WebsiteModel;


@Repository("websiteDao")
public class WebsiteDaoImpl implements WebsiteDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void postWebsite(WebsiteModel websiteModel) {
		sessionFactory.getCurrentSession().saveOrUpdate(websiteModel);
		
	}

	@Override
	public List<WebsiteModel> getAllWebsite() {
		return (List<WebsiteModel>) sessionFactory.getCurrentSession().createCriteria(WebsiteModel.class).list();
		//return (List<UserModel>)sessionFactory.getCurrentSession().createCriteria(UserModel.class).add(Restrictions.idEq(1)).list();
	}

	@Override
	public WebsiteModel getWebsite(int websiteId) {
		return (WebsiteModel) sessionFactory.getCurrentSession().get(WebsiteModel.class, websiteId);
	}

	@Override
	public void putWebsite(WebsiteModel websiteModel) {
		sessionFactory.getCurrentSession().saveOrUpdate(websiteModel);
	}

	@Override
	public void patchWebsite(WebsiteModel UserModel) {
	}

	@Override
	public void deleteWebsite(int websiteId) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM WebsiteModel WHERE websiteId = " + websiteId).executeUpdate();
	}

}