package com.gll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Expertise {
	/*
	 * Auto generated Primary.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int expertiseId;
	private String expertiseDescription;
	private String useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	@OneToOne
	private int userId;
	
	public Expertise() {
		// TODO Auto-generated constructor stub
	}

	public Expertise(int expertiseId, String expertiseDescription, String useStatus, String programId, String locId,
			Date timeUpdated, int userId) {
		super();
		this.expertiseId = expertiseId;
		this.expertiseDescription = expertiseDescription;
		this.useStatus = useStatus;
		this.programId = programId;
		LocId = locId;
		this.timeUpdated = timeUpdated;
		this.userId = userId;
	}

	public int getExpertiseId() {
		return expertiseId;
	}

	public void setExpertiseId(int expertiseId) {
		this.expertiseId = expertiseId;
	}

	public String getExpertiseDescription() {
		return expertiseDescription;
	}

	public void setExpertiseDescription(String expertiseDescription) {
		this.expertiseDescription = expertiseDescription;
	}

	public String getUseStatus() {
		return useStatus;
	}

	public void setUseStatus(String useStatus) {
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
		result = prime * result + ((expertiseDescription == null) ? 0 : expertiseDescription.hashCode());
		result = prime * result + expertiseId;
		result = prime * result + ((programId == null) ? 0 : programId.hashCode());
		result = prime * result + ((timeUpdated == null) ? 0 : timeUpdated.hashCode());
		result = prime * result + ((useStatus == null) ? 0 : useStatus.hashCode());
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
		Expertise other = (Expertise) obj;
		if (LocId == null) {
			if (other.LocId != null)
				return false;
		} else if (!LocId.equals(other.LocId))
			return false;
		if (expertiseDescription == null) {
			if (other.expertiseDescription != null)
				return false;
		} else if (!expertiseDescription.equals(other.expertiseDescription))
			return false;
		if (expertiseId != other.expertiseId)
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
		if (useStatus == null) {
			if (other.useStatus != null)
				return false;
		} else if (!useStatus.equals(other.useStatus))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Expertise [expertiseId=" + expertiseId + ", expertiseDescription=" + expertiseDescription
				+ ", useStatus=" + useStatus + ", programId=" + programId + ", LocId=" + LocId + ", timeUpdated="
				+ timeUpdated + ", userId=" + userId + "]";
	}
	
	
}