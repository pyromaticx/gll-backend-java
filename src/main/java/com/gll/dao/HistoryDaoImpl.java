package com.gll.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gll.model.HistoryModel;


@Repository("historyDao")
public class HistoryDaoImpl implements HistoryDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void save(HistoryModel historyModel) {
		sessionFactory.getCurrentSession().saveOrUpdate(historyModel);

	}

	@Override
	public List<HistoryModel> displayAll() {
		return (List<HistoryModel>) sessionFactory.getCurrentSession().createCriteria(HistoryModel.class).list();
	}

	@Override
	public HistoryModel display(int historyId) {
		return (HistoryModel) sessionFactory.getCurrentSession().get(HistoryModel.class, historyId);
	}

	@Override
	public void update(HistoryModel historyModel) {
		sessionFactory.getCurrentSession().saveOrUpdate(historyModel);

	}

	@Override
	public void patch(HistoryModel historyModel) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int historyId) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM HistoryModel WHERE historyId = " + historyId).executeUpdate();

	}

}
