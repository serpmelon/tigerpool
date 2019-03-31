package com.togo.tigerpool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class MyThread extends Thread {

	private MyConnection myconn;
	private Random random = new Random();

	public MyThread(MyConnection myconn) {

		this.myconn = myconn;
	}

	@Override
	public void run() {

		Connection conn = myconn.getConn();
		try {
			while(true) {
				
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery("select * from user_salary ");
				// 4.处理数据库的返回结果(使用ResultSet类)
				System.out.println(Thread.currentThread().getName() + "  " +myconn.getId());
				while(rs.next()) {
					System.out.println(rs.getString("name"));
				}
				Thread.sleep((random.nextInt(10) + 1) * 1000);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
