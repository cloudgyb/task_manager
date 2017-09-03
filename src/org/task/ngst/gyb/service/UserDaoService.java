package org.task.ngst.gyb.service;

import java.util.List;

import org.task.ngst.gyb.entity.User;

public interface UserDaoService {
	void 	   	addUser(User u);
	void 	  	modifyUser(User u);
	void 	   	deleteUser(Integer id);
	User 	   	getUserById(Integer uid);
	List<User> 	getUserByName(String name);
	List<User> 	getUserByClass(String uclass);//按 班级 获取用户
	List<User> 	getryUserByGrade(Integer ugrade);//按 级别 获取用户
	List<User> 	getUserByCategory(Integer ucategory);//按 类别 获取用户
	List<User> 	getUserBySex(String usex);//按 性别 获取用户
	List<User> 	getAllUser(); //获取所有用户
	
}
