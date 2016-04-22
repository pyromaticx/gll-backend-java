package com.gll.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class WebsiteModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long websiteId;
	
	/*
	 * Foreign Key
	*/
	private long userId;
	
	@OneToMany
	private AnnotationModel annotationModel;
	
	private String rootDomain;
	private String domainName;

	public WebsiteModel() {
	}
}

