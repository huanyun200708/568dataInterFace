package com.hq.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;


public interface UserService {
	List<JSONObject> getAllUser();

	JSONObject getUserById(String id);

	boolean updatePassWordById(String passWord, String id);

	boolean deleteUserByIds(List<String> idList);

	boolean validatePassWordById(String password, String id);

	boolean validateuserExist(String name);

	boolean addUser(String name, String password);
}
