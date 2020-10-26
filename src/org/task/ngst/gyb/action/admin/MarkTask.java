package org.task.ngst.gyb.action.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;
import org.task.ngst.gyb.entity.Task;
import org.task.ngst.gyb.entity.User;
import org.task.ngst.gyb.service.imple.TaskDaoServiceImple;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MarkTask extends ActionSupport{

	/**
	 *  管理员对任务打分（批改）
	 *  @author 耿远博
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String execute() throws Exception {
		ActionContext ac = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ac.get(StrutsStatics.HTTP_REQUEST);
		TaskDaoServiceImple tdsi = new TaskDaoServiceImple();
		User u = (User)ac.getSession().get("task_user");
		//将自己上传的任务返回
		List<Task> tasks = tdsi.getTaskByTuid(u.getUid());
		request.setAttribute("tasks", tasks);
		return SUCCESS;
	}

}
