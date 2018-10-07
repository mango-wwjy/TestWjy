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
 * ʹ��JDBC�����ݿ���в�������ϰ
 *
 */

public class JDBCutil {
	//��������
	public void demo01() throws ClassNotFoundException{
		
		
		try {
			// 1ע������
//			Class.forName("com.mysql.jdbc.Driver");
//			//2 ��ȡ����
//			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/wjy","root","123456");
			Connection conn=JDBCutils.getConnection();
			//3���Ԥ�������
			String sql = "insert into user(name,password) values(?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			// 4 sql���ռλ������ʵ�ʲ���
			ps.setString(1, "tom");
			ps.setString(2, "123456");
			//5 ִ��sql���
			int line= ps.executeUpdate();
			System.out.println("������¼:"+line);
			// 6 �ͷ���Դ
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	   //ȫ������
	public void demo02() throws ClassNotFoundException{
		
		try {
//			//1ע������
//			Class.forName("com.mysql.jdbc.Driver");
//			//2 ��������
//			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/wjy", "root","123456" );
//			
Connection conn=JDBCutils.getConnection();
			//3 ���Ԥ�������
			String sql="select * from user";
			PreparedStatement ps=conn.prepareStatement(sql);
			
			//4 ִ��SQL���
			ResultSet rs=ps.executeQuery();
			//5 ��������
			while(rs.next()){
				//��ȡ��ǰ�еķ���ID
				
				String id=rs.getString("id");
				String name=rs.getString("name");
				String password=rs.getString("password");
				//��ʾ����
				
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
	
			//���¼�¼
	public void demo03() throws ClassNotFoundException{
		
		try {
			//ע������
			Class.forName("com.mysql.jdbc.Driver");
			//��ȡ����
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/wjy","root","123456");
			//���Ԥ�������
			String sql="update user set name=? where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			//sql�������ʵ�ʲ���
			
			ps.setString(1, "lo");
			
			
			ps.setInt(2, 6);
			//ִ��sql���
			int line=ps.executeUpdate();
			System.out.println("���¼�¼"+line);
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	//ɾ������
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
