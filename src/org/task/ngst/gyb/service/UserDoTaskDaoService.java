package org.task.ngst.gyb.service;

import java.util.List;

import org.task.ngst.gyb.entity.UserDoneTask;
import org.task.ngst.gyb.entity.UserUndoneTask;

public interface UserDoTaskDaoService {
	List<UserUndoneTask> 	getUndoneTaskByUid(Integer uid);
	List<UserDoneTask> 		getDoneTaskByUid(Integer uid);
}
