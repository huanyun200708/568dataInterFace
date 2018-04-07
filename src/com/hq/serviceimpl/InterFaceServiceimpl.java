package com.hq.serviceimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.hq.dao.Dao;
import cn.com.hq.util.RandomStringGenerator;

import com.hq.model.Order;
import com.hq.service.InterFaceService;

public class InterFaceServiceimpl implements InterFaceService {
	private Dao dao = new Dao();
	@Override
    public String getTheRestOfQuery(String userKey) {
		String sql = "select count(1) from 568db.external_interface_order where user_key=? and is_order_used<>'1'";
		Connection connection =  dao.getDBConnection();
		String count = "0";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, userKey);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				count = rs.getString(1);
			}
			dao.closeResultSet(rs);
			dao.closeStatement(ps);
			Dao.releaseConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
    public Order getOneOrder(String userKey) {
		String sql = "select interface_type,user_order_id,order_createtime from 568db.external_interface_order where user_key=? and is_order_used<>'1'";
		Connection connection =  dao.getDBConnection();
		Order order = new Order();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, userKey);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				order.setInterface_type(rs.getString(1));
				order.setUser_key(userKey);
				order.setUser_order_id(rs.getString(2));
				order.setIs_order_used("0");
				order.setOrder_createtime(rs.getString(3));
				break;
			}
			dao.closeResultSet(rs);
			dao.closeStatement(ps);
			Dao.releaseConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}

	@Override
    public boolean updateOrderBaseInfo(Order order) {
		boolean result = false;
		String sql = "update 568db.external_interface_order set interface_type=?,user_key=?,is_order_used=?,order_createtime=?,order_usetime=? where user_order_id=?";
		Connection connection =  dao.getDBConnection();
		PreparedStatement  ps;
		try {
			DateFormat format2 = new SimpleDateFormat("yyyy/MM/dd/ HH:mm:ss:S");
			ps = connection.prepareStatement(sql);
			System.out.println("【"+format2.format(new Date())+"】开始执行更新新订单"+order.getUser_order_id()+".....");
			ps.setString(1, order.getInterface_type());
			ps.setString(2, order.getUser_key());
			ps.setString(3, order.getIs_order_used());
			ps.setString(4, order.getOrder_createtime());
			ps.setString(5,order.getOrder_usetime());
			ps.setString(6, order.getUser_order_id());
			result = ps.executeUpdate() > 0;
			System.out.println("【"+format2.format(new Date())+"】结束执行更新新订单"+order.getUser_order_id()+".....");
			dao.closeStatement(ps);
			Dao.releaseConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
    public boolean insertOrderBaseInfo(String userKey,String count,String interface_type) {
		boolean result = false;
		String sql = "INSERT INTO 568db.external_interface_order (interface_type,user_key,user_order_id,is_order_used,order_createtime,order_usetime) VALUES (?,?,?,?,?,?)";
		Connection connection =  dao.getDBConnection();
		PreparedStatement  ps;
		try {
			Date date = new Date();
			DateFormat format2 = new SimpleDateFormat("yyyy/MM/dd/ HH:mm:ss:S");
			int countInt = Integer.valueOf(count);
			ps = connection.prepareStatement(sql);
			System.out.println("【"+format2.format(new Date())+"】开始执行"+count+"次插入新订单.....");
			for(int i=1;i<=countInt;i++){
				ps.setString(1, interface_type);
				ps.setString(2, userKey);
				ps.setString(3, RandomStringGenerator.getRandomStringByLength(32));
				ps.setString(4, "0");
				ps.setString(5,format2.format(date));
				ps.setString(6, "");
				result = ps.executeUpdate() > 0;
			}
			System.out.println("【"+format2.format(new Date())+"】结束执行"+count+"次插入新订单.....");
			dao.closeStatement(ps);
			Dao.releaseConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
    public boolean updateOrderContentInfo(Order order) {
		boolean result = false;
		String sql = "select orderid,content from 568db.external_interface_order_content where orderid=?";
		Connection connection =  dao.getDBConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, order.getUser_order_id());
			ResultSet rs = ps.executeQuery();
			boolean isHave = false;
			while(rs.next()){
				isHave = true;
				break;
			}
			dao.closeResultSet(rs);
			dao.closeStatement(ps);
			if(isHave){
				sql = "update 568db.external_interface_order_content set content=?  where orderid=?";
				ps = connection.prepareStatement(sql);
				ps.setString(1, order.getContent());
				ps.setString(2, order.getUser_order_id());
				result = ps.executeUpdate() > 0;
			}else{
				sql = "INSERT INTO 568db.external_interface_order_content (orderid,content) VALUES (?,?)";
				ps = connection.prepareStatement(sql);
				ps.setString(2, order.getContent());
				ps.setString(1, order.getUser_order_id());
				result = ps.executeUpdate() > 0;
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
    public boolean addInterFaceUse(String name, String phone, String userKey) {
		boolean result = false;
		String sql = "INSERT INTO 568db.user (name,phone,user_key,create_time) VALUES (?,?,?,?)";
		Connection connection =  dao.getDBConnection();
		PreparedStatement  ps;
		try {
			Date date = new Date();
			DateFormat format2 = new SimpleDateFormat("yyyy/MM/dd/ HH:mm:ss:S");
			ps = connection.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, phone);
			ps.setString(3, userKey);
			ps.setString(4, format2.format(date));
			result = ps.executeUpdate() > 0;
			dao.closeStatement(ps);
			Dao.releaseConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	@Override
    public boolean updateInterFaceUse(String id,String name, String phone) {
		boolean result = false;
		String sql = "update 568db.user set name=?,phone=? where id=?";
		Connection connection =  dao.getDBConnection();
		PreparedStatement  ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, phone);
			ps.setString(3, id);
			result = ps.executeUpdate() > 0;
			dao.closeStatement(ps);
			Dao.releaseConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	@Override
    public List<Map<String,String>> getInterFaceUseList() {
		List<Map<String,String>> result = new ArrayList<Map<String,String>>(10);
		String sql = "SELECT  u.id, u.name, u.phone, u.user_key, COUNT(1) restcount"+
					"	FROM 568db.user u,568db.external_interface_order o "+
					"	WHERE u.user_key = o.user_key"+
					/*"	AND o.`is_order_used`<>'1' "+*/
					"	GROUP BY u.id, u.name, u.phone, u.user_key, u.create_time ";
		Connection connection =  dao.getDBConnection();
		PreparedStatement  ps;
		try {
			ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				HashMap<String,String> m = new HashMap<String,String>();
				m.put("id", rs.getString(1));
				m.put("name", rs.getString(2));
				m.put("phone", rs.getString(3));
				m.put("user_key", rs.getString(4));
				m.put("restcount", rs.getString(5));
				result.add(m);
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
    public Map<String, String> getInterFaceUseById(String id) {
		List<Map<String,String>> result = new ArrayList<Map<String,String>>(10);
		String sql = "SELECT  u.id, u.name, u.phone, u.user_key, COUNT(1) restcount"+
					"	FROM 568db.user u,568db.external_interface_order o "+
					"	WHERE u.user_key = o.user_key"+
					"	AND u.id=? "+
					/*"	AND o.`is_order_used`<>'1' "+*/
					"	GROUP BY u.id, u.name, u.phone, u.user_key, u.create_time ";
		Connection connection =  dao.getDBConnection();
		PreparedStatement  ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				HashMap<String,String> m = new HashMap<String,String>();
				m.put("id", rs.getString(1));
				m.put("name", rs.getString(2));
				m.put("phone", rs.getString(3));
				m.put("user_key", rs.getString(4));
				m.put("restcount", rs.getString(5));
				return m;
			}
			dao.closeResultSet(rs);
			dao.closeStatement(ps);
			Dao.releaseConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}

