package com.gll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class UserActivityLog {
	/*
	 * Auto generated Primary.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int activeUserId;
	private Date lastLogin;
	private String activityDescription;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	@OneToOne
	private int updatedBy;
	
	public UserActivityLog() {
		
	}

	public UserActivityLog(int activeUserId, Date lastLogin, char useStatus, String programId, String locId,
			Date timeUpdated, int userId) {
		super();
		this.activeUserId = activeUserId;
		this.lastLogin = lastLogin;
		this.useStatus = useStatus;
		this.programId = programId;
		LocId = locId;
		this.timeUpdated = timeUpdated;
		this.updatedBy = updatedBy;
	}

	public int getActiveUserId() {
		return activeUserId;
	}

	public void setActiveUserId(int activeUserId) {
		this.activeUserId = activeUserId;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public char isUseStatus() {
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

	public void setUpdatedBy(int userId) {
		this.updatedBy = userId;
	}

	public String getActivityDescription() {
		return activityDescription;
	}

	public void setActivityDescription(String activityDescription) {
		this.activityDescription = activityDescription;
	}

	public char getUseStatus() {
		return useStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((LocId == null) ? 0 : LocId.hashCode());
		result = prime * result + activeUserId;
		result = prime * result + ((lastLogin == null) ? 0 : lastLogin.hashCode());
		result = prime * result + ((programId == null) ? 0 : programId.hashCode());
		result = prime * result + ((timeUpdated == null) ? 0 : timeUpdated.hashCode());
		result = prime * result + (useStatus ? 1231 : 1237);
		result = prime * result + updatedBy;
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
		UserActivityLog other = (UserActivityLog) obj;
		if (LocId == null) {
			if (other.LocId != null)
				return false;
		} else if (!LocId.equals(other.LocId))
			return false;
		if (activeUserId != other.activeUserId)
			return false;
		if (lastLogin == null) {
			if (other.lastLogin != null)
				return false;
		} else if (!lastLogin.equals(other.lastLogin))
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
		if (updatedBy != other.updatedBy)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserActivityLog [activeUserId=" + activeUserId + ", lastLogin=" + lastLogin + ", useStatus=" + useStatus
				+ ", programId=" + programId + ", LocId=" + LocId + ", timeUpdated=" + timeUpdated + ", userId="
				+ updatedBy + "]";
	}
	
	
	
}