package com.gll.dao.uxfeed;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gll.model.uxfeed.AnnotationModel;

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
	public AnnotationModel display(int annotationId) {
		return (AnnotationModel) sessionFactory.getCurrentSession().get(AnnotationModel.class, annotationId);
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
		sessionFactory.getCurrentSession().createQuery("DELETE FROM AnnotationModel WHERE annotationId = " + annotationId).executeUpdate();
	}

}
