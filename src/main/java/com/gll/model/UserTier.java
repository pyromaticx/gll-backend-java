package com.gll.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserTier {

	/*
	 * Auto generated Primary.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userTierId;
	private String userTierDescription;
	private boolean useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	private int userId;
	
	public UserTier() {
		// TODO Auto-generated constructor stub
	}

	public UserTier(int userTierId, String userTierDescription, boolean useStatus, String programId, String locId,
			Date timeUpdated, int userId) {
		super();
		this.userTierId = userTierId;
		this.userTierDescription = userTierDescription;
		this.useStatus = useStatus;
		this.programId = programId;
		LocId = locId;
		this.timeUpdated = timeUpdated;
		this.userId = userId;
	}

	public int getUserTierId() {
		return userTierId;
	}

	public void setUserTierId(int userTierId) {
		this.userTierId = userTierId;
	}

	public String getUserTierDescription() {
		return userTierDescription;
	}

	public void setUserTierDescription(String userTierDescription) {
		this.userTierDescription = userTierDescription;
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
		result = prime * result + ((programId == null) ? 0 : programId.hashCode());
		result = prime * result + ((timeUpdated == null) ? 0 : timeUpdated.hashCode());
		result = prime * result + (useStatus ? 1231 : 1237);
		result = prime * result + userId;
		result = prime * result + ((userTierDescription == null) ? 0 : userTierDescription.hashCode());
		result = prime * result + userTierId;
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
		UserTier other = (UserTier) obj;
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
		if (timeUpdated == null) {
			if (other.timeUpdated != null)
				return false;
		} else if (!timeUpdated.equals(other.timeUpdated))
			return false;
		if (useStatus != other.useStatus)
			return false;
		if (userId != other.userId)
			return false;
		if (userTierDescription == null) {
			if (other.userTierDescription != null)
				return false;
		} else if (!userTierDescription.equals(other.userTierDescription))
			return false;
		if (userTierId != other.userTierId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserTier [userTierId=" + userTierId + ", userTierDescription=" + userTierDescription + ", useStatus="
				+ useStatus + ", programId=" + programId + ", LocId=" + LocId + ", timeUpdated=" + timeUpdated
				+ ", userId=" + userId + "]";
	}
	
	
}