package org.task.ngst.gyb.dao;

import java.sql.Date;
import java.util.List;

import org.task.ngst.gyb.entity.Task;

public interface TaskDao {
	void 			insertTask(Task t);//插入新的任务
	//query
	Task 			queryTaskById(Integer tid);//按任务id查询任务
	List<Task> 		queryTaskByTname(String tname);//按任务名查询任务
	List<Task> 		queryTaskByTstart(Date d);//按任开始日期查询任务
	List<Task> 		queryTaskByTend(Date d); //按任务截止日期查询任务
	List<Task> 		queryTaskByTuid(Integer tuid);//按任务发布人id查询任务
	List<Task>		queryTaskByTScope(Integer tscope);//按任务适用范围查询任务
	//update
	void			updateTask(Task t);//更新任务信息
	void 			deleteTask(Integer tid);//删除任务
	
}
