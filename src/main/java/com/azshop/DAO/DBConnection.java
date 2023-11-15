package com.azshop.DAO;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {

<<<<<<< HEAD
	private final String serverName = "TLNKHANG"; //*"HIEULAGTHANHHIEU"
=======
	private final String serverName = "DESKTOP-NN1DVIA"; //*"HIEULAGTHANHHIEU"
>>>>>>> 022dcbf74b34afaf8864d4b0d0e4ebd6aac1007b
	private final String dbName = "AZShop_Nhom_4";
	private final String portNumber = "1433";
	private final String instance = "";// MSSQLSERVER LEAVE THIS ONE
	
	public Connection getConnection() throws Exception {
		String url = "jdbc:sqlserver://" + serverName + ":" + portNumber
		+ "\\" + instance + ";integratedSecurity=true;databaseName=" +
		dbName;
		if (instance == null || instance.trim().isEmpty())
		url = "jdbc:sqlserver://" + serverName + ":" + portNumber +
		";integratedSecurity=true;databaseName=" + dbName;
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
