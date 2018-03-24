package com.hq.service;

import java.util.List;
import java.util.Map;

import com.hq.model.Order;

public interface InterFaceService {
	public String getTheRestOfQuery(String userKey);

	public Order getOneOrder(String userKey);

	public boolean updateOrderBaseInfo(Order order);

	public boolean updateOrderContentInfo(Order order);

	public boolean insertOrderBaseInfo(String userKey, String count, String interface_type);

	public boolean addInterFaceUse(String name, String phone, String userKey);

	boolean updateInterFaceUse(String id, String name, String phone);

	List<Map<String, String>> getInterFaceUseList();

	public Map<String, String> getInterFaceUseById(String id);
}
