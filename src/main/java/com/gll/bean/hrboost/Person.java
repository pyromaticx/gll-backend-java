package com.gll.bean.hrboost;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@XmlRootElement(name = "Person")
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int personId;
	
	@NotEmpty(message="Please do not leave it lank...")
	@Size(min=5, max=25, message="Name should be 5 to 25 letters only")
	private String personName;

	@NotNull
	@Email
	private String email;
	
	@NotNull
	private String password;
	
	@NotNull
	private Date birthDay;
	
	@NotNull
	private String gender;
	
	@Valid
	private Set<Address> address;

	public Person() {
		
	}

	public Person(String personName) {
		super();
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

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}
	
}
