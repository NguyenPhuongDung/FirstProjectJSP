package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbContext {
private static Connection  conn=null;

private static Statement stmt = null;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		
		String url = "jdbc:mysql://localhost:3306/dulieu";
		String userName= "root";
		String pass= "";
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(url, userName, pass);
			System.out.println("connected");
		}
		catch(Exception e) {
			System.out.println("Disconnected");
		}
		return conn;
	}
	public static ResultSet getResultSet(String sql) throws SQLException{
		stmt = conn.createStatement();
		ResultSet rs = null;
		if(sql.toLowerCase().startsWith("select"))
		rs = stmt.executeQuery(sql);
		else 
			stmt.executeUpdate(sql);
		return rs;
	}
}
