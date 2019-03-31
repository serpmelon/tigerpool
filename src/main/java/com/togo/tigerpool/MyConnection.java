package com.togo.tigerpool;

import java.sql.Connection;

public class MyConnection {

	private int id;
	private Connection conn;

	public MyConnection(int id, Connection conn) {

		this.id = id;
		this.conn = conn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

}
