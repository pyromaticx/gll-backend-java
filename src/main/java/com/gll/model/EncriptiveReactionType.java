package com.gll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class EncriptiveReactionType {
	/*
	 * Auto generated Primary.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int encryptiveReactionTypeId;
	private String encryptiveReactionTypeDescription; // For social shares,
														// voting
	private String encryptiveReactionTypeValues; // pass/fail, fb, linkedin,
													// pinterest, google,
													// twitter, star annotation
	private boolean useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	@OneToOne
	private int userId;
	
	public EncriptiveReactionType() {
		// TODO Auto-generated constructor stub
	}

	public EncriptiveReactionType(int encryptiveReactionTypeId, String encryptiveReactionTypeDescription,
			String encryptiveReactionTypeValues, boolean useStatus, String programId, String locId, Date timeUpdated,
			int userId) {
		super();
		this.encryptiveReactionTypeId = encryptiveReactionTypeId;
		this.encryptiveReactionTypeDescription = encryptiveReactionTypeDescription;
		this.encryptiveReactionTypeValues = encryptiveReactionTypeValues;
		this.useStatus = useStatus;
		this.programId = programId;
		LocId = locId;
		this.timeUpdated = timeUpdated;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "EncriptiveReactionType [encryptiveReactionTypeId=" + encryptiveReactionTypeId
				+ ", encryptiveReactionTypeDescription=" + encryptiveReactionTypeDescription
				+ ", encryptiveReactionTypeValues=" + encryptiveReactionTypeValues + ", useStatus=" + useStatus
				+ ", programId=" + programId + ", LocId=" + LocId + ", timeUpdated=" + timeUpdated + ", userId="
				+ userId + "]";
	}

	public int getEncryptiveReactionTypeId() {
		return encryptiveReactionTypeId;
	}

	public void setEncryptiveReactionTypeId(int encryptiveReactionTypeId) {
		this.encryptiveReactionTypeId = encryptiveReactionTypeId;
	}

	public String getEncryptiveReactionTypeDescription() {
		return encryptiveReactionTypeDescription;
	}

	public void setEncryptiveReactionTypeDescription(String encryptiveReactionTypeDescription) {
		this.encryptiveReactionTypeDescription = encryptiveReactionTypeDescription;
	}

	public String getEncryptiveReactionTypeValues() {
		return encryptiveReactionTypeValues;
	}

	public void setEncryptiveReactionTypeValues(String encryptiveReactionTypeValues) {
		this.encryptiveReactionTypeValues = encryptiveReactionTypeValues;
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
				+ ((encryptiveReactionTypeDescription == null) ? 0 : encryptiveReactionTypeDescription.hashCode());
		result = prime * result + encryptiveReactionTypeId;
		result = prime * result
				+ ((encryptiveReactionTypeValues == null) ? 0 : encryptiveReactionTypeValues.hashCode());
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
		EncriptiveReactionType other = (EncriptiveReactionType) obj;
		if (LocId == null) {
			if (other.LocId != null)
				return false;
		} else if (!LocId.equals(other.LocId))
			return false;
		if (encryptiveReactionTypeDescription == null) {
			if (other.encryptiveReactionTypeDescription != null)
				return false;
		} else if (!encryptiveReactionTypeDescription.equals(other.encryptiveReactionTypeDescription))
			return false;
		if (encryptiveReactionTypeId != other.encryptiveReactionTypeId)
			return false;
		if (encryptiveReactionTypeValues == null) {
			if (other.encryptiveReactionTypeValues != null)
				return false;
		} else if (!encryptiveReactionTypeValues.equals(other.encryptiveReactionTypeValues))
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