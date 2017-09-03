package org.task.ngst.gyb.action.admin.marktask;


import java.util.Date;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;
import org.task.ngst.gyb.entity.Grade;
import org.task.ngst.gyb.entity.User;
import org.task.ngst.gyb.service.imple.GradeDaoServiceImple;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 提交任务成绩
 * @author 耿远博
 */
public class SubmitScore extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private Integer tid;
	private Integer uid;
	private Float score;
	private String mess;
	@Override
	public String execute() throws Exception {
		if(tid==null||uid==null){
			mess = "数据异常";
		}
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("task_user");
		GradeDaoServiceImple gdsi = new GradeDaoServiceImple();
		Grade g = new Grade(uid, tid, user.getUid(), new Date(), score);
		gdsi.modifyGrade(g);
		mess = "ok";
		return SUCCESS;
	}
	@JSON(serialize=false)
	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}
	@JSON(serialize=false)
	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}
	@JSON(serialize=false)
	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}
	@JSON
	public String getMess() {
		return mess;
	}
	
}
