package com.hq.serviceimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.com.hq.dao.Dao;

import com.alibaba.fastjson.JSONObject;
import com.hq.service.UserService;
import com.huawei.inoc.most.cbb.encrypt.ShaEncrypt;

public class UserServiceImpl implements UserService {
	private Dao dao = new Dao();
	@Override
    public List<JSONObject> getAllUser() {//
		ArrayList<JSONObject> result = new ArrayList<JSONObject>();
		Connection connection = dao.getDBConnection();
		String sql = "SELECT id, name FROM admin s ";
		try {
			PreparedStatement ps;
			ResultSet rs;
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			while (rs.next()) {
				JSONObject json = new JSONObject();
				json.put("id", rs.getString(1));// 日期
				json.put("name", rs.getString(2));// 漫入

				result.add(json);
			}
			dao.closeResultSet(rs);
			dao.closeStatement(ps);
			Dao.releaseConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
    public JSONObject getUserById(String id) {
	    return null;
    }

	@Override
    public boolean updatePassWordById(String password, String id) {
		Connection connection = dao.getDBConnection();
		String sql = "UPDATE  `admin` SET `password` = ?  WHERE `id` = ? ";
		try {
			PreparedStatement ps;
			ps = connection.prepareStatement(sql);
			String encryption =  ShaEncrypt.encrypt(password,"WL0nookvZt14sPTg");
			ps.setString(1, encryption);
			ps.setString(2, id);
			int r = ps.executeUpdate();
			if(r > 0){
				return true;
			}
			dao.closeStatement(ps);
			Dao.releaseConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    return false;
    }

	@Override
    public boolean deleteUserByIds(List<String> idList) {
		Connection connection = dao.getDBConnection();
		for(String id : idList){
			String sql = "DELETE FROM  `admin` WHERE `id` = ? ";
			try {
				PreparedStatement ps;
				ps = connection.prepareStatement(sql);
				ps.setString(1, id);
				ps.executeUpdate();
				dao.closeStatement(ps);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		Dao.releaseConnection(connection);
		return true;
    }

	@Override
    public boolean validatePassWordById(String password, String id) {
		Connection connection = dao.getDBConnection();
		String sql = "SELECT id, name, password FROM admin s where id=?";
		try {
			PreparedStatement ps;
			ResultSet rs;
			ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				String pword = rs.getString(3);
				String encryption =  ShaEncrypt.encrypt(password,"WL0nookvZt14sPTg");
				if(encryption.equals(pword)){
					return true;
				}
			}
			dao.closeResultSet(rs);
			dao.closeStatement(ps);
			Dao.releaseConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    return false;
    }

	@Override
    public boolean validateuserExist(String name) {
		Connection connection = dao.getDBConnection();
		String sql = "SELECT id, name, password FROM admin s where name=?";
		try {
			PreparedStatement ps;
			ResultSet rs;
			ps = connection.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while (rs.next()) {
				return true;
			}
			dao.closeResultSet(rs);
			dao.closeStatement(ps);
			Dao.releaseConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    return false;
    }

	@Override
    public boolean addUser(String name, String password) {
		Connection connection = dao.getDBConnection();
		String sql = "INSERT INTO `admin` (`name`, `password`)  VALUES   (?, ?)";
		try {
			PreparedStatement ps;
			ps = connection.prepareStatement(sql);
			String encryption =  ShaEncrypt.encrypt(password,"WL0nookvZt14sPTg");
			ps.setString(1, name);
			ps.setString(2, encryption);
			int r = ps.executeUpdate();
			if(r > 0){
				return true;
			}
			dao.closeStatement(ps);
			Dao.releaseConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    return false;
    }

}
