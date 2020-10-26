package org.task.ngst.gyb.test;


import java.util.List;

import org.junit.Test;
import org.task.ngst.gyb.dao.UserDao;
import org.task.ngst.gyb.dao.imple.UserDaoImple;
import org.task.ngst.gyb.entity.User;

public class UserTester {
	@Test
	public void TestUserAdd(){
		UserDao ud = new UserDaoImple();
		User u = new User(1415925611, "耿远博", "admin123", 20,"f", "云计算4班", 14, 0,"277478869","2774788692qq.com","15503772958","你最喜欢啥？","你");
		ud.insertUser(u);
	}
	@Test
	public void TestQueryAllUser(){
		UserDao ud = new UserDaoImple();
		List<User> list = null;
		list  = ud.queryAllUser();
		for (User user : list) {
			System.out.println(user);
		}
	}
	@Test
	public void TestQueryUserById(){
		UserDao ud = new UserDaoImple();
		User u = ud.queryUserById(1415925611);
		System.out.println(u);
	}
	@Test
	public void TestQueryUserByName(){
		UserDao ud = new UserDaoImple();
		List<User> list = null;
		list  = ud.queryUserByName("耿远博");
		for (User user : list) {
			System.out.println(user);
		}
	}
	@Test
	public void TestQueryUserByClass(){
		UserDao ud = new UserDaoImple();
		List<User> list = null;
		list  = ud.queryUserByClass("云计算4班");
		if(list == null)return;
		for (User user : list) {
			System.out.println(user);
		}
	}
	@Test
	public void TestQueryUserByGrade(){
		UserDao ud = new UserDaoImple();
		List<User> list = null;
		list  = ud.queryUserByGrade(12);
		//if(list == null)return;
		for (User user : list) {
			System.out.println(user);
		}
	}
	@Test
	public void TestQueryUserByCategory(){
		UserDao ud = new UserDaoImple();
		List<User> list = null;
		list  = ud.queryUserByCategory(2);
		//if(list == null)return;
		for (User user : list) {
			System.out.println(user);
		}
	}
	@Test
	public void TestQueryUserBySex(){
		UserDao ud = new UserDaoImple();
		List<User> list = null;
		list  = ud.queryUserBySex("");
		
		for (User user : list) {
			System.out.println(user);
		}
	}
	@Test
	public void TestUpdateUser(){
		UserDao ud = new UserDaoImple();
		ud.updateUser(new User(1415925611, "耿远博", "admin123", 20,"f", "云计算4班", 14, 0,"277478869","277478869@qq.com","15503772958","你最喜欢啥？","你"));
		
	}
	@Test
	public void TestDeleteUser(){
		UserDao ud = new UserDaoImple();
		ud.deleteUser(1415925610);
	}
	
}
