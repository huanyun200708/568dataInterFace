package com.hq.model;

import java.util.HashMap;
import java.util.Map;

public class CityZiDian {
	private String error_code;
	private String reason;
	private Map<String,String> result = new HashMap<String,String> ();
	public String getError_code() {
		return error_code;
	}
	public void setError_code(String error_code) {
		this.error_code = error_code;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Map<String, String> getResult() {
		return result;
	}
	public void setResult(Map<String, String> result) {
		this.result = result;
	}
	
	
}
