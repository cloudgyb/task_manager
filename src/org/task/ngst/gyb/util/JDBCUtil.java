package org.task.ngst.gyb.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {
	private static Properties prop = new Properties();
	private static final ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	static{
		InputStream in = JDBCUtil.class.getResourceAsStream("/org/task/ngst/gyb/conf/jdbc.properties");
		try {
			prop.load(in);
			Class.forName(prop.getProperty("driver"));//加载mysql驱动
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConn(){//获取连接实例
		Connection conn = tl.get();
		if(conn==null){
			try {
				conn = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("user"),prop.getProperty("password"));
				tl.set(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}
		return conn;
		
	}
	public static void close(ResultSet rs,Statement stm,Connection conn){
		if(rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(stm != null) {
			try {
				stm.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
				//解除连接与当前线程的绑定
				tl.remove();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
