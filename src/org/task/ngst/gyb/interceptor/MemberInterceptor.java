package org.task.ngst.gyb.interceptor;

import org.task.ngst.gyb.entity.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MemberInterceptor extends AbstractInterceptor{

	/**
	 * 权限验证
	 * 普通用户身份验证
	 * 对非普通身份登录的用户进行拦截
	 */
	private static final long serialVersionUID = 219333501946390202L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		User u = (User) ActionContext.getContext().getSession().get("task_user");
		System.out.println("Member 拦截器 user:"+u);
		if(u==null){//判断是否登录
			return "login";
		}else{
			if(u.getUcategory()==0){//判断是否是普通用户
				return invocation.invoke();
			}else{
				return "login";//返回登录页
			}
		}
	}

}
