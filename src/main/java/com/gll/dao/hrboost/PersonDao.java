package com.gll.dao.hrboost;

import java.util.List;

import com.gll.model.hrboost.PersonModel;

public interface PersonDao {
	
	public void postPerson(PersonModel personModel);
	public List<PersonModel> getAllPerson();
	public PersonModel getPerson(int personId);
	public void putPerson(PersonModel personModel);
	public void patchPerson(PersonModel personModel);
	public void deletePerson(String personId);
}
