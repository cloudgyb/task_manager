package org.task.ngst.gyb.dao.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.task.ngst.gyb.dao.TaskDao;
import org.task.ngst.gyb.entity.Task;
import org.task.ngst.gyb.util.JDBCUtil;

public class TaskDaoImple implements TaskDao{

	@Override
	public void insertTask(Task t) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtil.getConn();
			//tid 自动增长，字段不需要在插入中注明
			String sql = "insert into task(tname,tstart,tend,tuid,tscope,tdesc,taffix) value(?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, t.getTname());
			ps.setDate(2, new Date(t.getTstart().getTime()));
			ps.setDate(3, new Date(t.getTend().getTime()));
			ps.setInt(4, t.getTuid());
			ps.setInt(5, t.getTscope());
			ps.setString(6,t.getTdesc());
			ps.setString(7,t.getTaffix());
			int n = ps.executeUpdate();
			if(n==1){
				System.out.println("任务插入成功！");
			}else{
				System.out.println("任务插入失败！");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.close(null, ps, conn);
		}
	}
	// select t.tid,t.tname,t.tstart,t.tend,u.uid,u.uname from task t,users u
	// where t.tuid=u.uid;
	@Override
	public Task queryTaskById(Integer tid) {
		// TODO Auto-generated method stub
		Task t = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "select tid,tname,tstart,tend,tuid,tscope,tdesc,taffix from task where tid=?";
			ps= conn.prepareStatement(sql);
			ps.setInt(1, tid);
			rs = ps.executeQuery();
			if(rs.next()){
				t = new Task(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getDate(4),rs.getInt(5),rs.getInt(6),rs.getString(7),rs.getString(8));
			}else{
				System.out.println("无此任务！");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public List<Task> queryTaskByTname(String tname) {
		// TODO Auto-generated method stub
		List<Task> tlist = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "select tid,tstart,tend,tuid,tscope,tdesc,taffix from task where tname=?";
			ps= conn.prepareStatement(sql);
			ps.setString(1, tname);
			rs = ps.executeQuery();
			tlist = new ArrayList<Task>();
			while(rs.next()){
				 tlist.add(new Task(rs.getInt(1),tname,rs.getDate(2),rs.getDate(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getString(7)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tlist;
	}

	@Override
	public List<Task> queryTaskByTstart(Date d) {
		// TODO Auto-generated method stub
		List<Task> tlist = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "select tid,tname,tend,tuid,tscope,tdesc,taffix from task  where tstart=?";
			ps= conn.prepareStatement(sql);
			ps.setDate(1, d);
			rs = ps.executeQuery();
			tlist = new ArrayList<Task>();
			while(rs.next()){
				 tlist.add(new Task(rs.getInt(1),rs.getString(2),d,rs.getDate(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getString(7)));
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
			JDBCUtil.close(rs, ps, conn);
		}
		return tlist;
	}

	@Override
	public List<Task> queryTaskByTend(Date d) {
		// TODO Auto-generated method stub
		List<Task> tlist = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "select tid,tname,tstart,tuid,tscope,tdesc,taffix from task where tend=?";
			ps= conn.prepareStatement(sql);
			ps.setDate(1, d);
			rs = ps.executeQuery();
			tlist = new ArrayList<Task>();
			while(rs.next()){
				 tlist.add(new Task(rs.getInt(1),rs.getString(2),rs.getDate(3),d,rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getString(7)));
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
			JDBCUtil.close(rs, ps, conn);
		}
		return tlist;
	}

	@Override
	public List<Task> queryTaskByTuid(Integer tuid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Task> tlist = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "select tid,tname,tstart,tend,tscope,tdesc,taffix from task where tuid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, tuid);
			rs = ps.executeQuery();
			tlist = new ArrayList<Task>();
			while(rs.next()){
				tlist.add(new Task(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getDate(4),tuid,rs.getInt(5),rs.getString(6),rs.getString(7)));
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
			JDBCUtil.close(rs, ps, conn);
		}
		return tlist;
	}

	@Override
	public List<Task> queryTaskByTScope(Integer tscope) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Task> tlist = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "select tid,tname,tstart,tend,tuid,tdesc,taffix from task where tscope=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, tscope);
			rs = ps.executeQuery();
			tlist = new ArrayList<Task>();
			while(rs.next()){
				tlist.add(new Task(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getDate(4),rs.getInt(5),tscope,rs.getString(6),rs.getString(7)));
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
			JDBCUtil.close(rs, ps, conn);
		}
		return tlist;
	}

	@Override
	public void updateTask(Task t) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		conn = JDBCUtil.getConn();
		try {
			String sql = "update task set tname=?,tstart=?,tend=?,tuid=?,tscope=?,tdesc=?,taffix=? where tid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, t.getTname());
			ps.setDate(2, new Date( t.getTstart().getTime()));
			ps.setDate(3,new Date(t.getTend().getTime()));
			ps.setInt(4, t.getTuid());
			ps.setInt(5,t.getTscope());
			ps.setString(6,t.getTdesc());
			ps.setString(7,t.getTaffix());
			ps.setInt(8, t.getTid());
			int n = ps.executeUpdate();
			if(n==1){
				System.out.println("task更新成功！");
			}else{
				System.out.println("task更新失败！");
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
	public void deleteTask(Integer tid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		conn = JDBCUtil.getConn();
		try {
			String sql = "delete from task where tid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, tid);
			int n = ps.executeUpdate();
			if(n==1){
				System.out.println("task删除成功！");
			}else{
				System.out.println("task删除失败！");
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

}
