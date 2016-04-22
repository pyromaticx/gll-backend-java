package com.gll.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gll.model.WebsiteModel;


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
		try{
		sessionFactory.getCurrentSession().saveOrUpdate(websiteModel);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void patchWebsite(WebsiteModel UserModel) {
	}

	@Override
	public void deleteWebsite(int websiteId) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM WebsiteModel WHERE websiteId = " + websiteId).executeUpdate();
	}

	@Override
	public WebsiteModel findByDomainName(String domainName) {
		Query query =  sessionFactory.getCurrentSession().createQuery("FROM WebsiteModel WHERE domainName =:domainName");
		query.setString("domainName", domainName);
		 return (WebsiteModel) query.uniqueResult();
	}

}