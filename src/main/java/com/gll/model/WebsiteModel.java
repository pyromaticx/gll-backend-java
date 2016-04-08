package com.gll.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WebsiteModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int websiteId;
	private int userId;
	private String domainName;
	private String rootDomain;

	public WebsiteModel() {
	}

	public WebsiteModel(int websiteId, int userId, String domainName, String rootDomain) {
		super();
		this.websiteId = websiteId;
		this.userId = userId;
		this.domainName = domainName;
		this.rootDomain = rootDomain;
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

	public String getRootDomain() {
		return rootDomain;
	}

	public void setRootDomain(String rootDomain) {
		this.rootDomain = rootDomain;
	}

	@Override
	public String toString() {
		return "WebsiteModel [websiteId=" + websiteId + ", userId=" + userId + ", domainName=" + domainName
				+ ", rootDomain=" + rootDomain + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((domainName == null) ? 0 : domainName.hashCode());
		result = prime * result + ((rootDomain == null) ? 0 : rootDomain.hashCode());
		result = prime * result + userId;
		result = prime * result + websiteId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WebsiteModel other = (WebsiteModel) obj;
		if (domainName == null) {
			if (other.domainName != null)
				return false;
		} else if (!domainName.equals(other.domainName))
			return false;
		if (rootDomain == null) {
			if (other.rootDomain != null)
				return false;
		} else if (!rootDomain.equals(other.rootDomain))
			return false;
		if (userId != other.userId)
			return false;
		if (websiteId != other.websiteId)
			return false;
		return true;
	}

}
