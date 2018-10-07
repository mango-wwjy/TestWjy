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

//静态代码块
			static{
				 try {	//1使用Properties处处理流
				//使用load()方法加载指定的流
	         Properties props=new Properties();
	        
				Reader is=new FileReader("db.properties");
				props.load(is);
				
				//使用getProperty(key),通过key获得需要的值
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
			 * 获得连接
			 */
			public static Connection getConnection(){
				//注册驱动
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
