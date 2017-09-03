package org.task.ngst.gyb.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 管理员查看成绩时的数据项（Entity）
 * @author 耿远博
 *
 */

public class GradeItem implements Comparable<GradeItem>,Serializable{
	private static final long serialVersionUID = 1L;
	//private Grade grade; //成绩数据
	//private User user; //用户数据
	private Integer tid; //任务对应的ID
	//private String tname; //任务名
	private String tuname; //成绩评定人
	private String uname;  //任务对应的用户名字
	//private Integer ugrade  //用户级别(年级)
	private Date   checkDate; //成绩批改日期
	private Float  score;  //分数
	
	
	
	public GradeItem() { }

	public GradeItem(Integer tid, String tuname, String uname , Date checkDate, Float score) {
		super();
		this.tid = tid;
		this.tuname = tuname;
		this.checkDate = checkDate;
		this.score = score;
		this.uname = uname;
	}
	@Override
	public int compareTo(GradeItem o) {
		if(this.score > o.getScore())
			return 1;
		else if(this.score < o.getScore())
			return -1;
		return 0;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getTuname() {
		return tuname;
	}

	public void setTuname(String tuname) {
		this.tuname = tuname;
	}

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	@Override
	public String toString() {
		return "GradeItem [tid=" + tid + ", tuname=" + tuname + ", uname="
				+ uname + ", checkDate=" + checkDate + ", score=" + score + "]";
	}
	
}
