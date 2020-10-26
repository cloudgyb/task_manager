package org.task.ngst.gyb.entity;

import java.io.Serializable;
import java.util.Date;

public class Task implements Serializable{

	/**
	 * Task 类用于存储任务信息
	 */
	private 	static 		final long serialVersionUID = 1L;
	private 	Integer 	tid;//任务id
	private 	String 		tname; //任务名
	private 	Date 		tstart; //任务开始日期
	private 	Date 		tend; //任务截止日期
	private 	Integer 	tuid; //任务上传者id
	private 	Integer 	tscope; //任务试用范围
	private 	String 		tdesc; //任务描述(要求)
	private 	String 		taffix; //任务上传的资料的路径
	
	public Task() {
	}
	
	public Task(Integer tid, String tname, Date tstart, Date tend,
			Integer tuid, Integer tscope, String tdesc, String taffix) {
		this.tid = tid;
		this.tname = tname;
		this.tstart = tstart;
		this.tend = tend;
		this.tuid = tuid;
		this.tscope = tscope;
		this.tdesc = tdesc;
		this.taffix = taffix;
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
	public Integer getTuid() {
		return tuid;
	}
	public void setTuid(Integer tuid) {
		this.tuid = tuid;
	}
	public Integer getTscope() {
		return tscope;
	}
	public void setTscope(Integer tscope) {
		this.tscope = tscope;
	}
	public String getTdesc() {
		return tdesc;
	}
	public void setTdesc(String tdesc) {
		this.tdesc = tdesc;
	}
	public String getTaffix() {
		return taffix;
	}
	public void setTaffix(String taffix) {
		this.taffix = taffix;
	}
	@Override
	public String toString() {
		return "Task [tid=" + tid + ", tname=" + tname + ", tstart=" + tstart
				+ ", tend=" + tend + ", tuid=" + tuid + ", tscope=" + tscope
				+ ", tdesc=" + tdesc + ", taffix=" + taffix + "]";
	}
	
	
}
