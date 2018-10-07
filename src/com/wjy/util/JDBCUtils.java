package com.wjy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * 
 * @author wjy
 *JDBC工具类的练习
 *方便代码的复用
 */
public class JDBCUtils {
		public static final String DRIVERNAME="com.mysql.jdbc.Driver";
		public static final String URL="jdbc:mysql://localhost:3306//wjy	";
		public static final String USER="root";
		public static final String PASSWORD="123456";
		
		
		
		static{
			
			try {
				Class.forName(DRIVERNAME);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("数据库驱动注册失败");
				e.printStackTrace();
			}
		}
	//提供获取连接的方法
		public static Connection getConn() throws Exception{
			//获取连接
			Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
			return conn;
			
		}
		
	
}
