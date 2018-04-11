package com.hq.model;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cn.com.hq.util.PropertiesUtils;
import cn.com.hq.util.QueryAppKeyLib;
import cn.com.hq.util.SSLUtil;
import cn.com.hq.util.StringUtil;

public class CLZT {

	private CLZTResult result;
	private String reason;
	private String error_code;
	private static Logger logger = Logger.getLogger(CLZT.class);

	public CLZTResult getResult() {
		return result;
	}

	public void setResult(CLZTResult result) {
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

	public CLZD getCheLiangZiDian() {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").enableComplexMapKeySerialization().disableHtmlEscaping().create();
		String clzdurl = QueryAppKeyLib.cheliangZiDianUrl + "key=" + QueryAppKeyLib.cheliangzhuangtaiQueryAppKey;
		HttpGet clzdhttpGet = new HttpGet(clzdurl);
		// 设置请求器的配置
		try {
			HttpClient clzdhttpClient = SSLUtil.getHttpClient();
			HttpResponse clzdres = clzdhttpClient.execute(clzdhttpGet);
			HttpEntity clzdentity = clzdres.getEntity();
			String clzdresult = EntityUtils.toString(clzdentity, "UTF-8");
			System.out.println("CLZT:\r\n" + clzdresult);
			logger.info("CLZT:\r\n" + clzdresult);
			clzdresult = clzdresult.replace("附录1", "fulu1").replace("附录2", "fulu2").replace("附录3", "fulu3").replace("附录4", "fulu4").replace("附录5", "fulu5").replace("附录6", "fulu6");
			CLZD c = gson.fromJson(clzdresult, CLZD.class);
			return c;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(StringUtil.errInfo(e));
			logger.error("车辆字典查询失败");
			return null;
		}
	}

	public void translate(CLZT c) {
		CLZD clzd = this.getCheLiangZiDian();
		if (clzd != null) {
			String state0 = c.getResult().getState();// fulu5
			String state = "";
			for (char ch : state0.toCharArray()) {
				state = state + StringUtil.getValueFromMap(ch + "", clzd.getFulu5()) + " ";
			}
			c.getResult().setState(state);

			String properties0 = c.getResult().getProperties();// fulu4
			String properties = "";
			for (char ch : properties0.toCharArray()) {
				properties = properties + StringUtil.getValueFromMap(ch + "", clzd.getFulu4()) + " ";
			}
			c.getResult().setProperties(properties);

			String color0 = c.getResult().getColor();// fulu3
			String color = "";
			for (char ch : color0.toCharArray()) {
				color = color + StringUtil.getValueFromMap(ch + "", clzd.getFulu3());
			}
			c.getResult().setColor(color);

			String fuel0 = c.getResult().getFuel();// fulu6
			String fuel = "";
			for (char ch : fuel0.toCharArray()) {
				fuel = fuel + StringUtil.getValueFromMap(ch + "", clzd.getFulu6());
			}
			c.getResult().setFuel(fuel);

			String vehicleType = c.getResult().getVehicleType();// fulu2
			c.getResult().setVehicleType(StringUtil.getValueFromMap(vehicleType + "", clzd.getFulu2()));

			String variety = c.getResult().getVariety();// fulu1
			c.getResult().setVariety(StringUtil.getValueFromMap(variety + "", clzd.getFulu1()));
			return;
		}
		c.getResult().setState(c.getResult().getState());
		c.getResult().setProperties(c.getResult().getProperties());
		c.getResult().setColor(c.getResult().getColor());
		c.getResult().setFuel(c.getResult().getFuel());
		c.getResult().setVehicleType(c.getResult().getVehicleType());

	}

	public static String queryResult(HttpServletRequest request, String orderId) {
		String isStopcheliangzhuangtaiQuery = PropertiesUtils.getPropertyValueByKey("isStopcheliangzhuangtaiQuery");
		if ("1".equals(isStopcheliangzhuangtaiQuery)) {
			return "{\"errorMessage\":\"系统维护...\",\"success\":false}";
		}
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").enableComplexMapKeySerialization().disableHtmlEscaping().create();
		String queryResult = "";
		String number = request.getParameter("number").replaceAll("\\s", "");
		if (number.length() < 1) {
			return "{\"errorMessage\":\"车牌为空\",\"success\":false}";
		}
		String cltype = request.getParameter("type");

		String clzturl = QueryAppKeyLib.cheliangzhuangtaiQueryUrl + "key=" + QueryAppKeyLib.cheliangzhuangtaiQueryAppKey + "&number=" + number;
		String isUseSimpleCheLiangZhuangTaiQuery = PropertiesUtils.getPropertyValueByKey("isUseSimpleCheLiangZhuangTaiQuery");
		if ("1".equals(isUseSimpleCheLiangZhuangTaiQuery)) {
			clzturl = QueryAppKeyLib.cheliangzhuangtaiQuerySimpleUrl + "key=" + QueryAppKeyLib.cheliangzhuangtaiQueryAppKey + "&number=" + number;
		}
		if (!StringUtil.isEmpty(cltype)) {
			clzturl = clzturl + "&type=" + cltype.replaceAll("\\s", "");
		}
		HttpGet clzthttpGet = new HttpGet(clzturl);
		// 设置请求器的配置
		try {
			HttpClient clzthttpClient = SSLUtil.getHttpClient();
			HttpResponse clztres = clzthttpClient.execute(clzthttpGet);
			HttpEntity clztentity = clztres.getEntity();
			String clztresult = EntityUtils.toString(clztentity, "UTF-8");
			System.out.println(clztresult);
			logger.info(clztresult);
			queryResult = clztresult;
			/* queryResult = Data.CLZT.replaceAll("\\s+", " "); */
			CLZT c = gson.fromJson(queryResult, CLZT.class);

			// 以下错误码不收费
			if ("227100".equals(c.error_code) || "227101".equals(c.error_code) || "227102".equals(c.error_code)) {
				return "{\"errorMessage\":\"" + c.reason + "\",\"error_code\":\"" + c.error_code + "\",\"success\":false}";
			}
			if (!"0".equals(c.error_code)) {
				return "{\"errorMessage\":\"" + c.reason + "\",\"error_code\":\"" + c.error_code + "\",\"submitOrder\":1,\"success\":false}";
			}
			try {
				c.translate(c);
				c.getResult().setIsQuerySimple(isUseSimpleCheLiangZhuangTaiQuery);
				queryResult = gson.toJson(c);
			} catch (Exception e) {
				logger.error(StringUtil.errInfo(e));
				logger.error("车辆状态转换失败");
			}

			System.out.println("QueryResult : " + queryResult);
			logger.info("QueryResult : " + queryResult);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(StringUtil.errInfo(e));
			logger.error("车辆查询失败");
			return "{\"errorMessage\":\"查询错误,请确认输入数据是否正确\",\"success\":false}";
		}

		return queryResult;
	}

	public static void main(String[] args) {
	}
}
