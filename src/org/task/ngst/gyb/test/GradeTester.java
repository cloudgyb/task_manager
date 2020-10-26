package org.task.ngst.gyb.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.task.ngst.gyb.dao.GradeDao;
import org.task.ngst.gyb.dao.imple.GradeDaoImple;
import org.task.ngst.gyb.entity.Grade;

public class GradeTester {
	private static GradeDao gd = null;
	static{
		gd = new GradeDaoImple();
	}
	@Test
	public void TestInsertGrade(){
		Grade g= new Grade(1515925521,9,1415925613,new Date(), (float)80.5);
		gd.insertGrade(g);
	}
	@Test
	public void TestUpdatetGrade(){
		Grade g= new Grade(1515925521,9,1415925613,new Date(), (float)90.5);
		gd.updateGrade(g);
	}
	@Test
	public void TestQueryGradeByGuid(){
		List<Grade> list= gd.queryGradeByGuid(1515925521);
		for (Grade grade : list) {
			System.out.println(grade);
		}
	}
	@Test
	public void TestQueryGradeByGuidOrderScore(){
		List<Grade> list= gd.queryGradeByGuidOrderByScore(1515925521);
		for (Grade grade : list) {
			System.out.println(grade);
		}
	}
	@Test
	public void TestQueryGradeByGtid(){
		List<Grade> list= gd.queryGradeByGtid(9);
		for (Grade grade : list) {
			System.out.println(grade);
		}
	}
	@Test
	public void TestQueryGradeByGtidOrderByscore(){
		List<Grade> list= gd.queryGradeByGtidOrderByScore(9);
		for (Grade grade : list) {
			System.out.println(grade);
		}
	}
	@Test
	public void TestQueryGradeByGuidAndGtid(){
		Grade g = null;
		g= gd.queryGradeByGuidAndGtid(1515925521, 9);
		System.out.println(g);
	}
	@Test
	public void TestDeleteGrade(){
		gd.deleteGrade(1515925521, 9);
	}
}
