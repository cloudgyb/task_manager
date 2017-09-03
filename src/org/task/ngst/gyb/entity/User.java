package org.task.ngst.gyb.entity;

import java.io.Serializable;

public class User implements Serializable{
	/**
	 * 用户（User）实体类
	 */
	private		static 		final long serialVersionUID = 1L;
	private 	Integer 	uid;		//用户学号
	private 	String 		uname;		//用户姓名
	private 	String 		upasswd;	//用户密码
	private 	Integer 	uage;		//用户年龄
	private 	String 		usex;		//用户性别
	private 	String 		uclass;		//用户班级
	private 	Integer 	ugrade; 	//用户级别，例如13级14级
	private 	Integer 	ucategory; 	//用户身份（类别）,0普通1管理员2维护
	private 	String 		uqq;		//用户QQ
	private 	String 		uemail;		//用户email
	private 	String 		utel;		//用户电话
	private 	String		upasswdQues;//用户密保问题
	private 	String 		upasswdAns; //用户密保答案
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer uid, String uname, String upasswd, Integer uage,
			String usex, String uclass, Integer ugrade, Integer ucategory,
			String uqq, String uemail, String utel, String upasswdQues,
			String upasswdAns) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upasswd = upasswd;
		this.uage = uage;
		this.usex = usex;
		this.uclass = uclass;
		this.ugrade = ugrade;
		this.ucategory = ucategory;
		this.uqq = uqq;
		this.uemail = uemail;
		this.utel = utel;
		this.upasswdQues = upasswdQues;
		this.upasswdAns = upasswdAns;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpasswd() {
		return upasswd;
	}
	public void setUpasswd(String upasswd) {
		this.upasswd = upasswd;
	}
	public Integer getUage() {
		return uage;
	}
	public void setUage(Integer uage) {
		this.uage = uage;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
	public String getUclass() {
		return uclass;
	}
	public void setUclass(String uclass) {
		this.uclass = uclass;
	}
	public Integer getUgrade() {
		return ugrade;
	}
	public void setUgrade(Integer ugrade) {
		this.ugrade = ugrade;
	}
	public Integer getUcategory() {
		return ucategory;
	}
	public void setUcategory(Integer ucategory) {
		this.ucategory = ucategory;
	}
	public String getUqq() {
		return uqq;
	}
	public void setUqq(String uqq) {
		this.uqq = uqq;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUtel() {
		return utel;
	}
	public void setUtel(String utel) {
		this.utel = utel;
	}
	public String getUpasswdQues() {
		return upasswdQues;
	}
	public void setUpasswdQues(String upasswdques) {
		this.upasswdQues = upasswdques;
	}
	public String getUpasswdAns() {
		return upasswdAns;
	}
	public void setUpasswdAns(String upasswdAns) {
		this.upasswdAns = upasswdAns;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upasswd=" + upasswd
				+ ", uage=" + uage + ", usex=" + usex + ", uclass=" + uclass
				+ ", ugrade=" + ugrade + ", ucategory=" + ucategory + ", uqq="
				+ uqq + ", uemail=" + uemail + ", utel=" + utel
				+ ", upasswdques=" + upasswdQues + ", upasswdAns=" + upasswdAns
				+ "]";
	}
	
}
