package org.task.ngst.gyb.interceptor;

import org.task.ngst.gyb.entity.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor{
	/**
	 * 用户登录拦截器
	 * 用于拦截未登录的用户访问网站资源
	 */
	private static final long serialVersionUID = 8742204033566067646L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String actionName = invocation.getProxy().getActionName();//获取Action名
		if(actionName.equals("login")){//如果是login.action，直接放行
			return invocation.invoke();
		}
		//如果不是进行判断是否登录
		User u = (User) ActionContext.getContext().getSession().get("task_user");
		System.out.println("Login 拦截器user："+u);
		if(u==null){ //如果没有登录信息
			return "login"; //返回登录页面
		}
		
		return invocation.invoke();//验证通过向下执行
	}
}
