package com.hq.action;

import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	public void responseWriter(String jsonPtString) {
		 getResponse().setHeader("Access-Control-Allow-Origin", "*");
		OutputStream out = null;
	        try
	        {
	            out = getResponse().getOutputStream();  
	            if (jsonPtString != null)
	            {
	            	out.write(jsonPtString.getBytes("UTF-8"));
	            }
	            out.flush();
	        }
	        catch (Exception e)
	        {
	        }
	        finally
	        {
	        	try {
	        		if (out != null)
	                {
	                    out.close();
	                }
				} catch (Exception e2) {
				}
	        }

	}
	
	public HttpServletResponse getResponse() {
		HttpServletResponse res = ServletActionContext.getResponse();
		res.setContentType("text/html;charset=utf-8");
		return res;
	}
	
	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}
}
