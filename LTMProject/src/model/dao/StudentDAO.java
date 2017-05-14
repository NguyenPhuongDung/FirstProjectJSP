package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.PreparedStatement;

import model.bean.Student;

public class StudentDAO {
	public List<Student> getListStudent(String name) throws ClassNotFoundException, SQLException{
		Connection conn= DbContext.getConnection();
		String sql="select * from student where fullName like '" + "%"+ name + "%" +"'";
		List<Student> list = new ArrayList<Student>();
		PreparedStatement ps;
		try {
			ps=(PreparedStatement)conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				String userName=rs.getString("userName");
				String password=rs.getString("passWord");
				String fullname= rs.getString("fullName");
				list.add(new Student(userName,password,fullname));
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public boolean updateStudent(Student s) throws ClassNotFoundException, SQLException {
		Connection con = DbContext.getConnection();
		String sql = "update student set userName=?, passWord=?, fullName=? where userName=?";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, s.getUserName());
			ps.setString(2, s.getPassWord());
			ps.setString(3, s.getFullName());
			ps.setString(4, s.getUserName());
			ps.executeUpdate();
			System.out.println("dao:"+s.getPassWord());
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
		
	}
	public void removeStudent(String userName) throws ClassNotFoundException, SQLException {
		Connection conn= DbContext.getConnection();
		String sql = "delete from student where userName='" + userName+ "'";
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public boolean isExistsStudent(String userName) throws ClassNotFoundException, SQLException {
		Connection conn= DbContext.getConnection();
		String sql = "select * from student where userName='"+userName+"'";
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
	public Student registerLogin(Student s) throws ClassNotFoundException, SQLException{
		Connection conn= DbContext.getConnection();
		String sql="INSERT INTO student(userName,passWord,fullName) VALUES (?,?,?)";
		PreparedStatement ps;
		try {
			ps=(PreparedStatement)conn.prepareStatement(sql);
			ps.setString(1, s.getUserName());
			ps.setString(2, s.getPassWord());
			ps.setString(3, s.getFullName());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
}
