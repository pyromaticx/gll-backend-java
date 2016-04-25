package com.gll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	private Date dateEffectiveFrom;
	private Date dateEffectiveThru;
	private int customerProfileId;
	@OneToMany
	private int premiumPlanId;
	@OneToMany
	private int paymentId;
	private boolean useStatus;
	@OneToOne
	private String programId;
	@OneToOne
	private String LocId;
	private Date timeUpdated;
	@OneToOne
	private int userId;
	
	public Customer() {
		
	}

	public Customer(int customerId, Date dateEffectiveFrom, Date dateEffectiveThru, int customerProfileId,
			int premiumPlanId, int paymentId, boolean useStatus, String programId, String locId, Date timeUpdated,
			int userId) {
		super();
		this.customerId = customerId;
		this.dateEffectiveFrom = dateEffectiveFrom;
		this.dateEffectiveThru = dateEffectiveThru;
		this.customerProfileId = customerProfileId;
		this.premiumPlanId = premiumPlanId;
		this.paymentId = paymentId;
		this.useStatus = useStatus;
		this.programId = programId;
		LocId = locId;
		this.timeUpdated = timeUpdated;
		this.userId = userId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Date getDateEffectiveFrom() {
		return dateEffectiveFrom;
	}

	public void setDateEffectiveFrom(Date dateEffectiveFrom) {
		this.dateEffectiveFrom = dateEffectiveFrom;
	}

	public Date getDateEffectiveThru() {
		return dateEffectiveThru;
	}

	public void setDateEffectiveThru(Date dateEffectiveThru) {
		this.dateEffectiveThru = dateEffectiveThru;
	}

	public int getCustomerProfileId() {
		return customerProfileId;
	}

	public void setCustomerProfileId(int customerProfileId) {
		this.customerProfileId = customerProfileId;
	}

	public int getPremiumPlanId() {
		return premiumPlanId;
	}

	public void setPremiumPlanId(int premiumPlanId) {
		this.premiumPlanId = premiumPlanId;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
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
		result = prime * result + customerId;
		result = prime * result + customerProfileId;
		result = prime * result + ((dateEffectiveFrom == null) ? 0 : dateEffectiveFrom.hashCode());
		result = prime * result + ((dateEffectiveThru == null) ? 0 : dateEffectiveThru.hashCode());
		result = prime * result + paymentId;
		result = prime * result + premiumPlanId;
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
		Customer other = (Customer) obj;
		if (LocId == null) {
			if (other.LocId != null)
				return false;
		} else if (!LocId.equals(other.LocId))
			return false;
		if (customerId != other.customerId)
			return false;
		if (customerProfileId != other.customerProfileId)
			return false;
		if (dateEffectiveFrom == null) {
			if (other.dateEffectiveFrom != null)
				return false;
		} else if (!dateEffectiveFrom.equals(other.dateEffectiveFrom))
			return false;
		if (dateEffectiveThru == null) {
			if (other.dateEffectiveThru != null)
				return false;
		} else if (!dateEffectiveThru.equals(other.dateEffectiveThru))
			return false;
		if (paymentId != other.paymentId)
			return false;
		if (premiumPlanId != other.premiumPlanId)
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

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", dateEffectiveFrom=" + dateEffectiveFrom
				+ ", dateEffectiveThru=" + dateEffectiveThru + ", customerProfileId=" + customerProfileId
				+ ", premiumPlanId=" + premiumPlanId + ", paymentId=" + paymentId + ", useStatus=" + useStatus
				+ ", programId=" + programId + ", LocId=" + LocId + ", timeUpdated=" + timeUpdated + ", userId="
				+ userId + "]";
	}
	
	
	
}