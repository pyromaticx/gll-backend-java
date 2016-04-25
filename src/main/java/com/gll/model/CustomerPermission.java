package com.gll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CustomerPermission {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerPermissionId;
	@OneToOne
	private int premiumPlanId;
	private String customerPermissionDescription;
	private boolean useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	@OneToOne
	private int userId;
	
	public CustomerPermission() {
		// TODO Auto-generated constructor stub
	}

	public CustomerPermission(int customerPermissionId, int premiumPlanId, String customerPermissionDescription,
			boolean useStatus, String programId, String locId, Date timeUpdated, int userId) {
		super();
		this.customerPermissionId = customerPermissionId;
		this.premiumPlanId = premiumPlanId;
		this.customerPermissionDescription = customerPermissionDescription;
		this.useStatus = useStatus;
		this.programId = programId;
		LocId = locId;
		this.timeUpdated = timeUpdated;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "CustomerPermission [customerPermissionId=" + customerPermissionId + ", premiumPlanId=" + premiumPlanId
				+ ", customerPermissionDescription=" + customerPermissionDescription + ", useStatus=" + useStatus
				+ ", programId=" + programId + ", LocId=" + LocId + ", timeUpdated=" + timeUpdated + ", userId="
				+ userId + "]";
	}

	public int getCustomerPermissionId() {
		return customerPermissionId;
	}

	public void setCustomerPermissionId(int customerPermissionId) {
		this.customerPermissionId = customerPermissionId;
	}

	public int getPremiumPlanId() {
		return premiumPlanId;
	}

	public void setPremiumPlanId(int premiumPlanId) {
		this.premiumPlanId = premiumPlanId;
	}

	public String getCustomerPermissionDescription() {
		return customerPermissionDescription;
	}

	public void setCustomerPermissionDescription(String customerPermissionDescription) {
		this.customerPermissionDescription = customerPermissionDescription;
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
	
	
}