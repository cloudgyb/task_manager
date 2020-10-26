package org.task.ngst.gyb.action.admin.marktask;

import java.util.List;

import org.apache.struts2.json.annotations.JSON;
import org.task.ngst.gyb.entity.marktask.NotyetMarkTaskItem;
import org.task.ngst.gyb.service.imple.MarkTaskDaoServiceImple;

import com.opensymphony.xwork2.ActionSupport;

public class GetNotyetMarkTask extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private Integer tid;
	private List<NotyetMarkTaskItem> tlist;
	@Override
	public String execute() throws Exception {
		MarkTaskDaoServiceImple mtdsi = new MarkTaskDaoServiceImple();
		tlist = mtdsi.getNotyetmarkTaskByTid(tid);
		return SUCCESS;
	}
	@JSON(serialize=false)
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	@JSON
	public List<NotyetMarkTaskItem> getTlist() {
		return tlist;
	}
}
