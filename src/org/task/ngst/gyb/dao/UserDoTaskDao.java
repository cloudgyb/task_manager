package org.task.ngst.gyb.dao;

import java.util.List;

import org.task.ngst.gyb.entity.UserDoneTask;
import org.task.ngst.gyb.entity.UserUndoneTask;

public interface UserDoTaskDao {
	List<UserUndoneTask> queryUndoneTaskByUid(Integer uid);
	List<UserDoneTask> queryDoneTaskByUid(Integer uid);
}
