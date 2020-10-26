package org.task.ngst.gyb.action.admin;

import org.task.ngst.gyb.entity.Task;
import org.task.ngst.gyb.service.imple.TaskDaoServiceImple;
import org.task.ngst.gyb.util.UploadUtil;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteTask extends	ActionSupport{

	/**
	 * Admin删除任务Action
	 */
	private static final long serialVersionUID = 9065607714569541137L;
	private Integer tid;
	
	@Override
	public String execute() throws Exception {
		TaskDaoServiceImple tdsi = new TaskDaoServiceImple();
		Task t = tdsi.getTaskById(tid);
		if(t.getTaffix()!=null){//将对应的文件删除
			UploadUtil.adminDeleteOldFile(t.getTaffix());
		}
		tdsi.deleteTask(tid);//删除任务
		return SUCCESS;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}
	
}
