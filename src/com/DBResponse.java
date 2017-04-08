package com;

import java.sql.Connection;

public class DBResponse {
	private Connection connection;
	private String errorMessage;
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection con) {
		this.connection = con;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
