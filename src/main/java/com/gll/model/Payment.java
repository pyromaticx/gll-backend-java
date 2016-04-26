package com.gll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Payment {

	/*
	 * Auto generated Primary.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int paymentId;
	@OneToOne
	private String paymentCurrency;
	private String paymentGateway;
	private String paymentStatus;
	private String paymentReferenceToken;
	private int premiumPlanId;
	
	private Date paymentDate;
	private int paymentCardTypeId;
	private double paymentAmount;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	@OneToOne
	private int updatedBy;

	public Payment() {
		// TODO Auto-generated constructor stub
	}

	public Payment(int paymentId, int customerId, Date paymentDate, int paymentCardTypeId, double paymentAmount,
			char useStatus, String programId, String locId, Date timeUpdated, int updatedBy) {
		super();
		this.paymentId = paymentId;
		this.paymentDate = paymentDate;
		this.paymentCardTypeId = paymentCardTypeId;
		this.paymentAmount = paymentAmount;
		this.useStatus = useStatus;
		this.programId = programId;
		LocId = locId;
		this.timeUpdated = timeUpdated;
		this.updatedBy = updatedBy;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}


	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getPaymentCardTypeId() {
		return paymentCardTypeId;
	}

	public void setPaymentCardTypeId(int paymentCardTypeId) {
		this.paymentCardTypeId = paymentCardTypeId;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
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

	

	public String getPaymentCurrency() {
		return paymentCurrency;
	}

	public void setPaymentCurrency(String paymentCurrency) {
		this.paymentCurrency = paymentCurrency;
	}

	public String getPaymentGateway() {
		return paymentGateway;
	}

	public void setPaymentGateway(String paymentGateway) {
		this.paymentGateway = paymentGateway;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getPaymentReferenceToken() {
		return paymentReferenceToken;
	}

	public void setPaymentReferenceToken(String paymentReferenceToken) {
		this.paymentReferenceToken = paymentReferenceToken;
	}

	public int getPremiumPlanId() {
		return premiumPlanId;
	}

	public void setPremiumPlanId(int premiumPlanId) {
		this.premiumPlanId = premiumPlanId;
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
		result = prime * result + customerId;
		long temp;
		temp = Double.doubleToLongBits(paymentAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + paymentCardTypeId;
		result = prime * result + ((paymentDate == null) ? 0 : paymentDate.hashCode());
		result = prime * result + paymentId;
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
		Payment other = (Payment) obj;
		if (LocId == null) {
			if (other.LocId != null)
				return false;
		} else if (!LocId.equals(other.LocId))
			return false;
		if (customerId != other.customerId)
			return false;
		if (Double.doubleToLongBits(paymentAmount) != Double.doubleToLongBits(other.paymentAmount))
			return false;
		if (paymentCardTypeId != other.paymentCardTypeId)
			return false;
		if (paymentDate == null) {
			if (other.paymentDate != null)
				return false;
		} else if (!paymentDate.equals(other.paymentDate))
			return false;
		if (paymentId != other.paymentId)
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
		return "Payment [paymentId=" + paymentId + ", customerId=" + customerId + ", paymentDate=" + paymentDate
				+ ", paymentCardTypeId=" + paymentCardTypeId + ", paymentAmount=" + paymentAmount + ", useStatus="
				+ useStatus + ", programId=" + programId + ", LocId=" + LocId + ", timeUpdated=" + timeUpdated
				+ ", userId=" + userId + "]";
	}

}