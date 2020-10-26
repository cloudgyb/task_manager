package org.task.ngst.gyb.dao;

import java.util.List;

import org.task.ngst.gyb.entity.UserTaskStatus;

public interface UserTaskStatusDao {
	List<UserTaskStatus> 	queryTaskStatusBySuid(Integer suid);//按用户id查询任务状态（不分是否完成）
	List<UserTaskStatus> 	queryTaskStatusBySuidIsOk(Integer suid);//查询对应ID用户的所有以完成的任务
	List<UserTaskStatus> 	queryTaskStatusBySuidIsNo(Integer suid);//查询对应ID用户的所有未完成的任务
	
	List<UserTaskStatus> 	queryTaskStatusByStid(Integer stid);//按任务id查询任务状态（不分是否完成）
	List<UserTaskStatus> 	queryTaskStatusByStidIsOk(Integer stid);//查询对应Id任务的以完成的任务状态
	List<UserTaskStatus> 	queryTaskStatusByStidIsNo(Integer stid);//查询对应Id任务的未完成的任务状态
	
	
	UserTaskStatus 			queryTaskStatusBySuidAndStid(Integer suid,Integer stid);//按用户id任务id查询唯一对应的任务状态
	void 					updateTaskStatus(UserTaskStatus uts); //更新任务状态
	void 					deleteTaskStatus(Integer suid,Integer stid);//删除任务状态（一般用不到）
	void					insertTaskStatus(UserTaskStatus uts);//插入新的任务状态（一般用不到，只在数据库出现异常时：如不能自动同步数据库，由管理员调用）
}
