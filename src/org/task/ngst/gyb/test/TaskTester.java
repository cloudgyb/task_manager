package org.task.ngst.gyb.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.task.ngst.gyb.dao.TaskDao;
import org.task.ngst.gyb.dao.imple.TaskDaoImple;
import org.task.ngst.gyb.entity.Task;

public class TaskTester {
	@Test
	public void TestInsertTask(){
		TaskDao td = new TaskDaoImple();
		SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
		String s= "2016-12-06"; 
		Date date;
		try {
			date = formatter.parse(s);
			Task t = new Task(1,"t4", formatter.parse("2016-11-12"), date, 1415925613, 15, "task 3", "D:\\bbb.doc");
			td.insertTask(t);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void TestQueryTaskByTid(){
		TaskDao td = new TaskDaoImple();
		Task t= td.queryTaskById(8);
		System.out.println(t);
	}
	@Test
	public void TestQueryTaskByTName(){
		TaskDao td = new TaskDaoImple();
		List<Task> tlist= td.queryTaskByTname("t2");
		for (Task task : tlist) {
			System.out.println(task);
		}
	}
	@Test
	public void TestQueryTaskByTstart(){
		TaskDao td = new TaskDaoImple();
		SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
		String s= "2016-12-06"; 
		Date date;
		try {
			date = formatter.parse(s);
			
			List<Task> l = null;
			l = td.queryTaskByTstart(new java.sql.Date(date.getTime()));
			for (Task task : l) {
				System.out.println(task);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void TestQueryTaskByTend(){
		TaskDao td = new TaskDaoImple();
		SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
		String s= "2016-12-09"; 
		Date date;
		try {
			date = formatter.parse(s);
			
			List<Task> l = null;
			l = td.queryTaskByTend(new java.sql.Date(date.getTime()));
			for (Task task : l) {
				System.out.println(task);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void TestQueryTaskByTuid(){
		TaskDao td = new TaskDaoImple();
			List<Task> l = null;
			l = td.queryTaskByTuid(1415925613);
			for (Task task : l) {
				System.out.println(task);
			}
	}
	@Test
	public void TestQueryTaskByTScope(){
		TaskDao td = new TaskDaoImple();
			List<Task> l = null;
			l = td.queryTaskByTScope(15);
			for (Task task : l) {
				System.out.println(task);
			}
	}
	@Test
	public void TestUpdateTask(){
		TaskDao td = new TaskDaoImple();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			td.updateTask(new Task(9, "task3", new Date(), sdf.parse("2017-01-01"), 1415925613,15, "task tttt", "E:\\qqq"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void TestDeleteTask(){
		TaskDao td = new TaskDaoImple();
		
		td.deleteTask(8);
		
	}
}
