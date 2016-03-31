package com.gll.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WebsiteModel {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int websiteId;
	private int userId;
	private String domainName;

	public WebsiteModel() {
	}

	public WebsiteModel(int websiteId, int userId, String domainName) {
		super();
		this.websiteId = websiteId;
		this.userId = userId;
		this.domainName = domainName;
	}

	public int getWebsiteId() {
		return websiteId;
	}

	public void setWebsiteId(int websiteId) {
		this.websiteId = websiteId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

}

