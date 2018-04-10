package com.hq.model;

import java.util.ArrayList;

public class CXJLcarClaimRecord {
	private ArrayList<CXJLclaimDetail> claimDetails;
	private String licenseNo;
	private String otherAmount;
	private String repairAmount;
	private String renewalAmount;
	private String dangerTime;
	private String damageMoney;

	public ArrayList<CXJLclaimDetail> getClaimDetails() {
		return claimDetails;
	}

	public void setClaimDetails(ArrayList<CXJLclaimDetail> claimDetails) {
		this.claimDetails = claimDetails;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getOtherAmount() {
		return otherAmount;
	}

	public void setOtherAmount(String otherAmount) {
		this.otherAmount = otherAmount;
	}

	public String getRepairAmount() {
		return repairAmount;
	}

	public void setRepairAmount(String repairAmount) {
		this.repairAmount = repairAmount;
	}

	public String getRenewalAmount() {
		return renewalAmount;
	}

	public void setRenewalAmount(String renewalAmount) {
		this.renewalAmount = renewalAmount;
	}

	public String getDangerTime() {
		return dangerTime;
	}

	public void setDangerTime(String dangerTime) {
		this.dangerTime = dangerTime;
	}

	public String getDamageMoney() {
		return damageMoney;
	}

	public void setDamageMoney(String damageMoney) {
		this.damageMoney = damageMoney;
	}

}
