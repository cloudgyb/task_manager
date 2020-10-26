package org.task.ngst.gyb.service;

import java.util.List;

import org.task.ngst.gyb.entity.marktask.NotyetMarkTaskItem;

public interface MarkTaskDaoService {
	List<NotyetMarkTaskItem> getNotyetmarkTaskByTid(Integer tid);
}
