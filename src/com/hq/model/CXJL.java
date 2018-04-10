package com.hq.model;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import cn.com.hq.util.QueryAppKeyLib;
import cn.com.hq.util.SSLUtil;
import cn.com.hq.util.StringUtil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CXJL {

	private CXJLResult result;
	private String reason;
	private String error_code;
	private static Logger logger = Logger.getLogger(CXJL.class);
	
	public CXJLResult getResult() {
		return result;
	}
	public void setResult(CXJLResult result) {
		this.result = result;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public String getError_code() {
		return error_code;
	}
	public void setError_code(String error_code) {
		this.error_code = error_code;
	}
	
	public static void translate(CXJL c) {
		String claimMoney = c.getResult().getSummaryData().getClaimMoney();
		if(!StringUtil.isEmpty(claimMoney)){
			claimMoney = Double.valueOf(claimMoney)/100 + "";
		}
		c.getResult().getSummaryData().setClaimMoney(claimMoney);
		
		String renewMoney = c.getResult().getSummaryData().getRenewMoney();
		if(!StringUtil.isEmpty(renewMoney)){
			renewMoney = Double.valueOf(renewMoney)/100 + "";
		}
		c.getResult().getSummaryData().setRenewMoney(renewMoney);
		
		String repairMoney = c.getResult().getSummaryData().getRepairMoney();
		if(!StringUtil.isEmpty(repairMoney)){
			repairMoney = Double.valueOf(repairMoney)/100 + "";
		}
		c.getResult().getSummaryData().setRepairMoney(repairMoney);
		
		
		for(CXJLcarClaimRecord r : c.getResult().getCarClaimRecords()){
			String otherAmount = r.getOtherAmount();
			if(!StringUtil.isEmpty(otherAmount)){
				otherAmount = Double.valueOf(otherAmount)/100 + "";
			}
			r.setOtherAmount(otherAmount);
			
			String repairAmount = r.getRepairAmount();
			if(!StringUtil.isEmpty(repairAmount)){
				repairAmount = Double.valueOf(repairAmount)/100 + "";
			}
			r.setRepairAmount(repairAmount);
			
			String renewalAmount = r.getRenewalAmount();
			if(!StringUtil.isEmpty(renewalAmount)){
				renewalAmount = Double.valueOf(renewalAmount)/100 + "";
			}
			r.setRenewalAmount(renewalAmount);
			
			String damageMoney = r.getDamageMoney();
			if(!StringUtil.isEmpty(damageMoney)){
				damageMoney = Double.valueOf(damageMoney)/100 + "";
			}
			r.setDamageMoney(damageMoney);
			
			for(CXJLclaimDetail d : r.getClaimDetails()){
				String itemAmount = d.getItemAmount();
				if(!StringUtil.isEmpty(itemAmount)){
					itemAmount = Double.valueOf(itemAmount)/100 + "";
				}
				d.setItemAmount(itemAmount);
			}
		}

	}
	
	
	public static String queryResult(HttpServletRequest request,String orderId){
		 	Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").enableComplexMapKeySerialization().disableHtmlEscaping().create();
		 	String queryResult = "";

			//1、先把查询结果缓存到订单记录表里，等待用户付款成功后在返回给用户展示
			String licenseNo = request.getParameter("licenseNo");
			String frameNo = request.getParameter("frameNo");
			String cxjlurl = QueryAppKeyLib.chuxianjiluQueryUrl+"key="+QueryAppKeyLib.chuxianjiluQueryAppKey;
			if (!StringUtil.isEmpty(licenseNo)) {
		      cxjlurl = cxjlurl + "&licenseNo=" + licenseNo.replaceAll("\\s", "");
		    }
		    if (!StringUtil.isEmpty(frameNo)) {
		      cxjlurl = cxjlurl + "&frameNo=" + frameNo.replaceAll("\\s", "");
		    }
			HttpGet cxjhttpGet = new HttpGet(cxjlurl);
			try {
				HttpClient cxjhttpClient = SSLUtil.getHttpClient();
		        HttpResponse cxjles = cxjhttpClient.execute(cxjhttpGet);
		        HttpEntity cxjentity = cxjles.getEntity();
		        String cxjlesult = EntityUtils.toString(cxjentity, "UTF-8");
		        queryResult = cxjlesult;
		        System.out.println("CXJL:\r\n" + queryResult);
		        logger.info("CXJL:\r\n" + queryResult);
		        CXJL cxjl = gson.fromJson(queryResult, CXJL.class);
		        if(!"0".equals(cxjl.error_code)){
		        	return "{\"errorMessage\":\""+cxjl.reason+"\",\"success\":false}";
		        }
		       
		        try {
		        	 translate(cxjl);
				     queryResult = gson.toJson(cxjl);
				} catch (Exception e) {
					e.printStackTrace();
					logger.error(StringUtil.errInfo(e));
					logger.error("cxjl数据转换失败");
				}
				//queryResult = Data.CXJL.replaceAll("\\s+", " ");
		        //queryResult = "{\"reason\":\"1:没有查到理赔记录\",\"result\":null,\"error_code\":228201}";
System.out.println("QueryResult : "+queryResult);
			} catch (Exception e) {
				logger.error(StringUtil.errInfo(e));
				logger.error("车辆查询失败");
				e.printStackTrace();
				return "{\"errorMessage\":\"查询错误,请确认输入数据是否正确\",\"success\":false}";
			}
		return queryResult;
	 }
}
