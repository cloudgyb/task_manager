package org.task.ngst.gyb.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.task.ngst.gyb.dao.imple.UserTaskStatusDaoImple;
import org.task.ngst.gyb.entity.UserTaskStatus;
//ctrl+2,L
public class UserTaskStatusTester {
	private static UserTaskStatusDaoImple utsd = null;
	static{
		utsd = new UserTaskStatusDaoImple();
	}
	@Test
	public void TestQueryTaskStatusBySuid(){
	   List<UserTaskStatus> list=	utsd.queryTaskStatusBySuid(1515925521);
	   for (UserTaskStatus userTaskStatus : list) {
		System.out.println(userTaskStatus);
	   }
	}
	@Test
	public void TestQueryTaskStatusBySuidIsOk(){
	   List<UserTaskStatus> list=	utsd.queryTaskStatusBySuidIsOk(1515925521);
	   for (UserTaskStatus userTaskStatus : list) {
		System.out.println(userTaskStatus);
	   }
	}
	@Test
	public void TestQueryTaskStatusBySuidIsNo(){
	   List<UserTaskStatus> list=	utsd.queryTaskStatusBySuidIsNo(1515925521);
	   for (UserTaskStatus userTaskStatus : list) {
		System.out.println(userTaskStatus);
	   }
	}
	
	@Test
	public void TestQueryTaskStatusByStid(){
		 List<UserTaskStatus> list=	utsd.queryTaskStatusByStid(9);
		   for (UserTaskStatus userTaskStatus : list) {
			System.out.println(userTaskStatus);
		   }
	}
	@Test
	public void TestQueryTaskStatusByStidIsOk(){
		 List<UserTaskStatus> list=	utsd.queryTaskStatusByStidIsOk(9);
		   for (UserTaskStatus userTaskStatus : list) {
			System.out.println(userTaskStatus);
		   }
	}
	@Test
	public void TestQueryTaskStatusByStidIsNo(){
		 List<UserTaskStatus> list=	utsd.queryTaskStatusByStidIsNo(9);
		   for (UserTaskStatus userTaskStatus : list) {
			System.out.println(userTaskStatus);
		   }
	}
	@Test
	 public void TestQueryTaskStatusBySuidAndStid(){
		UserTaskStatus uts = utsd.queryTaskStatusBySuidAndStid(1515925521, 9);
		System.out.println(uts);
	}
	@Test
	 public void TestUpdateTaskStatus(){
		UserTaskStatus uts = new UserTaskStatus(1515925521, 10, 1, new Date(), "hahhahahahahah", "hahahhahahah","D:\\test.doc");
		utsd.updateTaskStatus(uts);
		//org.apache.taglibs.standard.lang.jstl.Logger log = new org.apache.taglibs.standard.lang.jstl.Logger(pOut);
	}
}
