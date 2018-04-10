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

public class TBXX {

	private TBXXResult result;
	private String reason;
	private String error_code;
	private static Logger logger = Logger.getLogger(TBXX.class);
	public TBXXResult getResult() {
		return result;
	}
	public void setResult(TBXXResult result) {
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
	public void translate(TBXX t){
		t.getResult().getSaveQuote().setSource(t.getResult().getSaveQuote().getSource());
		t.getResult().getSaveQuote().setHcXiuLiChangType(t.getResult().getSaveQuote().getHcXiuLiChangType());
		t.getResult().getSaveQuote().setBoLi(t.getResult().getSaveQuote().getBoLi());
		/*
		t.getResult().getSaveQuote().setCheSun(t.getResult().getSaveQuote().getCheSun());
		t.getResult().getSaveQuote().setSanZhe(t.getResult().getSaveQuote().getSanZhe());
		t.getResult().getSaveQuote().setDaoQiang(t.getResult().getSaveQuote().getDaoQiang());
		t.getResult().getSaveQuote().setSiJi(t.getResult().getSaveQuote().getSiJi());
		t.getResult().getSaveQuote().setChengKe (t.getResult().getSaveQuote().getChengKe ());
		t.getResult().getSaveQuote().setHuaHen(t.getResult().getSaveQuote().getHuaHen());
		t.getResult().getSaveQuote().setBuJiMianCheSun(t.getResult().getSaveQuote().getBuJiMianCheSun());
		t.getResult().getSaveQuote().setBuJiMianSanZhe(t.getResult().getSaveQuote().getBuJiMianSanZhe());
		t.getResult().getSaveQuote().setBuJiMianDaoQiang(t.getResult().getSaveQuote().getBuJiMianDaoQiang());
		t.getResult().getSaveQuote().setSheShui (t.getResult().getSaveQuote().getSheShui ());
		t.getResult().getSaveQuote().setZiRan (t.getResult().getSaveQuote().getZiRan ());
		t.getResult().getSaveQuote().setBuJiMianChengKe (t.getResult().getSaveQuote().getBuJiMianChengKe ());
		t.getResult().getSaveQuote().setBuJiMianSiJi(t.getResult().getSaveQuote().getBuJiMianSiJi());
		t.getResult().getSaveQuote().setBuJiMianHuaHen(t.getResult().getSaveQuote().getBuJiMianHuaHen());
		t.getResult().getSaveQuote().setBuJiMianSheShui (t.getResult().getSaveQuote().getBuJiMianSheShui ());
		t.getResult().getSaveQuote().setBuJiMianZiRan (t.getResult().getSaveQuote().getBuJiMianZiRan ());
		t.getResult().getSaveQuote().setBuJiMianJingShenSunShi(t.getResult().getSaveQuote().getBuJiMianJingShenSunShi());
		t.getResult().getSaveQuote().setHcSanFangTeYue(t.getResult().getSaveQuote().getHcSanFangTeYue());
		t.getResult().getSaveQuote().setHcJingShenSunShi(t.getResult().getSaveQuote().getHcJingShenSunShi());
		t.getResult().getSaveQuote().setBjmSheBeiSunShi (t.getResult().getSaveQuote().getBjmSheBeiSunShi ());
		*/
		
		t.getResult().getUserInfo().setCarUsedType(t.getResult().getUserInfo().getCarUsedType());
		t.getResult().getUserInfo().setIdType(t.getResult().getUserInfo().getIdType());
		t.getResult().getUserInfo().setCityCode(t.getResult().getUserInfo().getCityCode());
		t.getResult().getUserInfo().setFuelType(t.getResult().getUserInfo().getFuelType());
		t.getResult().getUserInfo().setProofType(t.getResult().getUserInfo().getProofType());
		t.getResult().getUserInfo().setLicenseColor(t.getResult().getUserInfo().getLicenseColor());
		t.getResult().getUserInfo().setClauseType(t.getResult().getUserInfo().getClauseType());
		t.getResult().getUserInfo().setRunRegion(t.getResult().getUserInfo().getRunRegion());
		/*t.getResult().getUserInfo().setInsuredIdType(t.getResult().getUserInfo().getInsuredIdType());
		t.getResult().getUserInfo().setHolderIdType(t.getResult().getUserInfo().getHolderIdType());*/
		t.getResult().getUserInfo().setIsPublic(t.getResult().getUserInfo().getIsPublic());
		
		//隐藏敏感信息
	/*	String SupermanOpenId = PropertiesUtils.getPropertyValueByKey("SupermanOpenId");
		if(!StringUtil.isEmpty(SupermanOpenId)){
			String [] sman = SupermanOpenId.split(",");
			for(String s : sman){
				if(openId.equals(s)){
					t.getResult().getUserInfo().setHideInfo(false);
					break;
				}
			}
		}*/
		
		t.getResult().getUserInfo().setHideInfo(false);
		
		t.getResult().getUserInfo().setLicenseOwner(t.getResult().getUserInfo().getLicenseOwner());
		/*t.getResult().getUserInfo().setInsuredName(t.getResult().getUserInfo().getInsuredName());
		t.getResult().getUserInfo().setPostedName(t.getResult().getUserInfo().getPostedName());
		t.getResult().getUserInfo().setCredentislasNum(t.getResult().getUserInfo().getCredentislasNum());
		t.getResult().getUserInfo().setInsuredIdCard(t.getResult().getUserInfo().getInsuredIdCard());
		t.getResult().getUserInfo().setInsuredMobile(t.getResult().getUserInfo().getInsuredMobile());
		t.getResult().getUserInfo().setHolderIdCard(t.getResult().getUserInfo().getHolderIdCard());
		t.getResult().getUserInfo().setHolderMobile(t.getResult().getUserInfo().getHolderMobile());*/
		
	}
	
	
	public static String queryResult(HttpServletRequest request,String orderId){
		 Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").enableComplexMapKeySerialization().disableHtmlEscaping().create();
		 	String queryResult = "";
		String licenseNo = request.getParameter("licenseNo");
		String carVin = request.getParameter("carVin");
		String engineNo = request.getParameter("engineNo");
		String renewalCarType = request.getParameter("renewalCarType");
		String tbxxurl = QueryAppKeyLib.toubaoxinxiQueryUrl+"key="+QueryAppKeyLib.toubaoxinxiQueryAppKey;
		
		 if (!StringUtil.isEmpty(licenseNo)) {
	      tbxxurl = tbxxurl + "&licenseNo=" + licenseNo.replaceAll("\\s", "");
	    }
	    if (!StringUtil.isEmpty(carVin)) {
	      tbxxurl = tbxxurl + "&carVin=" + carVin.replaceAll("\\s", "");
	    }
	    if (!StringUtil.isEmpty(engineNo)) {
	      tbxxurl = tbxxurl + "&engineNo=" + engineNo.replaceAll("\\s", "");
	    }
	    if (!StringUtil.isEmpty(renewalCarType)) {
	      tbxxurl = tbxxurl + "&renewalCarType=" + renewalCarType.replaceAll("\\s", "");
	    }
		HttpGet tbxxhttpGet = new HttpGet(tbxxurl);
        //设置请求器的配置
		try {
		HttpClient tbxxhttpClient = SSLUtil.getHttpClient();
	        HttpResponse tbxxres = tbxxhttpClient.execute(tbxxhttpGet);
	        HttpEntity tbxxentity = tbxxres.getEntity();
	        String tbxxresult = EntityUtils.toString(tbxxentity, "UTF-8");
	        System.out.println(tbxxresult);
	        queryResult = tbxxresult;
	        System.out.println("TBXX:\r\n" + queryResult);
	        logger.info("TBXX:\r\n" + queryResult);
	        try {
	        	TBXX tbxx = gson.fromJson(queryResult, TBXX.class);
	        	if(!"0".equals(tbxx.error_code)){
		        	return "{\"errorMessage\":\""+tbxx.reason+"\",\"success\":false}";
		        }
		        tbxx.translate(tbxx);
		        queryResult = gson.toJson(tbxx);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(StringUtil.errInfo(e));
				logger.error("tbxx数据转换失败");
			}
	        
System.out.println("QueryResult : "+queryResult);
		} catch (Exception e) {
			logger.error(StringUtil.errInfo(e));
			logger.error("投保信息查询失败");
			return "{\"errorMessage\":\"查询错误,请确认输入数据是否正确\",\"success\":false}";
		}
		
		return queryResult;
	}
	
}
