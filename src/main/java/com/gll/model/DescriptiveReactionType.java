package com.gll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DescriptiveReactionType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int descriptiveReactionTypeId;
	private String descriptiveReactionTypeDescription; // For comment, flag
	private boolean useStatus;
	@OneToOne
	private String programId;
	@OneToOne
	private String LocId;
	private Date timeUpdated;
	@OneToOne
	private int userId;

	@Override
	public String toString() {
		return "DescriptiveReactionType [descriptiveReactionTypeId=" + descriptiveReactionTypeId
				+ ", descriptiveReactionTypeDescription=" + descriptiveReactionTypeDescription + ", useStatus="
				+ useStatus + ", programId=" + programId + ", LocId=" + LocId + ", timeUpdated=" + timeUpdated
				+ ", userId=" + userId + "]";
	}

	public int getDescriptiveReactionTypeId() {
		return descriptiveReactionTypeId;
	}

	public void setDescriptiveReactionTypeId(int descriptiveReactionTypeId) {
		this.descriptiveReactionTypeId = descriptiveReactionTypeId;
	}

	public String getDescriptiveReactionTypeDescription() {
		return descriptiveReactionTypeDescription;
	}

	public void setDescriptiveReactionTypeDescription(String descriptiveReactionTypeDescription) {
		this.descriptiveReactionTypeDescription = descriptiveReactionTypeDescription;
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
		result = prime * result
				+ ((descriptiveReactionTypeDescription == null) ? 0 : descriptiveReactionTypeDescription.hashCode());
		result = prime * result + descriptiveReactionTypeId;
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
		DescriptiveReactionType other = (DescriptiveReactionType) obj;
		if (LocId == null) {
			if (other.LocId != null)
				return false;
		} else if (!LocId.equals(other.LocId))
			return false;
		if (descriptiveReactionTypeDescription == null) {
			if (other.descriptiveReactionTypeDescription != null)
				return false;
		} else if (!descriptiveReactionTypeDescription.equals(other.descriptiveReactionTypeDescription))
			return false;
		if (descriptiveReactionTypeId != other.descriptiveReactionTypeId)
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

}