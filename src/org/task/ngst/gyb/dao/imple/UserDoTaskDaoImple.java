package org.task.ngst.gyb.dao.imple;

import java.util.ArrayList;
import java.util.List;

import org.task.ngst.gyb.dao.TaskDao;
import org.task.ngst.gyb.dao.UserDao;
import org.task.ngst.gyb.dao.UserDoTaskDao;
import org.task.ngst.gyb.dao.UserTaskStatusDao;
import org.task.ngst.gyb.entity.Task;
import org.task.ngst.gyb.entity.User;
import org.task.ngst.gyb.entity.UserDoneTask;
import org.task.ngst.gyb.entity.UserTaskStatus;
import org.task.ngst.gyb.entity.UserUndoneTask;

public class UserDoTaskDaoImple implements UserDoTaskDao{

	@Override
	public List<UserUndoneTask> queryUndoneTaskByUid(Integer uid) {
		// TODO Auto-generated method stub
		UserTaskStatusDao utsd = new UserTaskStatusDaoImple();
		TaskDao td = new TaskDaoImple();
		UserDao ud = new UserDaoImple();
		List<UserUndoneTask> uutlist = new ArrayList<UserUndoneTask>();
		List<UserTaskStatus> tlist= utsd.queryTaskStatusBySuidIsNo(uid);
		
		for (UserTaskStatus l : tlist) {
			Task t = td.queryTaskById(l.getStid());
			User u = ud.queryUserById(t.getTuid());
			uutlist.add(new UserUndoneTask(l.getStid(), t.getTname(), u.getUname(), t.getTstart(), t.getTend()) );
		}
		return uutlist;
	}

	@Override
	public List<UserDoneTask> queryDoneTaskByUid(Integer uid) {
		// TODO Auto-generated method stub
		UserTaskStatusDao utsd = new UserTaskStatusDaoImple();
		TaskDao td = new TaskDaoImple();
		UserDao ud = new UserDaoImple();
		List<UserDoneTask> uutlist = new ArrayList<UserDoneTask>();
		List<UserTaskStatus> tlist= utsd.queryTaskStatusBySuidIsOk(uid);
		for (UserTaskStatus l : tlist) {
			Task t = td.queryTaskById(l.getStid());
			User u = ud.queryUserById(t.getTuid());
			uutlist.add(new UserDoneTask(l.getStid(), t.getTname(), u.getUname(), t.getTstart(), t.getTend(),l.getDoneDate()) );
		}
		return uutlist;
	}

}
