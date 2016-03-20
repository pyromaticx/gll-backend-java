package com.gll.service.hrboost;

import java.util.List;

import com.gll.model.hrboost.PersonModel;

public interface PersonService {
	public void postPerson(PersonModel personModel);
	public List<PersonModel> getAllPerson();
	public PersonModel getPerson(int personId);
	public void putPerson(PersonModel personModel);
	public void patchPerson(PersonModel personModel);
	public void deletePerson(String personId);
}
