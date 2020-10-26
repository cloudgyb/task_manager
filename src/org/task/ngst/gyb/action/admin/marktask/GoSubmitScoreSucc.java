package org.task.ngst.gyb.action.admin.marktask;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 这个Action 没有任何数据处理，只是用来返回到成绩提交成功界面
 * @author 耿远博
 */
public class GoSubmitScoreSucc extends ActionSupport{

	private static final long serialVersionUID = 1L;
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
}
