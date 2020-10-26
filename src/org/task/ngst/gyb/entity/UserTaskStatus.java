package org.task.ngst.gyb.entity;

import java.io.Serializable;
import java.util.Date;

public class UserTaskStatus implements Serializable{

	/**
	 *存储用户任务状态
	 */
	private 	static 		final long serialVersionUID = -8163388988443981497L;
	private 	Integer 	suid;  //所属用户
	private 	Integer 	stid;	//任务id
	private 	Integer 	status; //任务完成标志（状态）：0未完成，1完成
	private 	Date 		doneDate; //任务完成日期
	private	 	String 		ttext1;   //任务提交相关文档1
	private 	String 		ttext2;	  //任务提交相关文档2
	private 	String 		staffix;  //上传的文档服务器存储路径
	public UserTaskStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserTaskStatus(Integer suid, Integer stid, Integer status,
			Date doneDate, String ttext1, String ttext2, String staffix) {
		super();
		this.suid = suid;
		this.stid = stid;
		this.status = status;
		this.doneDate = doneDate;
		this.ttext1 = ttext1;
		this.ttext2 = ttext2;
		this.staffix = staffix;
	}
	public Integer getSuid() {
		return suid;
	}
	public void setSuid(Integer suid) {
		this.suid = suid;
	}
	public Integer getStid() {
		return stid;
	}
	public void setStid(Integer stid) {
		this.stid = stid;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getDoneDate() {
		return doneDate;
	}
	public void setDoneDate(Date doneDate) {
		this.doneDate = doneDate;
	}
	public String getTtext1() {
		return ttext1;
	}
	public void setTtext1(String ttext1) {
		this.ttext1 = ttext1;
	}
	public String getTtext2() {
		return ttext2;
	}
	public void setTtext2(String ttext2) {
		this.ttext2 = ttext2;
	}
	public String getStaffix() {
		return staffix;
	}
	public void setStaffix(String staffix) {
		this.staffix = staffix;
	}
	@Override
	public String toString() {
		return "UserTaskStatus [suid=" + suid + ", stid=" + stid + ", status="
				+ status + ", doneDate=" + doneDate + ", ttext1=" + ttext1
				+ ", ttext2=" + ttext2 + ", staffix=" + staffix + "]";
	}
	
	
	
	
}
