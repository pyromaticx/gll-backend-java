package com.gll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PinType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pinId;
	
	/* It could be:
	 * 1. Visual Designer
	 * 2. Interaction Designer
	 * 3. Prototyper
	 * 4. User Tester
	 * 5. Information Architect
	 * 6. User Researcher
	 * 7. Content Writer etc
	 * 
	 * */
	private String pinDescription;
	private String pinColor;
	private boolean useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	@OneToOne
	private int userId;
	
	public PinType() {
		// TODO Auto-generated constructor stub
	}

	public PinType(int pinId, String pinDescription, String pinColor, boolean useStatus, String programId, String locId,
			Date timeUpdated, int userId) {
		super();
		this.pinId = pinId;
		this.pinDescription = pinDescription;
		this.pinColor = pinColor;
		this.useStatus = useStatus;
		this.programId = programId;
		LocId = locId;
		this.timeUpdated = timeUpdated;
		this.userId = userId;
	}

	public int getPinId() {
		return pinId;
	}

	public void setPinId(int pinId) {
		this.pinId = pinId;
	}

	public String getPinDescription() {
		return pinDescription;
	}

	public void setPinDescription(String pinDescription) {
		this.pinDescription = pinDescription;
	}

	public String getPinColor() {
		return pinColor;
	}

	public void setPinColor(String pinColor) {
		this.pinColor = pinColor;
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
		result = prime * result + ((pinColor == null) ? 0 : pinColor.hashCode());
		result = prime * result + ((pinDescription == null) ? 0 : pinDescription.hashCode());
		result = prime * result + pinId;
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
		PinType other = (PinType) obj;
		if (LocId == null) {
			if (other.LocId != null)
				return false;
		} else if (!LocId.equals(other.LocId))
			return false;
		if (pinColor == null) {
			if (other.pinColor != null)
				return false;
		} else if (!pinColor.equals(other.pinColor))
			return false;
		if (pinDescription == null) {
			if (other.pinDescription != null)
				return false;
		} else if (!pinDescription.equals(other.pinDescription))
			return false;
		if (pinId != other.pinId)
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
		return "PinType [pinId=" + pinId + ", pinDescription=" + pinDescription + ", pinColor=" + pinColor
				+ ", useStatus=" + useStatus + ", programId=" + programId + ", LocId=" + LocId + ", timeUpdated="
				+ timeUpdated + ", userId=" + userId + "]";
	}
	
	
}
