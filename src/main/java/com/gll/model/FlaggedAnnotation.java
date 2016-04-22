package com.gll.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class FlaggedAnnotation {

	/*
	 * Auto generated Primary.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int flaggedAnnotationId;

	/*
	 * With the help of annotationId property you can know, which annotation has
	 * been flagged out!
	 */
	private int annotationId;

	/*
	 * It will depict who is flagging.
	 */
	private int userId;

	/*
	 * Detailed Descriptions, why annotation being flagged out.
	 */
	private String description; //

}
