package org.task.ngst.gyb.action.admin;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;
import org.task.ngst.gyb.entity.Task;
import org.task.ngst.gyb.entity.User;
import org.task.ngst.gyb.service.imple.TaskDaoServiceImple;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ModifyTask extends ActionSupport{

	/**
	 * 管理员用户修改任务要求
	 */
	private Integer tid;
	private static final long serialVersionUID = -5149870271233981016L;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ActionContext ac = ActionContext.getContext();
		User u =  (User) ac.getSession().get("task_user");
		if(u==null) return "LoginPastDue";
		TaskDaoServiceImple tdsi = new TaskDaoServiceImple();
		Task t = tdsi.getTaskById(tid);
	 	HttpServletRequest request =  (HttpServletRequest) ac.get(StrutsStatics.HTTP_REQUEST);
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
