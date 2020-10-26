package org.task.ngst.gyb.action.member;

import java.io.File;
import java.util.Date;

import org.task.ngst.gyb.entity.Grade;
import org.task.ngst.gyb.entity.UserTaskStatus;
import org.task.ngst.gyb.service.UserTaskStatusDaoService;
import org.task.ngst.gyb.service.imple.GradeDaoServiceImple;
import org.task.ngst.gyb.service.imple.UserTaskStatusDaoServiceImple;
import org.task.ngst.gyb.util.UploadUtil;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 用户任务上传或者更新Action
 * @author 耿远博
 */
public class UploadTask extends ActionSupport{
	
	private static final long serialVersionUID = -2393087254082526918L;
	//文件相关属性
	private File file;
	private String fileFileName;
	private String fileContentType;
	//任务数据
	private String ttext1;
	private String ttext2;
	private Integer uid;
	private Integer tid;
	@Override
	public String execute() throws Exception {
		String fileExtension = null;
		String outFileName = null;
		if(file!=null){
			/*-------------------------文件上传---------------------------------*/
			//输出文件的后缀名
			fileExtension = fileFileName.substring(fileFileName.lastIndexOf("."));
			//输出文件名：uid+tid+系统当前时间+用户上传的文件后缀名
			outFileName = System.currentTimeMillis()+fileExtension;
			//上传文件
			UploadUtil.memberUploadFile(file, outFileName);
		}
		/*-----------------------任务数据上传-----------------------------------*/
		UserTaskStatusDaoService utsds = new UserTaskStatusDaoServiceImple();
		UserTaskStatus uts = utsds.getTaskStatusBySuidAndStid(uid, tid);
		if(uts.getStaffix()!=null){
			UploadUtil.memberDeleteOldFile(uts.getStaffix());
		}
		uts.setDoneDate(new Date());
		uts.setStatus(1); //设置状态为1，表示任务已提交
		uts.setSuid(uid);
		uts.setStid(tid);
		uts.setTtext1(ttext1);
		uts.setTtext2(ttext2);
		if(file==null){//如果没有上传文件
			uts.setStaffix(null);
		}else{
			uts.setStaffix(outFileName);
		}
		utsds.modifyTaskStatus(uts);
		//向成绩表插入数据
		GradeDaoServiceImple gdsi = new GradeDaoServiceImple();
		gdsi.syncGrade(new Grade(uid, tid, null, null, 0f));
		return SUCCESS;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	public void setTtext2(String ttext2) {
		this.ttext2 = ttext2;
	}
	public String getTtext1() {
		return ttext1;
	}

	public void setTtext1(String ttext) {
		this.ttext1 = ttext;
	}

	public String getTtext2() {
		return ttext2;
	}
}
