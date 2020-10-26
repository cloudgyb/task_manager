package org.task.ngst.gyb.action.member;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.task.ngst.gyb.entity.Task;
import org.task.ngst.gyb.entity.UserTaskStatus;
import org.task.ngst.gyb.service.TaskDaoService;
import org.task.ngst.gyb.service.UserTaskStatusDaoService;
import org.task.ngst.gyb.service.imple.TaskDaoServiceImple;
import org.task.ngst.gyb.service.imple.UserTaskStatusDaoServiceImple;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 查看以完成的任务详情Action
 */
public class ViewDoneTask extends ActionSupport{
	
	private static final long serialVersionUID = -5092050491317518426L;
	private Integer tid;
	private Integer uid;

	@Override
	public String execute() throws Exception {		
		TaskDaoService tsd = new TaskDaoServiceImple();
		UserTaskStatusDaoService utsd = new UserTaskStatusDaoServiceImple();
		Task t = tsd.getTaskById(tid);
		UserTaskStatus utstatus = utsd.getTaskStatusBySuidAndStid(uid, tid);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("task", t);
		request.setAttribute("utstatus",utstatus);
		return SUCCESS;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
}
