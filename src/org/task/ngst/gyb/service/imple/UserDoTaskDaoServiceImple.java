package org.task.ngst.gyb.service.imple;

import java.util.List;

import org.task.ngst.gyb.dao.UserDoTaskDao;
import org.task.ngst.gyb.dao.imple.UserDoTaskDaoImple;
import org.task.ngst.gyb.entity.UserDoneTask;
import org.task.ngst.gyb.entity.UserUndoneTask;
import org.task.ngst.gyb.service.UserDoTaskDaoService;

public class UserDoTaskDaoServiceImple implements UserDoTaskDaoService{

	private static UserDoTaskDao udtd = null;
	static{
		udtd = new UserDoTaskDaoImple();
	}
	@Override
	public List<UserUndoneTask> getUndoneTaskByUid(Integer uid) {
		// TODO Auto-generated method stub
		return udtd.queryUndoneTaskByUid(uid);
	}

	@Override
	public List<UserDoneTask> getDoneTaskByUid(Integer uid) {
		// TODO Auto-generated method stub
		return udtd.queryDoneTaskByUid(uid);
	}
	
}
