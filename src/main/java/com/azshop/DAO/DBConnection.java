package com.azshop.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private final String serverName = "HIEULAG\\THANHHIEU";

    private final String dbName = "AZShop_Nhom_3";
    private final String portNumber = "1433";
    private final String username = "sa";
    private final String password = "123456";
    
    
    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, username, password);
    }
    
	public static void main(String[] args) {

		try {

			System.out.println(new DBConnection().getConnection());

		} catch (Exception e) {

			e.printStackTrace();

		}
	}
}