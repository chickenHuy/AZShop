package com.azshop.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

<<<<<<< HEAD
	private final String serverName = "HIEULAG\\THANHHIEU";//"DESKTOP-NN1DVIA"; 

=======
	private final String serverName = "TLNKHANG";//"HIEULAG\\THANHHIEU";//"DESKTOP-NN1DVIA"; 
>>>>>>> 28e98413fe5ad0569a13a2c9b5e51d55799129be
	private final String dbName = "AZShop_Nhom_4";
	private final String portNumber = "1433";
	private final String instance = "";// MSSQLSERVER LEAVE THIS ONE

	public Connection getConnection() throws Exception {
		String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance
				+ ";integratedSecurity=true;databaseName=" + dbName;
		if (instance == null || instance.trim().isEmpty())
			url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";integratedSecurity=true;databaseName="
					+ dbName;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url);
	}

	public static void main(String[] args) {

		try {

			System.out.println(new DBConnection().getConnection());

		} catch (Exception e) {

			e.printStackTrace();

		}
	}
}
