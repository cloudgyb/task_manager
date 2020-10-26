package org.task.ngst.gyb.service.imple;

import java.util.List;

import org.task.ngst.gyb.dao.UserTaskStatusDao;
import org.task.ngst.gyb.dao.imple.UserTaskStatusDaoImple;
import org.task.ngst.gyb.entity.UserTaskStatus;
import org.task.ngst.gyb.service.UserTaskStatusDaoService;

public class UserTaskStatusDaoServiceImple implements UserTaskStatusDaoService{
	private static UserTaskStatusDao utsd = null;
	static{
		utsd = new UserTaskStatusDaoImple();
	}
	
	@Override
	public List<UserTaskStatus> getTaskStatusBySuid(Integer suid) {
		// TODO Auto-generated method stub
		return utsd.queryTaskStatusBySuid(suid);
	}

	@Override
	public List<UserTaskStatus> getTaskStatusBySuidIsOk(Integer suid) {
		// TODO Auto-generated method stub
		return utsd.queryTaskStatusBySuidIsOk(suid);
	}

	@Override
	public List<UserTaskStatus> getTaskStatusBySuidIsNo(Integer suid) {
		// TODO Auto-generated method stub
		return utsd.queryTaskStatusBySuidIsNo(suid);
	}

	@Override
	public List<UserTaskStatus> getTaskStatusByStid(Integer stid) {
		// TODO Auto-generated method stub
		return utsd.queryTaskStatusByStid(stid);
	}

	@Override
	public List<UserTaskStatus> getTaskStatusByStidIsOk(Integer stid) {
		// TODO Auto-generated method stub
		return utsd.queryTaskStatusByStidIsOk(stid);
	}

	@Override
	public List<UserTaskStatus> getTaskStatusByStidIsNo(Integer stid) {
		// TODO Auto-generated method stub
		return utsd.queryTaskStatusByStidIsNo(stid);
	}

	@Override
	public UserTaskStatus getTaskStatusBySuidAndStid(Integer suid, Integer stid) {
		// TODO Auto-generated method stub
		return utsd.queryTaskStatusBySuidAndStid(suid, stid);
	}

	@Override
	public void modifyTaskStatus(UserTaskStatus uts) {
		// TODO Auto-generated method stub
		utsd.updateTaskStatus(uts);
	}

	@Override
	public void deleteTaskStatus(Integer suid, Integer stid) {
		// TODO Auto-generated method stub
		utsd.deleteTaskStatus(suid, stid);
	}

	@Override
	public void addTaskStatus(UserTaskStatus uts) {
		// TODO Auto-generated method stub
		utsd.insertTaskStatus(uts);
	}
	
	
}
