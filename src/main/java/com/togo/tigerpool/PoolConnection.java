package com.togo.tigerpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class PoolConnection {

	private static final String URL = "jdbc:mysql://127.0.0.1:3306/wt_wish?useUnicode=true&amp;characterEncoding=utf-8";
	private static final String USER = "root";
	private static final String PASSWORD = "123456";

	private static LinkedList<MyConnection> conns = new LinkedList<MyConnection>();

	static {
		init();
	}

	private static void init() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			for (int i = 0; i < 10; i++) {

				Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				conns.add(new MyConnection(i, conn));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static MyConnection getConnection() {

		return conns.removeFirst();
	}

	public static void collectConn(MyConnection conn) {

		conns.add(conn);
	}
}
