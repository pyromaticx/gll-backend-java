package com.gll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PremiumPlan {
	/*
	 * Auto generated Primary.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int premiumPlanId;
	private String premiumPlanDescription;
	private double premiumPlanCost;
	private String premiumPlanCurrency;
	private int maxURLsAllowed;
	private int planEffectiveDays; // 30[monthly], 365 [yearly]
	private boolean useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	@OneToOne
	private int userId;
	
	public PremiumPlan() {
		// TODO Auto-generated constructor stub
	}

	public PremiumPlan(int premiumPlanId, String premiumPlanDescription, double premiumPlanCost,
			String premiumPlanCurrency, int maxURLsAllowed, int planEffectiveDays, boolean useStatus, String programId,
			String locId, Date timeUpdated, int userId) {
		super();
		this.premiumPlanId = premiumPlanId;
		this.premiumPlanDescription = premiumPlanDescription;
		this.premiumPlanCost = premiumPlanCost;
		this.premiumPlanCurrency = premiumPlanCurrency;
		this.maxURLsAllowed = maxURLsAllowed;
		this.planEffectiveDays = planEffectiveDays;
		this.useStatus = useStatus;
		this.programId = programId;
		LocId = locId;
		this.timeUpdated = timeUpdated;
		this.userId = userId;
	}

	
	
	public int getPremiumPlanId() {
		return premiumPlanId;
	}

	public void setPremiumPlanId(int premiumPlanId) {
		this.premiumPlanId = premiumPlanId;
	}

	public String getPremiumPlanDescription() {
		return premiumPlanDescription;
	}

	public void setPremiumPlanDescription(String premiumPlanDescription) {
		this.premiumPlanDescription = premiumPlanDescription;
	}

	public double getPremiumPlanCost() {
		return premiumPlanCost;
	}

	public void setPremiumPlanCost(double premiumPlanCost) {
		this.premiumPlanCost = premiumPlanCost;
	}

	public String getPremiumPlanCurrency() {
		return premiumPlanCurrency;
	}

	public void setPremiumPlanCurrency(String premiumPlanCurrency) {
		this.premiumPlanCurrency = premiumPlanCurrency;
	}

	public int getMaxURLsAllowed() {
		return maxURLsAllowed;
	}

	public void setMaxURLsAllowed(int maxURLsAllowed) {
		this.maxURLsAllowed = maxURLsAllowed;
	}

	public int getPlanEffectiveDays() {
		return planEffectiveDays;
	}

	public void setPlanEffectiveDays(int planEffectiveDays) {
		this.planEffectiveDays = planEffectiveDays;
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
		result = prime * result + maxURLsAllowed;
		result = prime * result + planEffectiveDays;
		long temp;
		temp = Double.doubleToLongBits(premiumPlanCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((premiumPlanCurrency == null) ? 0 : premiumPlanCurrency.hashCode());
		result = prime * result + ((premiumPlanDescription == null) ? 0 : premiumPlanDescription.hashCode());
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
		PremiumPlan other = (PremiumPlan) obj;
		if (LocId == null) {
			if (other.LocId != null)
				return false;
		} else if (!LocId.equals(other.LocId))
			return false;
		if (maxURLsAllowed != other.maxURLsAllowed)
			return false;
		if (planEffectiveDays != other.planEffectiveDays)
			return false;
		if (Double.doubleToLongBits(premiumPlanCost) != Double.doubleToLongBits(other.premiumPlanCost))
			return false;
		if (premiumPlanCurrency == null) {
			if (other.premiumPlanCurrency != null)
				return false;
		} else if (!premiumPlanCurrency.equals(other.premiumPlanCurrency))
			return false;
		if (premiumPlanDescription == null) {
			if (other.premiumPlanDescription != null)
				return false;
		} else if (!premiumPlanDescription.equals(other.premiumPlanDescription))
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
		return "PremiumPlan [premiumPlanId=" + premiumPlanId + ", premiumPlanDescription=" + premiumPlanDescription
				+ ", premiumPlanCost=" + premiumPlanCost + ", premiumPlanCurrency=" + premiumPlanCurrency
				+ ", maxURLsAllowed=" + maxURLsAllowed + ", planEffectiveDays=" + planEffectiveDays + ", useStatus="
				+ useStatus + ", programId=" + programId + ", LocId=" + LocId + ", timeUpdated=" + timeUpdated
				+ ", userId=" + userId + "]";
	}
	
	
}