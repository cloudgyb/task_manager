package org.task.ngst.gyb.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;

public class WebInternalObj {
	private static HttpServletRequest request;
	private static Map<String,Object> session;
	static{
		request = (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
		session = ActionContext.getContext().getSession();
	}
	public static HttpServletRequest getRequest(){
		if(request==null){
			request = (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
		}
		return request;
	}
	public static Map<String,Object> getSession(){
		if(session==null){
			session = ActionContext.getContext().getSession();
		}
		return session;
	}
}
