package com.gll.model;

import javax.persistence.Embeddable;

@Embeddable
public class Comment {

	private String userName;
	private StringBuffer userComment;
	private String timeStamp;
	
	public Comment() {
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public StringBuffer getUserComment() {
		return userComment;
	}

	public void setUserComment(StringBuffer userComment) {
		this.userComment = userComment;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((timeStamp == null) ? 0 : timeStamp.hashCode());
		result = prime * result + ((userComment == null) ? 0 : userComment.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		Comment other = (Comment) obj;
		if (timeStamp == null) {
			if (other.timeStamp != null)
				return false;
		} else if (!timeStamp.equals(other.timeStamp))
			return false;
		if (userComment == null) {
			if (other.userComment != null)
				return false;
		} else if (!userComment.equals(other.userComment))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comment [userName=" + userName + ", userComment=" + userComment + ", timeStamp=" + timeStamp + "]";
	}

	
	
	
}
