package service;

import java.sql.Connection;
import java.sql.DriverManager;

 class DBService {
	public Connection getConnection() throws Exception {
		Class.forName("org.mariadb.jdbc.Driver");
 		Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/puzzle", "root", "java1234");
 		return conn;
	}

 	}
 