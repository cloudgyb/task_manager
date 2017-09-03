package org.task.ngst.gyb.entity;

import java.io.Serializable;
import java.util.Date;

public class Grade implements Serializable{
	/**
	 * 存储用户成绩
	 */
	private 	static 		final long serialVersionUID = 5548351938023419968L;
	private 	Integer 	guid;  //成绩所属用户id
	private 	Integer 	gtid;  //任务id
	private 	Integer 	dealUid; //成绩评定用户信息：用户id，用户name
	private 	Date 		dealDate; //成绩评定日期
	private 	Float 		score;   //任务得分
	public Grade() { }
	public Grade(Integer guid, Integer gtid, Integer dealUid, Date dealDate,
			Float score) {
		super();
		this.guid = guid;
		this.gtid = gtid;
		this.dealUid = dealUid;
		this.dealDate = dealDate;
		this.score = score;
	}
	public Date getDealDate() {
		return dealDate;
	}
	public Integer getDealUid() {
		return dealUid;
	}
	public Integer getGtid() {
		return gtid;
	}
	public Integer getGuid() {
		return guid;
	}
	public Float getScore() {
		return score;
	}
	public void setDealDate(Date dealDate) {
		this.dealDate = dealDate;
	}
	public void setDealUid(Integer dealUid) {
		this.dealUid = dealUid;
	}
	public void setGtid(Integer gtid) {
		this.gtid = gtid;
	}
	public void setGuid(Integer guid) {
		this.guid = guid;
	}
	public void setScore(Float score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Grade [guid=" + guid + ", gtid=" + gtid + ", dealUid="
				+ dealUid + ", dealDate=" + dealDate + ", score=" + score + "]";
	}
	
	
}
