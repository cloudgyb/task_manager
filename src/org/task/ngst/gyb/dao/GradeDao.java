package org.task.ngst.gyb.dao;

import java.util.List;

import org.task.ngst.gyb.entity.Grade;
import org.task.ngst.gyb.entity.UserGrade;

public interface GradeDao {
	//update table
	void 			insertGrade(Grade g);//插入成绩
	void			syncGrade(Grade g);
	void 			updateGrade(Grade g);//更新成绩
	void 			deleteGrade(Integer guid,Integer gtid); //删除成绩
	//query
	List<Grade> 	queryGradeByGuid(Integer guid); //按用户id查询成绩
	List<Grade> 	queryGradeByGuidOrderByScore(Integer guid); //按用户id查询成绩并按成绩降序排序
	
	List<Grade> 	queryGradeByGtid(Integer gtid);//按任务id查询成绩
	List<Grade> 	queryGradeByGtidOrderByScore(Integer gtid); //按任务id查询成绩并按成绩降序排序
	
	Grade 			queryGradeByGuidAndGtid(Integer guid,Integer gtid);//按用户id和任务id查询成绩
	List<UserGrade> queryUserGradeByGuid(Integer guid);
	
}
