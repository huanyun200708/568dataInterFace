package com.weixinpay.common;

public class Configure {
	//你的商户的api秘钥
	private static String key = "568ershouchedashujupingtaiguanli";
	//小程序ID	
	private static String appID = "wxac13806633046a10";
	//商户号
	private static String mch_id = "1487094742";
	//你的小程序的secret
	private static String secret = "4d1e1df4452e0668648eccaeb3c59b83";

	public static String getSecret() {
		return secret;
	}

	public static void setSecret(String secret) {
		Configure.secret = secret;
	}

	public static String getKey() {
		return key;
	}

	public static void setKey(String key) {
		Configure.key = key;
	}

	public static String getAppID() {
		return appID;
	}

	public static void setAppID(String appID) {
		Configure.appID = appID;
	}

	public static String getMch_id() {
		return mch_id;
	}

	public static void setMch_id(String mch_id) {
		Configure.mch_id = mch_id;
	}

}
