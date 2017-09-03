package org.task.ngst.gyb.service.imple;

import java.util.List;

import org.task.ngst.gyb.dao.MarkTaskDao;
import org.task.ngst.gyb.dao.imple.MarkTaskDaoImple;
import org.task.ngst.gyb.entity.marktask.NotyetMarkTaskItem;
import org.task.ngst.gyb.service.MarkTaskDaoService;

public class MarkTaskDaoServiceImple implements MarkTaskDaoService{
	private static MarkTaskDao mtd;
	static{
		mtd = new MarkTaskDaoImple();
	}
	@Override
	public List<NotyetMarkTaskItem> getNotyetmarkTaskByTid(Integer tid) {
		// TODO Auto-generated method stub
		return mtd.queryNotyetMarkTaskByTid(tid);
	}

}
