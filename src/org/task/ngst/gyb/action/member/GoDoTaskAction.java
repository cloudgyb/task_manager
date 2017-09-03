package org.task.ngst.gyb.action.member;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;
import org.task.ngst.gyb.entity.Task;
import org.task.ngst.gyb.service.TaskDaoService;
import org.task.ngst.gyb.service.imple.TaskDaoServiceImple;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GoDoTaskAction extends ActionSupport{
	/**
	 * 获取任务详情
	 */
	private static final long serialVersionUID = 7215703850097991300L;
	private Integer tid;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		TaskDaoService tds = new TaskDaoServiceImple();
		ActionContext ac = ActionContext.getContext();
		HttpServletRequest request = null;
		Task t = tds.getTaskById(tid);
		System.out.println(t);
		if(t!=null){
			request = (HttpServletRequest) ac.get(StrutsStatics.HTTP_REQUEST);
			request.setAttribute("task", t);
		}
		return SUCCESS;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}

}
