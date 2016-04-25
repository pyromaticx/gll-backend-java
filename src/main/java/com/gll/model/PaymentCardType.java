package com.gll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PaymentCardType {

	/*
	 * Auto generated Primary.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int paymentCardTypeId;
	private String paymentCardTypeDescription; // Visa, Mastercard, Discover
	private String paymentCardCountry;
	private String paymentCardCountryCurrency;
	private boolean useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	@OneToOne
	private int userId;
	
	public PaymentCardType() {
		// TODO Auto-generated constructor stub
	}

	public PaymentCardType(int paymentCardTypeId, String paymentCardTypeDescription, String paymentCardCountry,
			String paymentCardCountryCurrency, boolean useStatus, String programId, String locId, Date timeUpdated,
			int userId) {
		super();
		this.paymentCardTypeId = paymentCardTypeId;
		this.paymentCardTypeDescription = paymentCardTypeDescription;
		this.paymentCardCountry = paymentCardCountry;
		this.paymentCardCountryCurrency = paymentCardCountryCurrency;
		this.useStatus = useStatus;
		this.programId = programId;
		LocId = locId;
		this.timeUpdated = timeUpdated;
		this.userId = userId;
	}

	public int getPaymentCardTypeId() {
		return paymentCardTypeId;
	}

	public void setPaymentCardTypeId(int paymentCardTypeId) {
		this.paymentCardTypeId = paymentCardTypeId;
	}

	public String getPaymentCardTypeDescription() {
		return paymentCardTypeDescription;
	}

	public void setPaymentCardTypeDescription(String paymentCardTypeDescription) {
		this.paymentCardTypeDescription = paymentCardTypeDescription;
	}

	public String getPaymentCardCountry() {
		return paymentCardCountry;
	}

	public void setPaymentCardCountry(String paymentCardCountry) {
		this.paymentCardCountry = paymentCardCountry;
	}

	public String getPaymentCardCountryCurrency() {
		return paymentCardCountryCurrency;
	}

	public void setPaymentCardCountryCurrency(String paymentCardCountryCurrency) {
		this.paymentCardCountryCurrency = paymentCardCountryCurrency;
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
		result = prime * result + ((paymentCardCountry == null) ? 0 : paymentCardCountry.hashCode());
		result = prime * result + ((paymentCardCountryCurrency == null) ? 0 : paymentCardCountryCurrency.hashCode());
		result = prime * result + ((paymentCardTypeDescription == null) ? 0 : paymentCardTypeDescription.hashCode());
		result = prime * result + paymentCardTypeId;
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
		PaymentCardType other = (PaymentCardType) obj;
		if (LocId == null) {
			if (other.LocId != null)
				return false;
		} else if (!LocId.equals(other.LocId))
			return false;
		if (paymentCardCountry == null) {
			if (other.paymentCardCountry != null)
				return false;
		} else if (!paymentCardCountry.equals(other.paymentCardCountry))
			return false;
		if (paymentCardCountryCurrency == null) {
			if (other.paymentCardCountryCurrency != null)
				return false;
		} else if (!paymentCardCountryCurrency.equals(other.paymentCardCountryCurrency))
			return false;
		if (paymentCardTypeDescription == null) {
			if (other.paymentCardTypeDescription != null)
				return false;
		} else if (!paymentCardTypeDescription.equals(other.paymentCardTypeDescription))
			return false;
		if (paymentCardTypeId != other.paymentCardTypeId)
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
		return "PaymentCardType [paymentCardTypeId=" + paymentCardTypeId + ", paymentCardTypeDescription="
				+ paymentCardTypeDescription + ", paymentCardCountry=" + paymentCardCountry
				+ ", paymentCardCountryCurrency=" + paymentCardCountryCurrency + ", useStatus=" + useStatus
				+ ", programId=" + programId + ", LocId=" + LocId + ", timeUpdated=" + timeUpdated + ", userId="
				+ userId + "]";
	}
	
	
	}