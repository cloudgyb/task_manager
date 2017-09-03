package org.task.ngst.gyb.action;

import org.task.ngst.gyb.entity.User;
import org.task.ngst.gyb.service.UserDaoService;
import org.task.ngst.gyb.service.imple.UserDaoServiceImple;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Deprecated
public class LoginAction extends ActionSupport{
	/**
	 *	用户登录Action
	 *	包括所有用户的登陆（普通用户、管理员）
	 *	@author 耿远博
	 *	version 1.0
	 */
	private static final long serialVersionUID = 1L;
	private 	String 		uid;
	private 	String 		upasswd;
	private 	String 		ucategory;
	@Override
	public String execute() throws Exception {
		//防止异常产生(如果用户非法访问)
		if(uid==null||upasswd==null||ucategory==null){
			return ERROR;//退出程序，转到login
		}
		UserDaoService uds = new UserDaoServiceImple();
		User user = uds.getUserById(Integer.parseInt(uid));//读取数据库信息
		if(user==null||user.getUcategory()!=Integer.parseInt(ucategory)){//验证用户是否存在
			this.addFieldError("loginMess", "此用户不存在！");
			return ERROR;
		}else{//用户存在
			if(!user.getUpasswd().equals(upasswd)){//比对密码
				this.addFieldError("loginMess", "密码或账户错误！");
				return ERROR;
			}else{//登录成功
				//将用户信息放入到session中
				ActionContext.getContext().getSession().
								put("task_user", user);
				//HttpServletRequest	request =  (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
				//request.getSession().setMaxInactiveInterval(1800);//设置session有效市时长
				if(user.getUcategory()==0)
					return "memberindex";
				else if(user.getUcategory()==1)
					return "adminindex";
				else if(user.getUcategory()==2)
					return "suppindex";
			}
		}
		return SUCCESS;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpasswd() {
		return upasswd;
	}
	public void setUpasswd(String upasswd) {
		this.upasswd = upasswd;
	}
	public String getUcategory() {
		return ucategory;
	}
	public void setUcategory(String ucategory) {
		this.ucategory = ucategory;
	}
 
}
