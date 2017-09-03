package org.task.ngst.gyb.dao.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.task.ngst.gyb.dao.UserDao;
import org.task.ngst.gyb.entity.User;
import org.task.ngst.gyb.util.JDBCUtil;


public class UserDaoImple implements UserDao{

	@Override
	public void insertUser(User u) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "insert into users value(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getUid());
			ps.setString(2, u.getUname());
			ps.setString(3, u.getUpasswd());
			ps.setInt(4, u.getUage());
			ps.setString(5, u.getUsex());
			ps.setString(6,u.getUclass());
			ps.setInt(7, u.getUgrade());
			ps.setInt(8, u.getUcategory());
			ps.setString(9, u.getUqq());
			ps.setString(10, u.getUemail());
			ps.setString(11, u.getUtel());
			ps.setString(12, u.getUpasswdQues());
			ps.setString(13, u.getUpasswdAns());
			int n = ps.executeUpdate();
			if(n==1){
				System.out.println("插入用户成功！");
			}else{
				System.out.println("插入用户失败！");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally{
			JDBCUtil.close(null, ps, conn);
		}
		
	}

	@Override
	public List<User> queryAllUser() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<User>();
		try {
			conn = JDBCUtil.getConn();
			String sql = "select uid,uname,upasswd,uage,usex,uclass,ugrade,ucategory,uqq,uemail,utel,upasswdques,upasswdans from users;";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				list.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13)) );
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
	public User queryUserById(Integer uid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User u = null;
		
		try {
			conn = JDBCUtil.getConn();
			String sql = "select uname,upasswd,uage,usex,uclass,ugrade,ucategory,uqq,uemail,utel,upasswdques,upasswdans from users where uid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			rs = ps.executeQuery();
			if(rs.next()){
				u = new User(uid,rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12));
			}else{
				System.out.println("无此用户");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, conn);
		}
		return u;
	}

	@Override
	public List<User> queryUserByName(String uname) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> list = null;
		
		try {
			conn = JDBCUtil.getConn();
			String sql = "select uid,upasswd,uage,usex,uclass,ugrade,ucategory,uqq,uemail,utel,upasswdques,upasswdans from users where uname=?;";
			ps = conn.prepareStatement(sql);
			list = new ArrayList<User>();
			ps.setString(1, uname);
			rs = ps.executeQuery();
			while(rs.next()){
				list.add(new User(rs.getInt(1), uname, rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12)));
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
	public List<User> queryUserByClass(String uclass) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> list = null;
		
		try {
			conn = JDBCUtil.getConn();
			String sql = "select uid,uname,upasswd,uage,usex,ugrade,ucategory,uqq,uemail,utel,upasswdques,upasswdans from users where uclass=?";
			ps = conn.prepareStatement(sql);
			list = new ArrayList<User>();
			ps.setString(1, uclass);
			rs = ps.executeQuery();
			while(rs.next()){
				list.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), uclass, rs.getInt(6), rs.getInt(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12)));
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
	public List<User> queryUserByGrade(Integer ugrade) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> list = null;
		
		try {
			conn = JDBCUtil.getConn();
			String sql = "select uid,uname,upasswd,uage,usex,uclass,ugrade,ucategory,uqq,uemail,utel,upasswdques,upasswdans from users where ugrade=?;";
			ps = conn.prepareStatement(sql);
			list = new ArrayList<User>();
			ps.setInt(1, ugrade);
			rs = ps.executeQuery();
			while(rs.next()){
				list.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), ugrade, rs.getInt(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12)));
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
	public List<User> queryUserByCategory(Integer ucategory) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> list = null;
		
		try {
			conn = JDBCUtil.getConn();
			String sql = "select uid,uname,upasswd,uage,usex,uclass,ugrade,ucategory,uqq,uemail,utel,upasswdques,upasswdans from users where ucategory=?;";
			ps = conn.prepareStatement(sql);
			list = new ArrayList<User>();
			ps.setInt(1, ucategory);
			rs = ps.executeQuery();
			while(rs.next()){
				list.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7), ucategory,rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12)));
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
	public List<User> queryUserBySex(String usex) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> list = null;
		
		try {
			conn = JDBCUtil.getConn();
			String sql = null;
			if(usex==null||usex.equals("")){//如果没有设置usex
				sql = "select uid,uname,upasswd,uage,uclass,ugrade,ucategory,uqq,uemail,utel,upasswdques,upasswdans from users where usex is null;";
				ps = conn.prepareStatement(sql);
			}else{
				sql = "select uid,uname,upasswd,uage,uclass,ugrade,ucategory,uqq,uemail,utel,upasswdques,upasswdans from users where usex=?;";
				ps = conn.prepareStatement(sql);
				ps.setString(1, usex);
			}
			
			list = new ArrayList<User>();
			rs = ps.executeQuery();
			while(rs.next()){
				list.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), usex, rs.getString(5), rs.getInt(6), rs.getInt(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12)));
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
	public void updateUser(User u) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "update users set uname=?,upasswd=?,uage=?,usex=?,uclass=?,ugrade=?,ucategory=?,uqq=?,uemail=?,utel=?,upasswdques=?,upasswdans=? where uid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUname());
			ps.setString(2, u.getUpasswd());
			ps.setInt(3, u.getUage());
			ps.setString(4, u.getUsex());
			ps.setString(5,u.getUclass());
			ps.setInt(6, u.getUgrade());
			ps.setInt(7, u.getUcategory());
			ps.setString(8, u.getUqq());
			ps.setString(9, u.getUemail());
			ps.setString(10, u.getUtel());
			ps.setString(11, u.getUpasswdQues());
			ps.setString(12, u.getUpasswdAns());
			ps.setInt(13, u.getUid());
			int n = ps.executeUpdate();
			if(n==1){
				System.out.println("更新成功！");
			}else{
				System.out.println("更新失败！");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.close(null, ps, conn);
		}
	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = JDBCUtil.getConn();
			String sql = "delete from users where uid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int n = ps.executeUpdate();
			if(n==1){
				System.out.println("删除成功！");
			}else{
				System.out.println("删除失败！");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.close(null, ps, conn);
		}
		
	}

	
	
}
