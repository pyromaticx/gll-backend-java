package com.gll.domain;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HistoryModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int historyId;
	private int userId;
	private int websiteId;
	private Date dateTime;
	
	public HistoryModel() {
	}

	public int getHistoryId() {
		return historyId;
	}

	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getWebsiteId() {
		return websiteId;
	}

	public void setWebsiteId(int websiteId) {
		this.websiteId = websiteId;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "HistoryBean [historyId=" + historyId + ", userId=" + userId + ", websiteId=" + websiteId + ", dateTime="
				+ dateTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateTime == null) ? 0 : dateTime.hashCode());
		result = prime * result + historyId;
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
		HistoryModel other = (HistoryModel) obj;
		if (dateTime == null) {
			if (other.dateTime != null)
				return false;
		} else if (!dateTime.equals(other.dateTime))
			return false;
		if (historyId != other.historyId)
			return false;
		if (userId != other.userId)
			return false;
		if (websiteId != other.websiteId)
			return false;
		return true;
	}

	
	
}
