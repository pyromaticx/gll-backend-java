package com.gll.service.hrboost;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gll.dao.hrboost.PersonDao;
import com.gll.model.hrboost.PersonModel;

@Service("personService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao personDao;

	@Override
	public void postPerson(PersonModel personModel) {
		personDao.postPerson(personModel);
	}

	@Override
	public List<PersonModel> getAllPerson() {
		return personDao.getAllPerson();
	}

	@Override
	public PersonModel getPerson(int personId) {
		return personDao.getPerson(personId);
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
		personDao.deletePerson(personId);
		
	}


}
