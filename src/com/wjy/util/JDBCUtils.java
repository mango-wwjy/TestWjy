package com.wjy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * 
 * @author wjy
 *JDBC���������ϰ
 *�������ĸ���
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
				System.out.println("���ݿ�����ע��ʧ��");
				e.printStackTrace();
			}
		}
	//�ṩ��ȡ���ӵķ���
		public static Connection getConn() throws Exception{
			//��ȡ����
			Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
			return conn;
			
		}
		
	
}
