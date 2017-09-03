package org.task.ngst.gyb.action.admin.marktask;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;
import org.task.ngst.gyb.entity.Task;
import org.task.ngst.gyb.entity.User;
import org.task.ngst.gyb.entity.UserTaskStatus;
import org.task.ngst.gyb.service.imple.TaskDaoServiceImple;
import org.task.ngst.gyb.service.imple.UserDaoServiceImple;
import org.task.ngst.gyb.service.imple.UserTaskStatusDaoServiceImple;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 获取用户完成任务的详细信息，并展示到批改任务界面
 * @author 耿远博
 */
public class GetUserDoneTask extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private Integer tid;
	private Integer uid;
	
	@Override
	public String execute() throws Exception {
		UserTaskStatusDaoServiceImple utsdsi = new UserTaskStatusDaoServiceImple();
		UserTaskStatus uts = utsdsi.getTaskStatusBySuidAndStid(uid, tid);
		TaskDaoServiceImple tdsi = new TaskDaoServiceImple();
		Task task = tdsi.getTaskById(tid);
		UserDaoServiceImple udsi = new UserDaoServiceImple();
		User user = udsi.getUserById(uid);
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
		request.setAttribute("donetaskdetail", uts);
		request.setAttribute("task", task);
		request.setAttribute("user", user);
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
