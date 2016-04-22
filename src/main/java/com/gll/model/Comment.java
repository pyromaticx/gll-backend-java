package com.gll.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int commentId;
	/*
	 * Foreign key. It will depict who is giving comment
	 */
	private int userId;
	private StringBuffer userComment;
	private String timeStamp;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private AnnotationModel annotationModel;

}
