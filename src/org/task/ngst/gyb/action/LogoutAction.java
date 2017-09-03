package org.task.ngst.gyb.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport{
	
	/**
	 * 注销登录Action
	 */
	private static final long serialVersionUID = -6855159004064183721L;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ActionContext.getContext().getSession().remove("task_user");
		return SUCCESS;
	}

}
