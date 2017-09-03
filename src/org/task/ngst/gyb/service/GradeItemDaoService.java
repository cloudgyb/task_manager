package org.task.ngst.gyb.service;

import java.util.List;

import org.task.ngst.gyb.entity.GradeItem;

public interface GradeItemDaoService {
	List<GradeItem> getGradeItemsByTid(Integer tid);
}
