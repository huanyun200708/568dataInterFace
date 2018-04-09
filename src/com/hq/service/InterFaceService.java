package com.hq.service;

import java.util.List;
import java.util.Map;

import com.hq.model.Order;

public interface InterFaceService {


	public boolean updateOrderBaseInfo(Order order);

	public boolean updateOrderContentInfo(Order order);

	public boolean insertOrderBaseInfo(String userKey, String count, String interface_type);

	public boolean addInterFaceUse(String name, String phone, String userKey, String interfaceType);

	boolean updateInterFaceUse(String id, String name, String phone, String interfaceType);



	String getTheRestOfQuery(String userKey, String interfaceType);

	Order getOneOrder(String userKey, String interfaceType);

	List<Map<String, String>> getInterFaceUseList(String interfaceType);

	Map<String, String> getInterFaceUseById(String id, String interfaceType);

	Map<String, String> getInterFaceUseByUserKey(String userKey, String interfaceType);
}
