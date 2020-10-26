package org.task.ngst.gyb.action.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;
import org.task.ngst.gyb.entity.Task;
import org.task.ngst.gyb.entity.User;
import org.task.ngst.gyb.service.imple.TaskDaoServiceImple;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 管理员查看成绩,进入查看成绩页面
 * @author 耿远博
 */
public class ViewGrade extends ActionSupport{

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
