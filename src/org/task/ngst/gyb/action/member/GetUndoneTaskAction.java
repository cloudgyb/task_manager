package org.task.ngst.gyb.action.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;
import org.task.ngst.gyb.entity.User;
import org.task.ngst.gyb.entity.UserUndoneTask;
import org.task.ngst.gyb.service.UserDoTaskDaoService;
import org.task.ngst.gyb.service.imple.UserDoTaskDaoServiceImple;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GetUndoneTaskAction extends ActionSupport{
	
	/**
	 * 获取未完成的任务
	 */
	private static final long serialVersionUID = -8346841691401445075L;

	@Override
	public String execute() throws Exception {
		UserDoTaskDaoService  udtds = new UserDoTaskDaoServiceImple();//service
		User u = (User) ActionContext.getContext().getSession().get("task_user");//获取登录信息
		if(u==null){//如果用户信息获取失败
			return ERROR;
		}
		List<UserUndoneTask> list = udtds.getUndoneTaskByUid(u.getUid()); //获取任务数据
		HttpServletRequest request =  (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
		request.setAttribute("nodonetask", list);//将数据返回前台
		return SUCCESS;
	}
	
}
