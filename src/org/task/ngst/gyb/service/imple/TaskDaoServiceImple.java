package org.task.ngst.gyb.service.imple;

import java.sql.Date;
import java.util.List;

import org.task.ngst.gyb.dao.TaskDao;
import org.task.ngst.gyb.dao.imple.TaskDaoImple;
import org.task.ngst.gyb.entity.Task;
import org.task.ngst.gyb.service.TaskDaoService;

public class TaskDaoServiceImple implements TaskDaoService{
	private static TaskDao td = null;
	static{
		td = new TaskDaoImple();
	}
	@Override
	public void addTask(Task t) {
		// TODO Auto-generated method stub
		td.insertTask(t);
	}

	@Override
	public Task getTaskById(Integer tid) {
		// TODO Auto-generated method stub
		return td.queryTaskById(tid);
	}

	@Override
	public List<Task> getTaskByTname(String tname) {
		// TODO Auto-generated method stub
		return td.queryTaskByTname(tname);
	}

	@Override
	public List<Task> getTaskByTstart(Date d) {
		// TODO Auto-generated method stub
		return td.queryTaskByTstart(d);
	}

	@Override
	public List<Task> getTaskByTend(Date d) {
		// TODO Auto-generated method stub
		return td.queryTaskByTend(d);
	}

	@Override
	public List<Task> getTaskByTuid(Integer tuid) {
		// TODO Auto-generated method stub
		return td.queryTaskByTuid(tuid);
	}

	@Override
	public List<Task> getTaskByTScope(Integer tscope) {
		// TODO Auto-generated method stub
		return td.queryTaskByTScope(tscope);
	}

	@Override
	public void ModifyTask(Task t) {
		// TODO Auto-generated method stub
		td.updateTask(t);
	}

	@Override
	public void deleteTask(Integer tid) {
		// TODO Auto-generated method stub
		td.deleteTask(tid);
	}
	
}
