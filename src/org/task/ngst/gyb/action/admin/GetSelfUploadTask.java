package org.task.ngst.gyb.action.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;
import org.task.ngst.gyb.entity.Task;
import org.task.ngst.gyb.entity.User;
import org.task.ngst.gyb.service.imple.TaskDaoServiceImple;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GetSelfUploadTask extends ActionSupport{

	/**
	 * 管理员获取所有自己上传的任务要求
	 */
	private static final long serialVersionUID = -2520984453694505819L;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ActionContext ac = ActionContext.getContext();
		User u = (User) ac.getSession().get("task_user");
		if(u==null) return "LoginPastDue";//登录过期
		
		TaskDaoServiceImple tdsi = new TaskDaoServiceImple();
		List<Task> taskl = tdsi.getTaskByTuid(u.getUid());
		HttpServletRequest request = (HttpServletRequest) ac.get(StrutsStatics.HTTP_REQUEST);
		request.setAttribute("selfuploadtask", taskl);
		return SUCCESS;
	}

}
