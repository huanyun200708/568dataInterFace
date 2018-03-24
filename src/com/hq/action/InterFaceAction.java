package com.hq.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import cn.com.hq.util.JsonUtils;

import com.hq.model.CLZT;
import com.hq.model.Order;
import com.hq.service.InterFaceService;
import com.hq.serviceimpl.InterFaceServiceimpl;
import com.weixinpay.common.RandomStringGenerator;

public class InterFaceAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private InterFaceService interFaceService = new InterFaceServiceimpl();
	private static Logger logger = Logger.getLogger(InterFaceAction.class);
	public void getTheRestOfQuery() {
		HttpServletRequest reguest = super.getRequest();
		String userKey = reguest.getParameter("userKey");
		String count = interFaceService.getTheRestOfQuery(userKey);
		Map<String,String> result = new HashMap<String,String>(1);
		result.put("count", count);
		responseWriter(JsonUtils.toJson(result));
	}
	
	public void addInterFaceUse() {
		HttpServletRequest reguest = super.getRequest();
		Map<String,String> resultMessage = new HashMap<String,String>(1);
		String name = reguest.getParameter("name");
		String phone = reguest.getParameter("phone");
		String count = reguest.getParameter("count");
		String userKey = RandomStringGenerator.getRandomStringByLength(32);
		boolean result = interFaceService.addInterFaceUse(name,phone,userKey);
		if(result){
			result = interFaceService.insertOrderBaseInfo(userKey, count, "CLXX");
			if(!result){
				resultMessage.put("success", "false");
				resultMessage.put("message", "增加次数失败失败！");
				responseWriter(JsonUtils.toJson(result));
			}else{
				resultMessage.put("success", "true");
				resultMessage.put("message", "创建成功！");
				responseWriter(JsonUtils.toJson(result));
			}
		}else{
			resultMessage.put("success", "false");
			resultMessage.put("message", "创建失败！");
			responseWriter(JsonUtils.toJson(result));
		}
	}
	
	public void getInterFaceUseById() {
		HttpServletRequest reguest = super.getRequest();
		Map<String,String> resultMessage = new HashMap<String,String>(1);
		String id = reguest.getParameter("id");
		Map<String,String> result = interFaceService.getInterFaceUseById(id);
		if(result == null){
			resultMessage.put("success", "false");
			resultMessage.put("message", "获取失败！");
			responseWriter(JsonUtils.toJson(result));
		}else{
			resultMessage.put("success", "true");
			resultMessage.put("message", "获取成功！");
			responseWriter(JsonUtils.toJson(result));
		}
	}
	
	public void updateInterFaceUse() {
		HttpServletRequest reguest = super.getRequest();
		Map<String,String> resultMessage = new HashMap<String,String>(1);
		String id = reguest.getParameter("id");
		String name = reguest.getParameter("name");
		String phone = reguest.getParameter("phone");
		boolean result = interFaceService.updateInterFaceUse(id, name, phone);
		if(result){
			resultMessage.put("success", "true");
			resultMessage.put("message", "更新成功！");
			responseWriter(JsonUtils.toJson(result));
		}else{
			resultMessage.put("success", "false");
			resultMessage.put("message", "更新失败！");
			responseWriter(JsonUtils.toJson(result));
		}
	}
	
	public void getInterFaceUseList() {
		List<Map<String,String>> result = interFaceService.getInterFaceUseList();
		responseWriter("{\"success\":true,\"code\":0,\"msg\":\"\",\"count\":"+result.size()+",\"data\":"+JsonUtils.toJson(result)+"}");
	}
	
	
	public void generateOneUserKey() {
		Map<String,String> result = new HashMap<String,String>(1);
		result.put("userKey", RandomStringGenerator.getRandomStringByLength(32));
		responseWriter(JsonUtils.toJson(result));
	}

	public void CreateOrders() {
		Map<String,String> resultMessage = new HashMap<String,String>(1);
		HttpServletRequest reguest = super.getRequest();
		String userKey = reguest.getParameter("userKey");
		String interface_type = reguest.getParameter("interface_type");
		String count = reguest.getParameter("count");
		boolean result = interFaceService.insertOrderBaseInfo(userKey, count, interface_type);
		if(result){
			resultMessage.put("success", "false");
			resultMessage.put("message", "新增次数失败！");
			responseWriter(JsonUtils.toJson(result));
		}else{
			resultMessage.put("success", "true");
			resultMessage.put("message", "新增次数成功！");
			responseWriter(JsonUtils.toJson(result));
		}
	}
	
	public void QueryCLXX() {
		HttpServletRequest reguest = super.getRequest();
		String userKey = reguest.getParameter("userKey");
		Order order = InterFaceAction.getOneOrderId(userKey);
		String queryResult  = CLZT.queryResult(reguest, "");
		//查询失败
		if(queryResult.indexOf("errorMessage")>-1){
			order.setContent(queryResult);
			logger.error("【query error】orderid:"+order.getUser_order_id()+"--"+queryResult);
			//如果查询失败，则需要退换次数
			if(queryResult.indexOf("\"submitOrder\":1") == -1){
				DateFormat format2 = new SimpleDateFormat("yyyy/MM/dd/ HH:mm:ss:S");
				order.setIs_order_used("0");
			}
		}else{
			//查询成功,更新订单表
			logger.info("---query start--- 查询成功,更新订单表");
		}
		responseWriter(JsonUtils.toJson(queryResult));
		DateFormat format2 = new SimpleDateFormat("yyyy/MM/dd/ HH:mm:ss:S");
		order.setOrder_usetime(format2.format(new Date()));
		order.setContent(queryResult);
		interFaceService.updateOrderBaseInfo(order);
		interFaceService.updateOrderContentInfo(order);
	}

	public static synchronized Order getOneOrderId(String userKey) {
		InterFaceService interFaceService = new InterFaceServiceimpl();
		Order order = interFaceService.getOneOrder(userKey);
		order.setIs_order_used("1");
		interFaceService.updateOrderBaseInfo(order);
		return order;
	}

}