package org.task.ngst.gyb.action.admin;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;
import org.task.ngst.gyb.entity.Task;
import org.task.ngst.gyb.entity.User;
import org.task.ngst.gyb.service.imple.TaskDaoServiceImple;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 管理员查看自己上传的任务详情
 */
public class ViewTask extends ActionSupport{
	private Integer tid;
	private static final long serialVersionUID = -2973330535300769281L;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ActionContext ac = ActionContext.getContext();
		User u = (User) ac.getSession().get("task_user");
		if(u==null) return "LoginPastDue";//登录过期
		
		TaskDaoServiceImple tdsi = new TaskDaoServiceImple();
		Task t = tdsi.getTaskById(tid);
		HttpServletRequest request = (HttpServletRequest) ac.get(StrutsStatics.HTTP_REQUEST);
		request.setAttribute("t", t);
		
		return SUCCESS;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	
}
