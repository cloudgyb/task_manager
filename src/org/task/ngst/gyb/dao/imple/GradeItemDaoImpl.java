package org.task.ngst.gyb.dao.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.task.ngst.gyb.dao.GradeItemDao;
import org.task.ngst.gyb.entity.GradeItem;
import org.task.ngst.gyb.util.JDBCUtil;

public class GradeItemDaoImpl implements GradeItemDao {
	
	@Override
	public List<GradeItem> getGradeItemsByTid(Integer tid) {
		Connection conn = null;
		PreparedStatement ps = null;
		List<GradeItem> list = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConn();
			list = new ArrayList<>();
			String sql = "select u.uname,g.dealdate,g.score from grade as g,users as u where g.gtid=? and g.guid=u.uid";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, tid);
			rs = ps.executeQuery();
			while(rs.next()){
				GradeItem gi = new GradeItem();
				gi.setTid(tid);
				gi.setUname(rs.getString(1));
				gi.setCheckDate(rs.getDate(2));
				gi.setScore(rs.getFloat(3));
				list.add(gi);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, conn);
		}
		return list;
	}
	
}
