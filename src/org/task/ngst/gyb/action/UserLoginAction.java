package org.task.ngst.gyb.action;

import org.apache.struts2.json.annotations.JSON;
import org.task.ngst.gyb.entity.User;
import org.task.ngst.gyb.service.UserDaoService;
import org.task.ngst.gyb.service.imple.UserDaoServiceImple;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserLoginAction extends ActionSupport{
	/**
	 * 所有用户登录的Action，包括管理员、普通用户
	 * 这个Action最终返回json格式的登陆结果数据，包括用户登录结果描述信息、状态码
	 * 前台可以根据返回的结果，做出相应的处理
	 * @author 耿远博
	 * 2017/7/29
	 * version 2.0
	 */
	private static final long serialVersionUID = 1L;
	private 	String 		uid;
	private 	String 		upasswd;
	private 	String 		ucategory;//0社团人员，1管理员，2维护人员
	//登陆反馈信息,只提供getter不提供setter（安全）
	private 	String 		loginResultMess;
	private		int			loginResultCode;
	/**
	 * 需要说明的是下面的return SUCCESS,只是代表程序处理完成了，不代表用户登录成功了。
	 * @return Json 返回Json格式的数据，用户登录的结果信息
	 * 
	 */
	@Override
	public String execute() throws Exception {
		//防止异常产生(如果用户非法访问)
		if(uid==null||upasswd==null||ucategory==null){
			loginResultCode = -3;
			return "login";//退出程序，转到login(此处login是全局返回结果)
		}
		UserDaoService uds = new UserDaoServiceImple();
		User user = uds.getUserById(Integer.parseInt(uid));//读取数据库信息
		if(user==null||user.getUcategory()!=Integer.parseInt(ucategory)){//验证用户是否存在
			loginResultMess = "此用户不存在！";
			loginResultCode = -2;
			return SUCCESS;
		}else{//用户存在
			if(!user.getUpasswd().equals(upasswd)){//比对密码
				loginResultMess = "账户或密码错误！";
				loginResultCode = -1;
				return SUCCESS;
			}else{//登录成功
				//将用户信息放入到session中
				ActionContext.getContext().getSession().
								put("task_user", user);
				loginResultMess = "登陆成功！";
				if(user.getUcategory()==0){
					loginResultCode = 0;
					return SUCCESS;
				}
				else if(user.getUcategory()==1){
					loginResultCode = 1;
					return SUCCESS;
				}
				else if(user.getUcategory()==2){
					loginResultCode = 2;
					return SUCCESS;
				}
			}
		}
		return SUCCESS;
	}
	
	//getter And setter
	@JSON(serialize=false)
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	@JSON(serialize=false)
	public String getUpasswd() {
		return upasswd;
	}
	public void setUpasswd(String upasswd) {
		this.upasswd = upasswd;
	}
	@JSON(serialize=false)
	public String getUcategory() {
		return ucategory;
	}
	public void setUcategory(String ucategory) {
		this.ucategory = ucategory;
	}
	@JSON(name="mess")
	public String getLoginResultMess() {
		return loginResultMess;
	}

	@JSON(name="code")
	public int getLoginResultCode() {
		return loginResultCode;
	}
}
