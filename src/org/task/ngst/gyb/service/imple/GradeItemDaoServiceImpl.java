package org.task.ngst.gyb.service.imple;

import java.util.List;

import org.task.ngst.gyb.dao.GradeItemDao;
import org.task.ngst.gyb.dao.imple.GradeItemDaoImpl;
import org.task.ngst.gyb.entity.GradeItem;
import org.task.ngst.gyb.service.GradeItemDaoService;

public class GradeItemDaoServiceImpl implements GradeItemDaoService{
	private static GradeItemDao gid;
	static{
		gid = new GradeItemDaoImpl();
	}
	@Override
	public List<GradeItem> getGradeItemsByTid(Integer tid) {
		return gid.getGradeItemsByTid(tid);
	}

}
