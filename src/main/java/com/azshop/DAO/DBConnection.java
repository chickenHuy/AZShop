package com.azshop.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
<<<<<<< HEAD
	private final String serverName = "HIEULAG\\THANHHIEU";//"HIEULAG\\THANHHIEU";//"DESKTOP-NN1DVIA"; 

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
=======
    private final String serverName = "database-azshop.cvv8fenhkivu.ap-southeast-2.rds.amazonaws.com";
    private final String dbName = "AZShop_Nhom_3";
    private final String portNumber = "1433";
    private final String username = "admin";
    private final String password = "Nth250603";
    
    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, username, password);
    }
>>>>>>> 37bef4e463327204d8c91f2ea57dedcd572fcb1b

	public static void main(String[] args) {

		try {

			System.out.println(new DBConnection().getConnection());

		} catch (Exception e) {

			e.printStackTrace();

		}
	}
}
