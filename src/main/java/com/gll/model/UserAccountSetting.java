package com.gll.model;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserAccountSetting {
	/*
	 * Auto generated Primary.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private char[] userPassword[];
	private int userTypeId;
	private int userTierId;
	private boolean useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;

	public UserAccountSetting() {
		// TODO Auto-generated constructor stub
	}

	public UserAccountSetting(int userId, char[][] userPassword, int userTypeId, int userTierId, boolean useStatus,
			String programId, String locId, Date timeUpdated) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.userTypeId = userTypeId;
		this.userTierId = userTierId;
		this.useStatus = useStatus;
		this.programId = programId;
		LocId = locId;
		this.timeUpdated = timeUpdated;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public char[][] getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(char[][] userPassword) {
		this.userPassword = userPassword;
	}

	public int getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}

	public int getUserTierId() {
		return userTierId;
	}

	public void setUserTierId(int userTierId) {
		this.userTierId = userTierId;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((LocId == null) ? 0 : LocId.hashCode());
		result = prime * result + ((programId == null) ? 0 : programId.hashCode());
		result = prime * result + ((timeUpdated == null) ? 0 : timeUpdated.hashCode());
		result = prime * result + (useStatus ? 1231 : 1237);
		result = prime * result + userId;
		result = prime * result + Arrays.deepHashCode(userPassword);
		result = prime * result + userTierId;
		result = prime * result + userTypeId;
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
		UserAccountSetting other = (UserAccountSetting) obj;
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
		if (!Arrays.deepEquals(userPassword, other.userPassword))
			return false;
		if (userTierId != other.userTierId)
			return false;
		if (userTypeId != other.userTypeId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserAccountSetting [userId=" + userId + ", userPassword=" + Arrays.toString(userPassword)
				+ ", userTypeId=" + userTypeId + ", userTierId=" + userTierId + ", useStatus=" + useStatus
				+ ", programId=" + programId + ", LocId=" + LocId + ", timeUpdated=" + timeUpdated + "]";
	}

}
