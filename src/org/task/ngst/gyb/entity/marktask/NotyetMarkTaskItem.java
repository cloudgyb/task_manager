package org.task.ngst.gyb.entity.marktask;

import java.io.Serializable;
import java.util.Date;

/**
 * 未批改任务 实体类
 * @author 耿远博
 *
 */
public class NotyetMarkTaskItem implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer tid; //任务ID
	private String tname; //任务名
	private Integer uid;  //任务对应用户ID
	private Date tstartTime; //任务开始时间
	private Date tendTime;  //任务结束时间
	public NotyetMarkTaskItem(){ }
	public NotyetMarkTaskItem(Integer tid, String tname, Integer uid,
			 Date tstartTime, Date tendTime) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.uid = uid;
		this.tstartTime = tstartTime;
		this.tendTime = tendTime;
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
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Date getTstartTime() {
		return tstartTime;
	}
	public void setTstartTime(Date tstartTime) {
		this.tstartTime = tstartTime;
	}
	public Date getTendTime() {
		return tendTime;
	}
	public void setTendTime(Date tendTime) {
		this.tendTime = tendTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "NotyetMarkTaskItem [tid=" + tid + ", tname=" + tname + ", uid="
				+ uid + ", tstartTime=" + tstartTime
				+ ", tendTime=" + tendTime + "]";
	}
	
}
