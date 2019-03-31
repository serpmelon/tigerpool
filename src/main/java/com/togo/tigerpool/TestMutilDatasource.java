package com.togo.tigerpool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestMutilDatasource {

	public static void main(String[] args) throws SQLException {

		for (int i = 0; i < 200; i++) {

			MyConnection c = PoolConnection.getConnection();
			
			MyThread mt = new MyThread(c);
			mt.start();

			PoolConnection.collectConn(c);
		}
	}
}
