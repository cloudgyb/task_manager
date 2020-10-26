package org.task.ngst.gyb.service;

import java.util.List;

import org.task.ngst.gyb.entity.Grade;
import org.task.ngst.gyb.entity.UserGrade;

public interface GradeDaoService {
	void 			addGrade(Grade g);//添加成绩
	void 			syncGrade(Grade g); //当用户提交任务后，将tid，uid插入成绩表
	void 			modifyGrade(Grade g);//修改成绩
	void 			deleteGrade(Integer guid,Integer gtid); //删除成绩
	//query
	List<Grade> 	getGradeByGuid(Integer guid); //按用户id获取成绩
	List<Grade> 	getGradeByGuidOrderByScore(Integer guid); //按用户id获取成绩并按成绩降序排序
	
	List<Grade> 	getGradeByGtid(Integer gtid);//按任务id获取成绩
	List<Grade> 	getGradeByGtidOrderByScore(Integer gtid); //按任务id获取成绩并按成绩降序排序
	
	Grade 			getGradeByGuidAndGtid(Integer guid,Integer gtid);//按用户id和任务id获取成绩
	List<UserGrade> getUserGradeByGuid(Integer guid);
}
