package com.gll.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gll.model.AnnotationModel;
import com.gll.model.WebsiteModel;


@Repository("annotationDao")
public class AnnotationDaoImpl implements AnnotationDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void save(AnnotationModel annotationModel) {
		sessionFactory.getCurrentSession().saveOrUpdate(annotationModel);

	}

	@Override
	public List<AnnotationModel> displayAll() {
		return (List<AnnotationModel>) sessionFactory.getCurrentSession().createCriteria(AnnotationModel.class).list();
		//return (List<UserModel>)sessionFactory.getCurrentSession().createCriteria(UserModel.class).add(Restrictions.idEq(1)).list();
	}

	@Override
	public AnnotationModel display(int pinId) {
		return (AnnotationModel) sessionFactory.getCurrentSession().get(AnnotationModel.class, pinId);
	}

	@Override
	public void update(AnnotationModel annotationModel) {
		sessionFactory.getCurrentSession().saveOrUpdate(annotationModel);

	}

	@Override
	public void patch(AnnotationModel annotationModel) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int annotationId) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM AnnotationModel WHERE pinId = " + annotationId).executeUpdate();
	}

	@Override
	public List<AnnotationModel> getAnnotationsByUserName(String userName) {
		String hql = "FROM AnnotationModel A, User U FETCH ALL PROPERTIES WHERE A.userId = U.userId AND U.userName = :userName";
		Query query =  sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("userName", userName);
		 return (List<AnnotationModel>) query.list();
	}

}
