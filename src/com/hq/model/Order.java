package com.hq.model;

public class Order {
	private String id;
	private String interface_type;
	private String user_key;
	private String user_order_id;
	private String is_order_used;
	private String order_createtime;
	private String order_usetime;
	private String content;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInterface_type() {
		return interface_type;
	}
	public void setInterface_type(String interface_type) {
		this.interface_type = interface_type;
	}
	public String getUser_key() {
		return user_key;
	}
	public void setUser_key(String user_key) {
		this.user_key = user_key;
	}
	public String getUser_order_id() {
		return user_order_id;
	}
	public void setUser_order_id(String user_order_id) {
		this.user_order_id = user_order_id;
	}
	public String getIs_order_used() {
		return is_order_used;
	}
	public void setIs_order_used(String is_order_used) {
		this.is_order_used = is_order_used;
	}
	public String getOrder_createtime() {
		return order_createtime;
	}
	public void setOrder_createtime(String order_createtime) {
		this.order_createtime = order_createtime;
	}
	public String getOrder_usetime() {
		return order_usetime;
	}
	public void setOrder_usetime(String order_usetime) {
		this.order_usetime = order_usetime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
