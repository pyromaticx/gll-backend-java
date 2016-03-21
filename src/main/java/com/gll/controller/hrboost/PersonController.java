package com.gll.controller.hrboost;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.gll.bean.hrboost.Address;
import com.gll.bean.hrboost.Person;
import com.gll.model.hrboost.AddressModel;
import com.gll.model.hrboost.PersonModel;
import com.gll.service.hrboost.PersonService;

@Controller
public class PersonController {

	@Autowired
	private PersonService personService;

	/* ============= Person Section Start ==================== */

	@RequestMapping(value = {"/person.html", "/person.json", "/person.xml", "/person.pdf", "/person.xls"}, method = RequestMethod.GET)
//	@RequestMapping(value = {"/person.html", "*"}, method = RequestMethod.GET)
//	@RequestMapping(value = {"/person.html"}, method = RequestMethod.GET)
	public ModelAndView personPage(@ModelAttribute("person") Person person) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("person", person);
		model.put("personRecords", prepareAllPerson(personService.getAllPerson()));
		//model.put("personRecords", personService.getAllPerson());
		return new ModelAndView("personPage", model);
	}

	/* ============= Display Page Section Start ==================== */
	@RequestMapping(value = "/getPerson", method = RequestMethod.GET)
	public ModelAndView getPerson(@ModelAttribute("person") Person person) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("personRecords", prepareAllPerson(personService.getAllPerson()));
		//model.put("personRecords", personService.getAllPerson());
		return new ModelAndView("personPage", model);
	}

	private List<PersonModel> prepareAllPerson(List<PersonModel> personModels) {
		List<PersonModel> personList = new ArrayList<PersonModel>();
		if (personModels != null && !personModels.isEmpty()) {
			for (PersonModel i : personModels) {
				PersonModel temp = new PersonModel();
				temp.setPersonId(i.getPersonId());
				temp.setPersonName(i.getPersonName());
				temp.setEmail(i.getEmail());
				temp.setPassword(i.getPassword());
				temp.setBirthDay(i.getBirthDay());
				temp.setGender(i.getGender());

				Set<AddressModel> addressModels = new HashSet<AddressModel>();
				if (i.getAddress() != null) {
					for (AddressModel j : i.getAddress()) {
						AddressModel addressModel = new AddressModel();
						addressModel.setAddressId(j.getAddressId());
						addressModel.setLine1(j.getLine1());
						addressModel.setLine2(j.getLine2());
						addressModel.setLine3(j.getLine3());
						addressModel.setCity(j.getCity());
						addressModel.setProvince(j.getProvince());
						addressModel.setCountry(j.getCountry());
						addressModel.setOtherDetails(j.getOtherDetails());
						addressModel.setAddressType(j.getAddressType());
						addressModels.add(addressModel);
					}

					temp.setAddress(addressModels);
				}
				personList.add(temp);
			}
		}
		return personList;
	}

	/* ============= POST Section Start ==================== */
	@RequestMapping(value = "/postPerson", method = RequestMethod.POST)
	public ModelAndView postPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("personPage", "person", person);
		}
		PersonModel personModel = preparePersonModel(person);
		personService.postPerson(personModel);
		return new ModelAndView("redirect:/person");
	}

	private PersonModel preparePersonModel(Person person) {

		PersonModel personModel = new PersonModel();
		personModel.setPersonId(person.getPersonId());
		personModel.setPersonName(person.getPersonName());
		personModel.setEmail(person.getEmail());
		personModel.setPassword(person.getPassword());
		personModel.setBirthDay(person.getBirthDay());
		personModel.setGender(person.getGender());

		Set<AddressModel> addressList = new HashSet<AddressModel>();
		if (person.getAddress() != null) {
			for (Address i : person.getAddress()) {
				AddressModel addressModel = new AddressModel();
				addressModel.setAddressId(i.getAddressId());
				addressModel.setLine1(i.getLine1());
				addressModel.setLine2(i.getLine2());
				addressModel.setLine3(i.getLine3());
				addressModel.setCity(i.getCity());
				addressModel.setProvince(i.getProvince());
				addressModel.setCountry(i.getCountry());
				addressModel.setOtherDetails(i.getOtherDetails());
				addressModel.setAddressType(i.getAddressType());
				addressList.add(addressModel);
			}
			personModel.setAddress(addressList);
		}
		return personModel;
	}

	/* ============= Put Section Start ==================== */
	@RequestMapping(value = "/putPerson", method = RequestMethod.GET)
	public ModelAndView putPerson(@ModelAttribute("person") Person person) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("person", preparePersonBean(personService.getPerson(person.getPersonId())));
		model.put("personRecords", prepareAllPerson(personService.getAllPerson()));
		return new ModelAndView("personPage", model);
	}

	private Person preparePersonBean(PersonModel personModel) {

		Set<Address> addressList = new HashSet<Address>();
		Set<AddressModel> addressModelList = new HashSet<AddressModel>();
		addressModelList = personModel.getAddress();
		for (AddressModel i : addressModelList) {
			Address address = new Address();
			address.setAddressId(i.getAddressId());
			address.setLine1(i.getLine1());
			address.setLine2(i.getLine2());
			address.setLine3(i.getLine3());
			address.setCity(i.getCity());
			address.setProvince(i.getProvince());
			address.setCountry(i.getCountry());
			address.setOtherDetails(i.getOtherDetails());
			address.setAddressType(i.getAddressType());
			addressList.add(address);
		}

		Person person = new Person();
		person.setPersonId(personModel.getPersonId());
		person.setPersonName(personModel.getPersonName());
		person.setEmail(personModel.getEmail());
		person.setPassword(personModel.getPassword());
		person.setBirthDay(personModel.getBirthDay());
		person.setGender(personModel.getGender());
		person.setAddress(addressList);

		return person;
	}

	/* ============= Delete Section Start ==================== */
	@RequestMapping(value = "/deletePerson", method = RequestMethod.GET)
	public ModelAndView deletePerson(@RequestParam("personId") String personId) {
		personService.deletePerson(personId);
		return new ModelAndView("redirect:/person");
	}

	@ModelAttribute("gender")
	public List<String> initializeGender() {
		List<String> gender = new ArrayList<String>();
		gender.add("Male");
		gender.add("Female");
		gender.add("Other");
		return gender;
	}

	@ModelAttribute("addressType")
	public List<String> initializeAddressType() {
		List<String> addressType = new ArrayList<String>();
		addressType.add("History Address");
		addressType.add("Current Address");
		return addressType;
	}
}
