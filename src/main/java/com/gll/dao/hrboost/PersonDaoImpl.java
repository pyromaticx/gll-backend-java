package com.gll.dao.hrboost;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gll.model.hrboost.PersonModel;

@Repository("personDao")
public class PersonDaoImpl implements PersonDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void postPerson(PersonModel personModel) {
		sessionFactory.getCurrentSession().saveOrUpdate(personModel);

	}

	@Override
	public List<PersonModel> getAllPerson() {
		return (List<PersonModel>) sessionFactory.getCurrentSession().createCriteria(PersonModel.class).list();
		//return (List<PersonModel>)sessionFactory.getCurrentSession().createCriteria(PersonModel.class).add(Restrictions.idEq(1)).list();
	}

	@Override
	public PersonModel getPerson(int personId) {
		return (PersonModel) sessionFactory.getCurrentSession().get(PersonModel.class, personId);
	}

	@Override
	public void putPerson(PersonModel personModel) {
		// TODO Auto-generated method stub

	}

	@Override
	public void patchPerson(PersonModel personModel) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePerson(String personId) {
		sessionFactory.getCurrentSession()
				.createQuery("DELETE FROM PersonModel WHERE personId = " + personId).executeUpdate();

	}

}
