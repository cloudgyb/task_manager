package org.task.ngst.gyb.test;

import java.util.List;

import org.junit.Test;
import org.task.ngst.gyb.dao.imple.GradeItemDaoImpl;
import org.task.ngst.gyb.entity.GradeItem;
import org.task.ngst.gyb.service.imple.GradeItemDaoServiceImpl;

public class GradeItemTest {
	@Test
	public void gradeItemDaoTest(){
		GradeItemDaoImpl gradeItemDaoImpl = new GradeItemDaoImpl();
		List<GradeItem> list = gradeItemDaoImpl.getGradeItemsByTid(1);
		for (GradeItem gradeItem : list) {
			System.out.println(gradeItem);
		}
	}
	@Test
	public void gradeItemServiceTest(){
		GradeItemDaoServiceImpl gids = new GradeItemDaoServiceImpl();
		List<GradeItem> gradeItemsByTid = gids.getGradeItemsByTid(1);
		for (GradeItem gradeItem : gradeItemsByTid) {
			System.out.println(gradeItem);
		}
	}
}
