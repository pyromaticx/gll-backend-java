package com.gll.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Emoji {

	/*
	 * Auto generated Primary.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int emojiId;

	/*
	 * With the help of annotationId property you can know that annotation is liked!
	 */
	private int annotationId;
	
	/*
	 * It will depict who is liking.
	 */
	private int userId;
	
	/*
	 * emojiValue will contain 1 to 5;
	 */
	private String emojiValue; //

}
