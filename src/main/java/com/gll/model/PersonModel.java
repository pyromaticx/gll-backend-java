package com.gll.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class PersonModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int personId;
	private String personName;
	private String email;
	private String password;
	private Date birthDay;
	private String gender;
	
	@OneToMany(fetch=FetchType.LAZY,  cascade = CascadeType.ALL)
	@JoinColumn(name = "personId_addressId")
	private Set<AddressModel> address;
	
	public PersonModel() {
	
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Set<AddressModel> getAddress() {
		return address;
	}

	public void setAddress(Set<AddressModel> address) {
		this.address = address;
	}


	
}
