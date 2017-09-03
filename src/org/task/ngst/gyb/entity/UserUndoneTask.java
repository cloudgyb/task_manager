package org.task.ngst.gyb.entity;

import java.io.Serializable;
import java.util.Date;

public class UserUndoneTask implements Serializable{

	/**
	 * 存储用户未完成任务的信息摘要
	 */
	private 	static final long serialVersionUID = -4740066119447844649L;
	private 	Integer 	tid;
	private		String		tname;
	private		String		tuname;
	private 	Date		tstart;
	private		Date		tend;
	public UserUndoneTask() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserUndoneTask(Integer tid, String tname, String tuname,
			Date tstart, Date tend) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.tuname = tuname;
		this.tstart = tstart;
		this.tend = tend;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTuname() {
		return tuname;
	}
	public void setTuname(String tuname) {
		this.tuname = tuname;
	}
	public Date getTstart() {
		return tstart;
	}
	public void setTstart(Date tstart) {
		this.tstart = tstart;
	}
	public Date getTend() {
		return tend;
	}
	public void setTend(Date tend) {
		this.tend = tend;
	}
	@Override
	public String toString() {
		return "UserUndoneTask [tid=" + tid + ", tname=" + tname + ", tuname="
				+ tuname + ", tstart=" + tstart + ", tend=" + tend + "]";
	}
	
}
