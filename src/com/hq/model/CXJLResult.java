package com.hq.model;

import java.util.ArrayList;

public class CXJLResult {
	private CXJLsummaryData summaryData;
	private ArrayList<CXJLcarClaimRecord> carClaimRecords;

	public CXJLsummaryData getSummaryData() {
		return summaryData;
	}

	public void setSummaryData(CXJLsummaryData summaryData) {
		this.summaryData = summaryData;
	}

	public ArrayList<CXJLcarClaimRecord> getCarClaimRecords() {
		return carClaimRecords;
	}

	public void setCarClaimRecords(ArrayList<CXJLcarClaimRecord> carClaimRecords) {
		this.carClaimRecords = carClaimRecords;
	}

}
