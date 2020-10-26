package org.task.ngst.gyb.interceptor;

import org.task.ngst.gyb.entity.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class SpporterInterceptor extends AbstractInterceptor{
	/**
	 * 权限验证
	 * 维护人员身份验证
	 * 对非维护人员身份登录的用户进行拦截
	 */
	private static final long serialVersionUID = 3664119386494243702L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		User u = (User) ActionContext.getContext().getSession().get("task_user");
		if(u==null){//判断是否登录
			return "login";
		}else{
			if(u.getUcategory()==2){//判断是否是维护人员
				return invocation.invoke();
			}else{
				return "login";//返回登录页
			}
		}
	}

}
