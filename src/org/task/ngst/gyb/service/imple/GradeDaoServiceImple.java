package org.task.ngst.gyb.service.imple;

import java.util.List;

import org.task.ngst.gyb.dao.GradeDao;
import org.task.ngst.gyb.dao.imple.GradeDaoImple;
import org.task.ngst.gyb.entity.Grade;
import org.task.ngst.gyb.entity.UserGrade;
import org.task.ngst.gyb.service.GradeDaoService;

public class GradeDaoServiceImple implements GradeDaoService{

	private static GradeDao gd = null;
	static{
		gd = new GradeDaoImple();
	}
	
	@Override
	public void syncGrade(Grade g) {
		// TODO Auto-generated method stub
		gd.syncGrade(g);
	}
	
	@Override
	public void addGrade(Grade g) {
		// TODO Auto-generated method stub
		gd.insertGrade(g);
	}

	@Override
	public void modifyGrade(Grade g) {
		// TODO Auto-generated method stub
		gd.updateGrade(g);
	}

	@Override
	public void deleteGrade(Integer guid, Integer gtid) {
		// TODO Auto-generated method stub
		gd.deleteGrade(guid, gtid);
	}

	@Override
	public List<Grade> getGradeByGuid(Integer guid) {
		// TODO Auto-generated method stub
		return gd.queryGradeByGuid(guid);
	}

	@Override
	public List<Grade> getGradeByGuidOrderByScore(Integer guid) {
		// TODO Auto-generated method stub
		return gd.queryGradeByGuidOrderByScore(guid);
	}

	@Override
	public List<Grade> getGradeByGtid(Integer gtid) {
		// TODO Auto-generated method stub
		return gd.queryGradeByGtid(gtid);
	}

	@Override
	public List<Grade> getGradeByGtidOrderByScore(Integer gtid) {
		// TODO Auto-generated method stub
		return gd.queryGradeByGtidOrderByScore(gtid);
	}

	@Override
	public Grade getGradeByGuidAndGtid(Integer guid, Integer gtid) {
		// TODO Auto-generated method stub
		return gd.queryGradeByGuidAndGtid(guid, gtid);
	}

	@Override
	public List<UserGrade> getUserGradeByGuid(Integer guid) {
		// TODO Auto-generated method stub
		return gd.queryUserGradeByGuid(guid);
	}

}
