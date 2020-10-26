package org.task.ngst.gyb.service;

import java.sql.Date;
import java.util.List;

import org.task.ngst.gyb.entity.Task;

public interface TaskDaoService {
	void 		addTask(Task t);
	Task 		getTaskById(Integer tid);
	List<Task>	getTaskByTname(String tname);
	List<Task>  getTaskByTstart(Date d);
	List<Task>  getTaskByTend(Date d); 
	List<Task>  getTaskByTuid(Integer tuid);
	List<Task>  getTaskByTScope(Integer tscope);
	//update
	void 	    ModifyTask(Task t);
	void 		deleteTask(Integer tid);
}
