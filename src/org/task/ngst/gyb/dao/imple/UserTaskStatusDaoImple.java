package org.task.ngst.gyb.dao.imple;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.task.ngst.gyb.dao.UserTaskStatusDao;
import org.task.ngst.gyb.entity.UserTaskStatus;
import org.task.ngst.gyb.util.JDBCUtil;

public class UserTaskStatusDaoImple implements UserTaskStatusDao{

	@Override
	public List<UserTaskStatus> queryTaskStatusBySuid(Integer suid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<UserTaskStatus> list = null;
		try {
			conn = JDBCUtil.getConn();
			/*private 	Integer 	suid;  //所属用户
			private 	Integer 	stid;	//任务id
			private 	Integer 	status; //任务完成标志（状态）：0未完成，1完成
			private 	Date 		doneDate; //任务完成日期
			private	 	String 		ttext1;   //任务提交相关文档1
			private 	String 		ttext2;	  //任务提交相关文档2
			private 	String 		staffix;  //上传的文档服务器存储路径
*/			String sql = "select stid,status,donedate,ttext1,ttext2,staffix from usertaskstatus where suid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, suid);
			rs = ps.executeQuery();
			list = new ArrayList<UserTaskStatus>();
			while(rs.next()){
				list.add(new UserTaskStatus(suid, rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getString(4), rs.getString(5),rs.getString(6)));
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
	public List<UserTaskStatus> queryTaskStatusBySuidIsOk(Integer suid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<UserTaskStatus> list = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "select stid,status,donedate,ttext1,ttext2,staffix from usertaskstatus where suid=? and status=1";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, suid);
			rs = ps.executeQuery();
			list = new ArrayList<UserTaskStatus>();
			while(rs.next()){
				list.add(new UserTaskStatus(suid,rs.getInt(1),rs.getInt(2),rs.getDate(3),rs.getString(4),rs.getString(5),rs.getString(6)));
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
	public List<UserTaskStatus> queryTaskStatusBySuidIsNo(Integer suid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<UserTaskStatus> list = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "select stid,status,donedate,ttext1,ttext2,staffix from usertaskstatus where suid=? and status=0";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, suid);
			rs = ps.executeQuery();
			list = new ArrayList<UserTaskStatus>();
			while(rs.next()){
				list.add(new UserTaskStatus(suid,rs.getInt(1),rs.getInt(2),rs.getDate(3),rs.getString(4),rs.getString(5),rs.getString(6)));
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
	public List<UserTaskStatus> queryTaskStatusByStid(Integer stid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<UserTaskStatus> list = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "select suid,status,donedate,ttext1,ttext2,staffix from usertaskstatus where stid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, stid);
			rs = ps.executeQuery();
			list = new ArrayList<UserTaskStatus>();
			while(rs.next()){
				list.add(new UserTaskStatus(rs.getInt(1),stid,rs.getInt(2),rs.getDate(3),rs.getString(4),rs.getString(5),rs.getString(6)));
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
	public List<UserTaskStatus> queryTaskStatusByStidIsOk(Integer stid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<UserTaskStatus> list = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "select suid,status,donedate,ttext1,ttext2,staffix from usertaskstatus where stid=? and status=1";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, stid);
			rs = ps.executeQuery();
			list = new ArrayList<UserTaskStatus>();
			while(rs.next()){
				list.add(new UserTaskStatus(rs.getInt(1),stid,rs.getInt(2),rs.getDate(3),rs.getString(4),rs.getString(5),rs.getString(6)));
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
	public List<UserTaskStatus> queryTaskStatusByStidIsNo(Integer stid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<UserTaskStatus> list = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "select suid,status,donedate,ttext1,ttext2,staffix from usertaskstatus where stid=? and status=0";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, stid);
			rs = ps.executeQuery();
			list = new ArrayList<UserTaskStatus>();
			while(rs.next()){
				list.add(new UserTaskStatus(rs.getInt(1),stid,rs.getInt(2),rs.getDate(3),rs.getString(4),rs.getString(5),rs.getString(6)));
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
	public UserTaskStatus queryTaskStatusBySuidAndStid(Integer suid,Integer stid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserTaskStatus uts = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "select status,donedate,ttext1,ttext2,staffix from usertaskstatus where suid=? and	stid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, suid);
			ps.setInt(2, stid);
			rs = ps.executeQuery();
			if(rs.next()){
				uts = new UserTaskStatus(suid,stid,rs.getInt(1),rs.getDate(2),rs.getString(3),rs.getString(4),rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, conn);
		}
		
		return uts;
	}

	@Override
	public void updateTaskStatus(UserTaskStatus uts) {//删除任务重做的时候调用
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "update usertaskstatus set status=?,donedate=?,ttext1=?,ttext2=?,staffix=? where suid=? and stid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uts.getStatus());
			if(uts.getDoneDate()==null){
				ps.setDate(2, null);
			}else{
				ps.setDate(2, new Date(uts.getDoneDate().getTime()));
			}
			ps.setString(3, uts.getTtext1());
			ps.setString(4, uts.getTtext2());
			ps.setString(5,uts.getStaffix());
			ps.setInt(6, uts.getSuid());
			ps.setInt(7, uts.getStid());
			int n = ps.executeUpdate();
			if(n==1){
				System.out.println("任务状态更新成功！");
			}else{
				System.out.println("任务状态更新失败！");
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
	public void deleteTaskStatus(Integer suid, Integer stid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "delete from usertaskstatus where suid=? and stid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, suid);
			ps.setInt(2, stid);
			int n = ps.executeUpdate();
			if(n==1){
				System.out.println("任务状态删除成功！");
			}else{
				System.out.println("任务状态删除失败！");
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
	public void insertTaskStatus(UserTaskStatus uts) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "insert into usertaskstatus(suid,stid,status,donedate,ttext1,ttext2,staffix) value(?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uts.getSuid());
			ps.setInt(2, uts.getStid());
			ps.setInt(3, uts.getStatus());
			ps.setDate(4, new Date(uts.getDoneDate().getTime()));
			ps.setString(5, uts.getTtext1());
			ps.setString(6, uts.getTtext2());
			ps.setString(7, uts.getStaffix());
			int n = ps.executeUpdate();
			if(n==1){
				System.out.println("任务状态插入成功！");
			}else{
				System.out.println("任务状态插入失败！");
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
