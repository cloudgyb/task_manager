package org.task.ngst.gyb.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.task.ngst.gyb.entity.marktask.NotyetMarkTaskItem;
import org.task.ngst.gyb.service.imple.MarkTaskDaoServiceImple;

public class MarkTaskTester {
	MarkTaskDaoServiceImple mdsi;
	@Before
	public void init(){
		mdsi = new MarkTaskDaoServiceImple();
	}
	
	@Test
	public void getNotyetMarkTaskItemTest(){
		List<NotyetMarkTaskItem> list = mdsi.getNotyetmarkTaskByTid(1);
		for (NotyetMarkTaskItem notyetMarkTaskItem : list) {
			System.out.println(notyetMarkTaskItem);
		}
	}
}
