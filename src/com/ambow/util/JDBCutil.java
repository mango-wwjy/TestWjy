package com.ambow.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wjy.test.JDBCutils;

/**
 * 
 * @author mangowjy
 * 使用JDBC对数据库进行操作的练习
 *
 */

public class JDBCutil {
	//增加数据
	public void demo01() throws ClassNotFoundException{
		
		
		try {
			// 1注册驱动
//			Class.forName("com.mysql.jdbc.Driver");
//			//2 获取连接
//			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/wjy","root","123456");
			Connection conn=JDBCutils.getConnection();
			//3获得预处理对象
			String sql = "insert into user(name,password) values(?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			// 4 sql语句占位符设置实际参数
			ps.setString(1, "tom");
			ps.setString(2, "123456");
			//5 执行sql语句
			int line= ps.executeUpdate();
			System.out.println("新增记录:"+line);
			// 6 释放资源
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	   //全查数据
	public void demo02() throws ClassNotFoundException{
		
		try {
//			//1注册驱动
//			Class.forName("com.mysql.jdbc.Driver");
//			//2 建立连接
//			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/wjy", "root","123456" );
//			
Connection conn=JDBCutils.getConnection();
			//3 获得预处理对象
			String sql="select * from user";
			PreparedStatement ps=conn.prepareStatement(sql);
			
			//4 执行SQL语句
			ResultSet rs=ps.executeQuery();
			//5 处理结果集
			while(rs.next()){
				//获取当前行的分类ID
				
				String id=rs.getString("id");
				String name=rs.getString("name");
				String password=rs.getString("password");
				//显示数据
				
				System.out.println(id+"-------"+name+"----"+password);
				
				
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
			//更新记录
	public void demo03() throws ClassNotFoundException{
		
		try {
			//注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/wjy","root","123456");
			//获得预处理对象
			String sql="update user set name=? where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			//sql语句设置实际参数
			
			ps.setString(1, "lo");
			
			
			ps.setInt(2, 6);
			//执行sql语句
			int line=ps.executeUpdate();
			System.out.println("更新记录"+line);
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	//删除数据
	public void demo04() throws ClassNotFoundException{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/wjy", "root", "123456");
			String sql="delete from user where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setInt(1, 1);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	

}
