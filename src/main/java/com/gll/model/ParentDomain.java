package com.gll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ParentDomain {
	/*
	 * Auto generated Primary.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int parentDomainId;
	private String parentDomainName;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	@OneToOne
	private int updatedBy;


	public ParentDomain(int parentDomainId, String parentDomainName, char useStatus, String programId, String locId,
			Date timeUpdated, int updatedBy) {
		super();
		this.parentDomainId = parentDomainId;
		this.parentDomainName = parentDomainName;
		this.useStatus = useStatus;
		this.programId = programId;
		LocId = locId;
		this.timeUpdated = timeUpdated;
		this.updatedBy = updatedBy;
	}

	public int getParentURLId() {
		return parentDomainId;
	}

	public void setParentURLId(int parentURLId) {
		this.parentDomainId = parentDomainId;
	}

	public String getParentURLDomain() {
		return parentDomainName;
	}

	public void setParentURLDomain(String parentURLDomain) {
		this.parentDomainName = parentURLDomain;
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
		this.updatedBy = updatedBy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((LocId == null) ? 0 : LocId.hashCode());
		result = prime * result + ((parentDomainName == null) ? 0 : parentDomainName.hashCode());
		result = prime * result + parentDomainId;
		result = prime * result + ((programId == null) ? 0 : programId.hashCode());
		result = prime * result + ((timeUpdated == null) ? 0 : timeUpdated.hashCode());
		// result = prime * result + (useStatus ? 1231 : 1237);
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
		ParentUrl other = (ParentUrl) obj;
		if (LocId == null) {
			if (other.LocId != null)
				return false;
		} else if (!LocId.equals(other.LocId))
			return false;
		if (parentDomainName == null) {
			if (other.parentDomainName != null)
				return false;
		} else if (!parentDomainName.equals(other.parentDomainName))
			return false;
		if (parentDomainId != other.parentDomainId)
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
		if (updatedBy != other.updatedBy
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ParentUrl [parentURLId=" + parentURLId + ", parentURLDomain=" + parentURLDomain + ", useStatus="
				+ useStatus + ", programId=" + programId + ", LocId=" + LocId + ", timeUpdated=" + timeUpdated
				+ ", userId=" + userId + "]";
	}

}