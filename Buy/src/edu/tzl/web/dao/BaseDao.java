package edu.tzl.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
	Connection conn = null;

	// 获得连接
	public Connection getconn () {
		//驱动名称
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		//数据库地址
		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=EasyBuy";
		try {
			// 加载驱动
			Class.forName(driver);
			// 获得链接
			conn = DriverManager.getConnection(url, "sa", "123");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	// 关闭链接
	public void closeconn() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//测试连接是否成功
	/*public static void main(String[] args) {
		BaseDao b = new BaseDao();
		System.out.println(b.getconn());
	}*/

}
