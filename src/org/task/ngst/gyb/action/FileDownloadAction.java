package org.task.ngst.gyb.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.task.ngst.gyb.entity.User;
import org.task.ngst.gyb.util.UploadUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FileDownloadAction extends ActionSupport{
	
	/**
	 * 文件下载Action
	 */
	private static final long serialVersionUID = 2681523098058487148L;
	private InputStream fileInputStream;//文件输入流
	private String downloadFileName;//存储要下载的文件名，从数据库中读出的文件路径及文件名
	private String recvfileName;//用户下载文件保存的文件名
	
	@Override
	public String execute() throws Exception {
		User u = (User) ActionContext.getContext().getSession().get("task_user");
		if(u==null){
			return "LoginPastDue";
		}
		String downloadFileBasePath = null;
		if(u.getUcategory()==1){
			downloadFileBasePath = UploadUtil.adminUploadRootPath;
		}else if(u.getUcategory()==0){
			downloadFileBasePath = UploadUtil.memberUploadRootPath;
		}
		System.out.println(downloadFileName);
		recvfileName = downloadFileName.substring(downloadFileName.lastIndexOf("/")+1);
		fileInputStream = new FileInputStream(new File(downloadFileBasePath,downloadFileName));
		return SUCCESS; 
	}

	
	
	public InputStream getFileInputStream() {
		return fileInputStream;
	}



	public void setFileInputStream(InputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}



	public String getDownloadFileName() {
		return downloadFileName;
	}

	public void setDownloadFileName(String downloadFileName) {
		this.downloadFileName = downloadFileName;
	}

	public String getRecvfileName() {
		return recvfileName;
	}

	public void setRecvfileName(String recvfileName) {
		this.recvfileName = recvfileName;
	}
	

}
