package org.task.ngst.gyb.entity;

import java.io.Serializable;
import java.util.Date;

public class UserDoneTask implements Serializable{
	/**
	 * 用户完成任务信息
	 */
	private 	static final long serialVersionUID = 7342026953443559217L;
	private 	Integer 	tid;
	private 	String  	tname;
	private		String 		tuname;
	private 	Date		tstart;
	private 	Date		tend;
	private		Date		tdone;
	
	public UserDoneTask() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDoneTask(Integer tid, String tname, String tuname, Date tstart,
			Date tend, Date tdone) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.tuname = tuname;
		this.tstart = tstart;
		this.tend = tend;
		this.tdone = tdone;
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

	public Date getTdone() {
		return tdone;
	}

	public void setTdone(Date tdone) {
		this.tdone = tdone;
	}

	@Override
	public String toString() {
		return "UserDoneTask [tid=" + tid + ", tname=" + tname + ", tuname="
				+ tuname + ", tstart=" + tstart + ", tend=" + tend + ", tdone="
				+ tdone + "]";
	}
	
	
	
}
