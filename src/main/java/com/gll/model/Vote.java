package com.gll.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vote {

	/*
	 * Auto generated Primary.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int voteId;

	/*
	 * With the help of annotationId property you can know that vote belong to
	 * annotation!
	 */
	private int annotationId;
	
	/*
	 * It will depict who is giving vote.
	 */
	private int userId;
	
	/*
	 * It will have +1 or -1
	 */
	private int voteValue; //

}
