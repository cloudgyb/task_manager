package org.task.ngst.gyb.action.admin;

import java.io.File;
import java.util.Date;

import org.task.ngst.gyb.entity.Task;
import org.task.ngst.gyb.entity.User;
import org.task.ngst.gyb.service.imple.TaskDaoServiceImple;
import org.task.ngst.gyb.util.UploadUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 管理员用户发布任务
 */
public class UploadTask extends ActionSupport{
	private static final long serialVersionUID = 4056285629911762809L;
	private File file;
	private String fileFileName;
	private String fileContentType;
	///////////////////////////////////////////////
	private Task task;
	////////////////////////////////////////////////
	
	@Override
	public String execute() throws Exception {
		String fileExtension = null;
		String outFileName = null;
		User u = (User) ActionContext.getContext().getSession().get("task_user");
		task.setTuid(u.getUid());
		if(file!=null){
			/*-------------------------文件上传---------------------------------*/
			//outPath = ServletActionContext.getServletContext().getRealPath("/taskrequirements");
			//输出文件的后缀名
			fileExtension = fileFileName.substring(fileFileName.lastIndexOf("."));
			//输出文件名：系统当前时间+用户上传的文件后缀名
			outFileName = System.currentTimeMillis()+fileExtension;
			System.out.println(outFileName);
			//上传文件
			UploadUtil.adminUploadFile(file, outFileName);
			
		}
		if(task.getTid()==null){//tid==null则是第一次上传任务，不是修改
			TaskDaoServiceImple tdsi = new TaskDaoServiceImple();
			task.setTstart(new Date());
			if(file==null){//如果没有上传文件
				task.setTaffix(null);
			}else{
				task.setTaffix(outFileName);
			}
			
			tdsi.addTask(task);
		}else{//否则就是修改任务请求
			TaskDaoServiceImple tdsi = new TaskDaoServiceImple();
			Task tt= tdsi.getTaskById(task.getTid());
			if(tt.getTaffix()!=null){
				UploadUtil.adminDeleteOldFile(tt.getTaffix());
			}
			if(file==null){//如果没有上传文件
				task.setTaffix(null);
			}else{
				task.setTaffix(outFileName);
			}
			task.setTstart(tt.getTstart());
			tdsi.ModifyTask(task);
		}
		
		return SUCCESS;
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


	public Task getTask() {
		return task;
	}


	public void setTask(Task task) {
		this.task = task;
	}
	
}
