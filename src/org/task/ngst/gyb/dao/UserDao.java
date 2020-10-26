package org.task.ngst.gyb.dao;

import java.util.List;

import org.task.ngst.gyb.entity.User;

public interface UserDao{
	void 			insertUser(User u);  //插入新的用户
	//Query
	User 			queryUserById(Integer uid); //按id 查询用户
	List<User> 		queryUserByName(String uname);//按 姓名 查询用户
	List<User> 		queryUserByClass(String uclass);//按 班级 查询用户
	List<User> 		queryUserByGrade(Integer ugrade);//按 级别 查询用户
	List<User> 		queryUserByCategory(Integer ucategory);//按 类别 查询用户
	List<User> 		queryUserBySex(String usex);//按 性别 查询用户
	List<User> 		queryAllUser(); //查询所有用户
	//Update
	void 			updateUser(User u);//更新用户信息
	void 			deleteUser(Integer id);//删除用户
	
}
