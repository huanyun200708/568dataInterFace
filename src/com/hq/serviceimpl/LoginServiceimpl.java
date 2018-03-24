package com.hq.serviceimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import cn.com.hq.dao.Dao;

import com.alibaba.fastjson.JSONObject;
import com.hq.service.LoginService;
import com.huawei.inoc.most.cbb.encrypt.ShaEncrypt;

@SuppressWarnings("serial")
public class LoginServiceimpl implements LoginService {
	private Dao dao = new Dao();
	@Override
	public JSONObject getLoginData(HttpServletRequest reguest,String username,String password) {
		// TODO Auto-generated method stub
	//创建session对象
	JSONObject json = new JSONObject();
	Connection connection = dao.getDBConnection();
	String sql = "SELECT password from admin u  where  u.name = ?";
	try {
		PreparedStatement ps;
		ResultSet rs;
		ps = connection.prepareStatement(sql);
		ps.setString(1, username);
		rs = ps.executeQuery();
		String encryption =  ShaEncrypt.encrypt(password,"WL0nookvZt14sPTg");
		if(rs.next()&& rs.getString(1).equals(encryption)){
			reguest.getSession().setAttribute("user", username);
			json.put("result", true);
		}else{
			json.put("result", false);
		}
		dao.closeResultSet(rs);
		dao.closeStatement(ps);
		Dao.releaseConnection(connection);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return json;
   }

	@Override
	public JSONObject destoryLoginData(HttpServletRequest reguest,String username) {
		reguest.getSession().setAttribute("user", "");
		JSONObject json = new JSONObject();
		json.put("result", null);
		return json;
	}
}

