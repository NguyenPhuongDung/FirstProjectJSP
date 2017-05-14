package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.PreparedStatement;


public class CheckLoginDAO {
	public boolean login(String username, String password) throws ClassNotFoundException, SQLException {
		Connection conn= null;
		conn=DbContext.getConnection();
		String sql = "select * from student where username='" + username
				+ "' and password='" + password + "'";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				conn.close();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
