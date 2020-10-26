package org.task.ngst.gyb.dao.imple;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.task.ngst.gyb.dao.GradeDao;
import org.task.ngst.gyb.dao.TaskDao;
import org.task.ngst.gyb.dao.UserDao;
import org.task.ngst.gyb.entity.Grade;
import org.task.ngst.gyb.entity.Task;
import org.task.ngst.gyb.entity.User;
import org.task.ngst.gyb.entity.UserGrade;
import org.task.ngst.gyb.util.JDBCUtil;

public class GradeDaoImple implements GradeDao{

	@Override
	public void syncGrade(Grade g) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "insert into grade(guid,gtid,score) value(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, g.getGuid());
			ps.setInt(2, g.getGtid());
			ps.setFloat(3, 0F);
			int n = ps.executeUpdate();
			if(n==1){
				System.out.println("Grade 同步成功！");
			}else{
				System.out.println("Grade 同步失败！");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			JDBCUtil.close(null, ps, conn);
		}
	}

	@Override
	public void insertGrade(Grade g) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "insert into grade(guid,gtid,dealuid,dealdate,score) value(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, g.getGuid());
			ps.setInt(2, g.getGtid());
			ps.setInt(3, g.getDealUid());
			ps.setDate(4, new Date( g.getDealDate().getTime()));
			ps.setFloat(5, g.getScore());
			int n = ps.executeUpdate();
			if(n==1){
				System.out.println("Grade 插入成功！");
			}else{
				System.out.println("Grade 插入失败！");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			JDBCUtil.close(null, ps, conn);
		}
	}

	@Override
	public void updateGrade(Grade g) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "update grade set dealuid=?,dealdate=?,score=? where guid=? and gtid=?";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, g.getDealUid());
			ps.setDate(2, new Date( g.getDealDate().getTime()));
			ps.setFloat(3, g.getScore());
			ps.setInt(4, g.getGuid());
			ps.setInt(5, g.getGtid());
			int n = ps.executeUpdate();
			if(n==1){
				System.out.println("Grade 更新成功！");
			}else{
				System.out.println("Grade 更新失败！");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			JDBCUtil.close(null, ps, conn);
		}
	}

	@Override
	public void deleteGrade(Integer guid,Integer gtid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "delete from grade where guid=? and gtid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, guid);
			ps.setInt(2, gtid);
			
			int n = ps.executeUpdate();
			if(n==1){
				System.out.println("Grade 删除成功！");
			}else{
				System.out.println("Grade 删除失败！");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			JDBCUtil.close(null, ps, conn);
		}
	}

	@Override
	public List<Grade> queryGradeByGuid(Integer guid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Grade> list = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "select gtid,dealuid,dealdate,score from grade where guid=? and dealuid is not null";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, guid);
			rs = ps.executeQuery();
			list = new ArrayList<Grade>();
			while(rs.next()){
				list.add(new Grade(guid,rs.getInt(1),rs.getInt(2),rs.getDate(3),rs.getFloat(4)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, conn);
		}
		return list;
	}

	@Override
	public List<Grade> queryGradeByGtid(Integer gtid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Grade> list = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "select guid,dealuid,dealdate,score from grade where gtid=?";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, gtid);
			rs = ps.executeQuery();
			list = new ArrayList<Grade>();
			while(rs.next()){
				list.add(new Grade(rs.getInt(1),gtid,rs.getInt(2),rs.getDate(3),rs.getFloat(4)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, conn);
		}
		return list;
	}

	@Override
	public Grade queryGradeByGuidAndGtid(Integer guid, Integer gtid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Grade g = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "select dealuid,dealdate,score from grade where guid=? and gtid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, guid);
			ps.setInt(2, gtid);
			rs = ps.executeQuery();
			if(rs.next()){
				g = new Grade(guid,gtid,rs.getInt(1),rs.getDate(2),rs.getFloat(3));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, conn);
		}
		return g;
	}

	@Override
	public List<Grade> queryGradeByGuidOrderByScore(Integer guid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Grade> list = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "select gtid,dealuid,dealdate,score from grade where guid=? order by score desc";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, guid);
			rs = ps.executeQuery();
			list = new ArrayList<Grade>();
			while(rs.next()){
				list.add(new Grade(guid,rs.getInt(1),rs.getInt(2),rs.getDate(3),rs.getFloat(4)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, conn);
		}
		return list;
	}

	@Override
	public List<Grade> queryGradeByGtidOrderByScore(Integer gtid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Grade> list = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "select guid,dealuid,dealdate,score from grade where gtid=? order by score desc";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, gtid);
			rs = ps.executeQuery();
			list = new ArrayList<Grade>();
			while(rs.next()){
				list.add(new Grade(rs.getInt(1),gtid,rs.getInt(2),rs.getDate(3),rs.getFloat(4)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, conn);
		}
		return list;
	}

	@Override
	public List<UserGrade> queryUserGradeByGuid(Integer guid) {
		/*private 	Integer 	tid;			//任务id
		private 	String 		tname;			//任务名
		private		Integer		dealUserId;		//成绩评定人id
		private 	String		dealUserName;	//成绩评定人姓名
		private 	Date		dealDate;		//成绩评定日期
		private 	Float		score;			//分数
*/		List<UserGrade> ugl = null;
		List<Grade> gl = this.queryGradeByGuid(guid);
		TaskDao td = new TaskDaoImple();
		UserDao ud = new UserDaoImple();
		if(gl!=null){
			ugl = new ArrayList<UserGrade>();
		}
		for (Grade grade : gl) {
			Task t = td.queryTaskById(grade.getGtid());
			User u = ud.queryUserById(grade.getDealUid());
			ugl.add(new UserGrade(grade.getGtid(), t.getTname(), grade.getDealUid(), u.getUname(), grade.getDealDate(), grade.getScore()));
		}
		return ugl;
	}
	
}
