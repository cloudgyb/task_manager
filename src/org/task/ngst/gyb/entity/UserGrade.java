package org.task.ngst.gyb.entity;

import java.io.Serializable;
import java.util.Date;

public class UserGrade implements Serializable{
	/**
	 * 成绩单
	 */
	private 	static 		final long serialVersionUID = -5575148213620870170L;
	private 	Integer 	tid;			//任务id
	private 	String 		tname;			//任务名
	private		Integer		dealUserId;		//成绩评定人id
	private 	String		dealUserName;	//成绩评定人姓名
	private 	Date		dealDate;		//成绩评定日期
	private 	Float		score;			//分数
	public UserGrade() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserGrade(Integer tid, String tname, Integer dealUserId,
			String dealUserName, Date dealDate, Float score) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.dealUserId = dealUserId;
		this.dealUserName = dealUserName;
		this.dealDate = dealDate;
		this.score = score;
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
	public Integer getDealUserId() {
		return dealUserId;
	}
	public void setDealUserId(Integer dealUserId) {
		this.dealUserId = dealUserId;
	}
	public String getDealUserName() {
		return dealUserName;
	}
	public void setDealUserName(String dealUserName) {
		this.dealUserName = dealUserName;
	}
	public Date getDealDate() {
		return dealDate;
	}
	public void setDealDate(Date dealDate) {
		this.dealDate = dealDate;
	}
	public Float getScore() {
		return score;
	}
	public void setScore(Float score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "UserGrade [tid=" + tid + ", tname=" + tname + ", dealUserId="
				+ dealUserId + ", dealUserName=" + dealUserName + ", dealDate="
				+ dealDate + ", score=" + score + "]";
	}
	
}
