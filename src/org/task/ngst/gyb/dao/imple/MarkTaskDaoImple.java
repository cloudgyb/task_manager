package org.task.ngst.gyb.dao.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.task.ngst.gyb.dao.MarkTaskDao;
import org.task.ngst.gyb.entity.marktask.NotyetMarkTaskItem;
import org.task.ngst.gyb.util.JDBCUtil;

public class MarkTaskDaoImple implements MarkTaskDao{
	/**
	 * 根据tid 查询未完成的任务
	 */
	@Override
	public List<NotyetMarkTaskItem> queryNotyetMarkTaskByTid(Integer tid) {
		// TODO Auto-generated method stub
				Connection conn = null;
				PreparedStatement ps = null;
				List<NotyetMarkTaskItem> list = null;
				ResultSet rs = null;
				try {
					conn = JDBCUtil.getConn();
					String sql = "select t.tname,g.guid,t.tstart,t.tend from grade as g,task as t where g.gtid=t.tid and g.gtid=? and dealuid is null";
					ps = conn.prepareStatement(sql);
					ps.setInt(1, tid);
					rs = ps.executeQuery();
					list = new ArrayList<>();
					while(rs.next()){
						NotyetMarkTaskItem item = new NotyetMarkTaskItem(tid, rs.getString(1), rs.getInt(2), rs.getDate(3), rs.getDate(4));
						list.add(item);
					}
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					JDBCUtil.close(rs, ps, conn);
				}
		return list;
	}
	
}
