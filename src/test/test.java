package test;

import org.junit.Test;

import com.ambow.util.JDBCutil;

public class test {
	JDBCutil jdbcutil=new JDBCutil();
   
	@Test
	public void addtest() throws ClassNotFoundException{
		
		
		jdbcutil.demo01();
		
	}
//	@Test
//	public void selecttest() throws ClassNotFoundException{
//		jdbcutil.demo02();
//		
//	}
//	@Test
//	public void updatetest() throws ClassNotFoundException{
//		jdbcutil.demo03();
//		jdbcutil.demo04();
//	}
}
