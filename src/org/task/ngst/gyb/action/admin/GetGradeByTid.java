package org.task.ngst.gyb.action.admin;

import java.util.Collections;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;
import org.task.ngst.gyb.entity.GradeItem;
import org.task.ngst.gyb.entity.User;
import org.task.ngst.gyb.service.GradeItemDaoService;
import org.task.ngst.gyb.service.imple.GradeItemDaoServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 根据任务id获取
 */
public class GetGradeByTid extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Integer tid;
	private List<GradeItem> gradeItems;
	@Override
	public String execute() throws Exception {
		getGrade();
		return SUCCESS;
	}
	public String orderByAsc(){
		getGrade();
		Collections.sort(gradeItems);
		return SUCCESS;
	}
	
	public String orderByDesc(){
		getGrade();
		//Collections.reverseOrder();
		Collections.reverse(gradeItems);
		return SUCCESS;
	}
	
	public void getGrade(){
		User user = (User) ActionContext.getContext().getSession().get("task_user");
		GradeItemDaoService gids = new GradeItemDaoServiceImpl();
		gradeItems = gids.getGradeItemsByTid(tid);
		for (GradeItem gi : gradeItems) {
			gi.setTuname(user.getUname());
		}
	}
	@JSON(serialize=false)
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	@JSON
	public List<GradeItem> getGradeItems() {
		return gradeItems;
	}
	public void setGradeItems(List<GradeItem> gradeItems) {
		this.gradeItems = gradeItems;
	}
}
