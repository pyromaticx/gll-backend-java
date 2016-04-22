package com.gll.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserPin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pinId;
	
	/* It could be:
	 * 1. Visual Designer
	 * 2. Interaction Designer
	 * 3. Prototyper
	 * 4. User Tester
	 * 5. Information Architect
	 * 6. User Researcher
	 * 7. Content Writer etc
	 * 
	 * */
	private String pinType;
	
	
	
}
