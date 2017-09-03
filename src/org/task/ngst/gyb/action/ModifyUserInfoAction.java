package org.task.ngst.gyb.action;

import org.task.ngst.gyb.entity.User;
import org.task.ngst.gyb.service.UserDaoService;
import org.task.ngst.gyb.service.imple.UserDaoServiceImple;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ModifyUserInfoAction extends ActionSupport{
	/**
	 * 修改用户信息Action
	 */
	
	private static final long serialVersionUID = 1L;
	private User user;
	@Override
	public String execute() throws Exception {
		UserDaoService ud = new UserDaoServiceImple();
		User task_user = (User) ActionContext.getContext().getSession().get("task_user");
		//以下4个用户信息在此不准修改，直接设置。。。
		user.setUid(task_user.getUid());
		user.setUgrade(task_user.getUgrade());
		user.setUcategory(task_user.getUcategory());
		user.setUpasswd(task_user.getUpasswd());
		
		ud.modifyUser(user);//修改用户信息
		ActionContext.getContext().getSession().put("task_user",user);//更新session中的值
		return "modifysucc";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User u) {
		this.user = u;
	}
	

}
