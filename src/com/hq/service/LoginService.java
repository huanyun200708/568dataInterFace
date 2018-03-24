package com.hq.service;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;

public interface LoginService {
	
	public JSONObject getLoginData(HttpServletRequest reguest,String username,String password) ;
	public JSONObject destoryLoginData(HttpServletRequest reguest,String username) ;
}
