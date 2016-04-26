package com.gll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author umesh
 *
 */
@Entity
public class UserPermissions {
	/*
	 * Auto generated Primary.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userPermissionId;
	private int userRoleId;
	private String userPermissionCode;
	private String userPermissionDescription;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	@OneToOne
	private int updatedBy;
	
	public UserPermissions() {
		// TODO Auto-generated constructor stub
	}

	public UserPermissions(int userPermissionId, int userRoleId, String userPermissionDescription, char useStatus,
			String programId, String locId, Date timeUpdated, int userId) {
		super();
		this.userPermissionId = userPermissionId;
		this.userRoleId = userRoleId;
		this.userPermissionDescription = userPermissionDescription;
		this.useStatus = useStatus;
		this.programId = programId;
		LocId = locId;
		this.timeUpdated = timeUpdated;
		this.updatedBy = updatedBy;
	}

	public int getUserPermissionId() {
		return userPermissionId;
	}

	public void setUserPermissionId(int userPermissionId) {
		this.userPermissionId = userPermissionId;
	}

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getUserPermissionDescription() {
		return userPermissionDescription;
	}

	public void setUserPermissionDescription(String userPermissionDescription) {
		this.userPermissionDescription = userPermissionDescription;
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

	public int getUserId() {
		return updatedBy;
	}

	public void setUserId(int userId) {
		this.updatedBy = updatedBy;
	}

	public String getUserPermissionCode() {
		return userPermissionCode;
	}

	public void setUserPermissionCode(String userPermissionCode) {
		this.userPermissionCode = userPermissionCode;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public char getUseStatus() {
		return useStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((LocId == null) ? 0 : LocId.hashCode());
		result = prime * result + ((programId == null) ? 0 : programId.hashCode());
		result = prime * result + ((timeUpdated == null) ? 0 : timeUpdated.hashCode());
		result = prime * result + (useStatus ? 1231 : 1237);
		result = prime * result + updatedBy;
		result = prime * result + ((userPermissionDescription == null) ? 0 : userPermissionDescription.hashCode());
		result = prime * result + userPermissionId;
		result = prime * result + userRoleId;
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
		UserPermissions other = (UserPermissions) obj;
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
		if (updatedBy != other.updatedBy)
			return false;
		if (userPermissionDescription == null) {
			if (other.userPermissionDescription != null)
				return false;
		} else if (!userPermissionDescription.equals(other.userPermissionDescription))
			return false;
		if (userPermissionId != other.userPermissionId)
			return false;
		if (userRoleId != other.userRoleId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserPermissions [userPermissionId=" + userPermissionId + ", userRoleId=" + userRoleId
				+ ", userPermissionDescription=" + userPermissionDescription + ", useStatus=" + useStatus
				+ ", programId=" + programId + ", LocId=" + LocId + ", timeUpdated=" + timeUpdated + ", userId="
				+ updatedBy + "]";
	}
	
	
}