package org.task.ngst.gyb.action.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.task.ngst.gyb.entity.UserGrade;
import org.task.ngst.gyb.service.GradeDaoService;
import org.task.ngst.gyb.service.imple.GradeDaoServiceImple;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 查询任务成绩Action
 */
public class GetTaskGradeScore extends ActionSupport{	
	private static final long serialVersionUID = 7184512604708372953L;
	private Integer uid;
	@Override
	public String execute() throws Exception {
		GradeDaoService gds = new GradeDaoServiceImple();
		
		List<UserGrade> list = gds.getUserGradeByGuid(uid);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("taskgrade", list);
		return SUCCESS;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	
}
