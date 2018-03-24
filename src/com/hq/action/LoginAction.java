package com.hq.action;
import javax.servlet.http.HttpServletRequest;

import cn.com.hq.util.JsonUtils;

import com.alibaba.fastjson.JSONObject;
import com.hq.service.LoginService;
import com.hq.serviceimpl.LoginServiceimpl;

public class LoginAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private LoginService LoginService1 = new LoginServiceimpl();

	public void getuserdata() {// 九号区域
		HttpServletRequest reguest= super.getRequest();
		String username = reguest.getParameter("username");
		String password = reguest.getParameter("password");
		JSONObject json= LoginService1.getLoginData(reguest,username,password);
				
		if(json != null){
			responseWriter(JsonUtils.toJson(json));
		}else{
			responseWriter("{\"success\":false,\"message\":\"result is null\"}");
		}
	}
	public void Destorydata(){
		HttpServletRequest reguest = super.getRequest();
		String username = reguest.getParameter("username");
		JSONObject json= LoginService1.destoryLoginData(reguest,username);
		if(json != null){
			responseWriter(JsonUtils.toJson(json));
		}else{
			responseWriter("{\"success\":false,\"message\":\"result is null\"}");
		}
	}
}
