package org.task.ngst.gyb.dao;

import java.util.List;

import org.task.ngst.gyb.entity.marktask.NotyetMarkTaskItem;

/**
 * 管理员批改任务相关接口，
 * 例如：查询管理员上传任务对应的未批改任务
 * 	根据任务发布者和任务ID查询未批改任务
 * 
 * @author 耿远博
 *
 */
public interface MarkTaskDao {
	//根据任务发布者和任务ID查询未批改任务
	List<NotyetMarkTaskItem> queryNotyetMarkTaskByTid(Integer tid);
}
