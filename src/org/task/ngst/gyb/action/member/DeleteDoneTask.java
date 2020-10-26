package org.task.ngst.gyb.action.member;

import org.task.ngst.gyb.entity.UserTaskStatus;
import org.task.ngst.gyb.service.UserTaskStatusDaoService;
import org.task.ngst.gyb.service.imple.GradeDaoServiceImple;
import org.task.ngst.gyb.service.imple.UserTaskStatusDaoServiceImple;
import org.task.ngst.gyb.util.UploadUtil;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteDoneTask extends ActionSupport{
	/**
	 * 删除已完成的任务Action
	 */
	private static final long serialVersionUID = -9060220625975937143L;
	private Integer tid;
	private Integer uid;
	
	@Override
	public String execute() throws Exception {
		UserTaskStatusDaoService utsds = new UserTaskStatusDaoServiceImple();
		UserTaskStatus uts = utsds.getTaskStatusBySuidAndStid(uid, tid);
		GradeDaoServiceImple gdsi = new GradeDaoServiceImple();
		//数据置空
		uts.setDoneDate(null);
		uts.setStatus(0);//完成状态修改为0
		if(uts.getStaffix()!=null){ 
			UploadUtil.memberDeleteOldFile(uts.getStaffix());
			//FileUtil.deleteFile(uts.getStaffix());	
		}
		uts.setStaffix(null);
		uts.setTtext1(null);
		uts.setTtext2(null);
		utsds.modifyTaskStatus(uts);
		gdsi.deleteGrade(uid, tid);
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
