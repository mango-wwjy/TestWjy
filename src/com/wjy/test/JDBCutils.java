package com.wjy.test;


import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;



public class JDBCutils {
private static String driver;
private static String url;
private static String user;
private static String password;

//��̬�����
			static{
				 try {	//1ʹ��Properties��������
				//ʹ��load()��������ָ������
	         Properties props=new Properties();
	        
				Reader is=new FileReader("db.properties");
				props.load(is);
				
				//ʹ��getProperty(key),ͨ��key�����Ҫ��ֵ
				driver = props.getProperty("driver");
				url = props.getProperty("url");
				user = props.getProperty("user");
				password = props.getProperty("password");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
	
		}
			/*
			 * �������
			 */
			public static Connection getConnection(){
				//ע������
				try {
					Class.forName(driver);
					Connection conn=DriverManager.getConnection(url, user, password);
					return conn;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					throw new RuntimeException(e);
				}
				
				
				
			}
			
}
