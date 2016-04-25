package com.gll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PinContentType {
	/*
	 * Auto generated Primary.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pinContentId;
	private String pinContentDescription;
	private boolean useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	@OneToOne
	private int userId;
	
	public PinContentType() {
		// TODO Auto-generated constructor stub
	}

	public PinContentType(int pinContentId, String pinContentDescription, boolean useStatus, String programId,
			String locId, Date timeUpdated, int userId) {
		super();
		this.pinContentId = pinContentId;
		this.pinContentDescription = pinContentDescription;
		this.useStatus = useStatus;
		this.programId = programId;
		LocId = locId;
		this.timeUpdated = timeUpdated;
		this.userId = userId;
	}

	public int getPinContentId() {
		return pinContentId;
	}

	public void setPinContentId(int pinContentId) {
		this.pinContentId = pinContentId;
	}

	public String getPinContentDescription() {
		return pinContentDescription;
	}

	public void setPinContentDescription(String pinContentDescription) {
		this.pinContentDescription = pinContentDescription;
	}

	public boolean isUseStatus() {
		return useStatus;
	}

	public void setUseStatus(boolean useStatus) {
		this.useStatus = useStatus;
	}

	public String getProgramId() {
		return programId;
	}

	public void setProgramId(String programId) {
		this.programId = programId;
	}

	public String getLocId() {
		return LocId;
	}

	public void setLocId(String locId) {
		LocId = locId;
	}

	public Date getTimeUpdated() {
		return timeUpdated;
	}

	public void setTimeUpdated(Date timeUpdated) {
		this.timeUpdated = timeUpdated;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((LocId == null) ? 0 : LocId.hashCode());
		result = prime * result + ((pinContentDescription == null) ? 0 : pinContentDescription.hashCode());
		result = prime * result + pinContentId;
		result = prime * result + ((programId == null) ? 0 : programId.hashCode());
		result = prime * result + ((timeUpdated == null) ? 0 : timeUpdated.hashCode());
		result = prime * result + (useStatus ? 1231 : 1237);
		result = prime * result + userId;
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
		PinContentType other = (PinContentType) obj;
		if (LocId == null) {
			if (other.LocId != null)
				return false;
		} else if (!LocId.equals(other.LocId))
			return false;
		if (pinContentDescription == null) {
			if (other.pinContentDescription != null)
				return false;
		} else if (!pinContentDescription.equals(other.pinContentDescription))
			return false;
		if (pinContentId != other.pinContentId)
			return false;
		if (programId == null) {
			if (other.programId != null)
				return false;
		} else if (!programId.equals(other.programId))
			return false;
		if (timeUpdated == null) {
			if (other.timeUpdated != null)
				return false;
		} else if (!timeUpdated.equals(other.timeUpdated))
			return false;
		if (useStatus != other.useStatus)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PinContentType [pinContentId=" + pinContentId + ", pinContentDescription=" + pinContentDescription
				+ ", useStatus=" + useStatus + ", programId=" + programId + ", LocId=" + LocId + ", timeUpdated="
				+ timeUpdated + ", userId=" + userId + "]";
	}
	
	

}
