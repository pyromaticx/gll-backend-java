package com.gll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ReactionType {
	private int reactionTypeId;
	private int reactionTypeDescription;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	private int updatedBy;
	
	public ReactionType(int reactionTypeId, int reactionTypeDescription, char useStatus, String programId, String locId,
			Date timeUpdated, int updatedBy) {
		super();
		this.reactionTypeId = reactionTypeId;
		this.reactionTypeDescription = reactionTypeDescription;
		this.useStatus = useStatus;
		this.programId = programId;
		LocId = locId;
		this.timeUpdated = timeUpdated;
		this.updatedBy = updatedBy;
	}

	public int getReactionTypeId() {
		return reactionTypeId;
	}

	public void setReactionTypeId(int reactionTypeId) {
		this.reactionTypeId = reactionTypeId;
	}

	public int getReactionTypeDescription() {
		return reactionTypeDescription;
	}

	public void setReactionTypeDescription(int reactionTypeDescription) {
		this.reactionTypeDescription = reactionTypeDescription;
	}

	public char getUseStatus() {
		return useStatus;
	}

	public void setUseStatus(char useStatus) {
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

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((LocId == null) ? 0 : LocId.hashCode());
		result = prime * result + ((programId == null) ? 0 : programId.hashCode());
		result = prime * result + reactionTypeDescription;
		result = prime * result + reactionTypeId;
		result = prime * result + ((timeUpdated == null) ? 0 : timeUpdated.hashCode());
		result = prime * result + updatedBy;
		result = prime * result + useStatus;
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
		ReactionType other = (ReactionType) obj;
		if (LocId == null) {
			if (other.LocId != null)
				return false;
		} else if (!LocId.equals(other.LocId))
			return false;
		if (programId == null) {
			if (other.programId != null)
				return false;
		} else if (!programId.equals(other.programId))
			return false;
		if (reactionTypeDescription != other.reactionTypeDescription)
			return false;
		if (reactionTypeId != other.reactionTypeId)
			return false;
		if (timeUpdated == null) {
			if (other.timeUpdated != null)
				return false;
		} else if (!timeUpdated.equals(other.timeUpdated))
			return false;
		if (updatedBy != other.updatedBy)
			return false;
		if (useStatus != other.useStatus)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReactionType [reactionTypeId=" + reactionTypeId + ", reactionTypeDescription=" + reactionTypeDescription
				+ ", useStatus=" + useStatus + ", programId=" + programId + ", LocId=" + LocId + ", timeUpdated="
				+ timeUpdated + ", updatedBy=" + updatedBy + "]";
	}
	
	
	
}