package org.task.ngst.gyb.dao;

import java.util.List;

import org.task.ngst.gyb.entity.GradeItem;

public interface GradeItemDao {
	List<GradeItem> getGradeItemsByTid(Integer tid);
}
