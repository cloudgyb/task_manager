package org.task.ngst.gyb.action.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;
import org.task.ngst.gyb.entity.UserDoneTask;
import org.task.ngst.gyb.service.UserDoTaskDaoService;
import org.task.ngst.gyb.service.imple.UserDoTaskDaoServiceImple;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GetDoneTask extends ActionSupport{
	/**
	 * 获取完成的任务
	 */
	private static final long serialVersionUID = -7816014651662655809L;
	private Integer uid;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		UserDoTaskDaoService udtds = new UserDoTaskDaoServiceImple();
		List<UserDoneTask> list = udtds.getDoneTaskByUid(uid);
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
		request.setAttribute("userdonetask", list);
		return SUCCESS;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
}
