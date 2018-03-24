package com.hq.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cn.com.hq.util.JsonUtils;
import cn.com.hq.util.StringUtil;

import com.alibaba.fastjson.JSONObject;
import com.hq.service.UserService;
import com.hq.serviceimpl.UserServiceImpl;

public class UserAction extends BaseAction {
	UserService userService = new UserServiceImpl();
	private static final long serialVersionUID = 1L;

	public void getAllUser(){
		List<JSONObject> jsons = userService.getAllUser();
		if(jsons.size() > 0){ 
			responseWriter("{\"success\":true,\"code\":0,\"msg\":\"\",\"count\":"+jsons.size()+",\"data\":"+JsonUtils.toJson(jsons)+"}");
		}else{
			responseWriter("{\"success\":false,\"message\":\"result is null\"}");
		}
	}
	
	public void getUserById(){
		HttpServletRequest reguest= super.getRequest();
		String id = reguest.getParameter("id");
		JSONObject jsons = userService.getUserById(id);
		if(jsons.size() > 0){ 
			responseWriter("{\"success\":true,\"code\":0,\"msg\":\"\",\"count\":"+jsons.size()+",\"data\":"+JsonUtils.toJson(jsons)+"}");
		}else{
			responseWriter("{\"success\":false,\"message\":\"result is null\"}");
		}
	}
	
	public void updatePassWordById(){
		HttpServletRequest reguest= super.getRequest();
		String password = reguest.getParameter("password");
		String repassword = reguest.getParameter("repassword");
		String id = reguest.getParameter("id");
		String oldpassword = reguest.getParameter("oldpassword");
		if(StringUtil.isEmpty(repassword) || StringUtil.isEmpty(repassword) || !repassword.equals(password)){
			responseWriter("{\"success\":false,\"message\":\"两次输入密码不一致！！！\"}");
			return;
		}
		boolean passpordRight = userService.validatePassWordById(oldpassword,id);
		
		if(!passpordRight){
			responseWriter("{\"success\":false,\"message\":\"用户不存在，或者旧密码输入错误！！！\"}");
			return;
		}
		boolean result = userService.updatePassWordById(password,id);
		if(result){ 
			responseWriter("{\"success\":true,\"code\":0,\"msg\":\"密码修改成功！\"}");
		}else{
			responseWriter("{\"success\":false,\"message\":\"密码修改失败！\"}");
		}
	}
	
	public void addUser(){
		HttpServletRequest reguest= super.getRequest();
		String password = reguest.getParameter("password");
		String name = reguest.getParameter("name");
		String repassword = reguest.getParameter("repassword");
		
		if(StringUtil.isEmpty(repassword) || StringUtil.isEmpty(repassword) || !repassword.equals(password)){
			responseWriter("{\"success\":false,\"message\":\"两次输入密码不一致！！！\"}");
			return;
		}
		boolean isUserExist = userService.validateuserExist(name);
		
		if(isUserExist){
			responseWriter("{\"success\":false,\"message\":\"用户已存在！！！\"}");
			return;
		}
		boolean result = userService.addUser(name,password);
		if(result){ 
			responseWriter("{\"success\":true,\"code\":0,\"msg\":\"新增用户成功！\"}");
		}else{
			responseWriter("{\"success\":false,\"message\":\"新增用户失败！\"}");
		}
	}
	
	public void deleteUserByIds(){
		HttpServletRequest reguest= super.getRequest();
		String ids = reguest.getParameter("ids");
		if(ids != null && !"".equals(ids)){
			List<String> idList = new ArrayList<String>();
			for(String s : ids.split(",")){
				idList.add(s);
			}
			
			boolean result = userService.deleteUserByIds(idList);
			if(result){ 
				responseWriter("{\"success\":true,\"code\":0,\"msg\":\"\"}");
			}else{
				responseWriter("{\"success\":false,\"message\":\"result is null\"}");
			}
		}
		
		
	}

}
