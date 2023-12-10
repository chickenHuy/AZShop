package com.azshop.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

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
<<<<<<< HEAD


=======
    
>>>>>>> fbbce573674897522caf80bc5b54923032484d18
	public static void main(String[] args) {

		try {

			System.out.println(new DBConnection().getConnection());

		} catch (Exception e) {

			e.printStackTrace();

		}
	}
}