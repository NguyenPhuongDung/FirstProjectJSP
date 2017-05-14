package model.bo;

import java.sql.SQLException;
import java.util.List;

import model.bean.Student;
import model.dao.StudentDAO;


public class StudentBO {
	StudentDAO studentDAO= new StudentDAO();
	public List<Student> getStudentList(String userName) throws ClassNotFoundException, SQLException {
		return studentDAO.getListStudent(userName);
	}
	public boolean UpdateStudent(Student st) throws ClassNotFoundException, SQLException{
		if( studentDAO.updateStudent(st)){
			return true;
		}
		else{
			return false;
		}
	}
	public void RemoveStudent(String userName) throws ClassNotFoundException, SQLException{
		 studentDAO.removeStudent(userName);
	}
	public boolean isExistsStudent(String userName) throws ClassNotFoundException, SQLException{
		if(studentDAO.isExistsStudent(userName)==true){
			return true;
		}
		else{
			return false;
		}
	}
	public Student RegisterLogin(Student st) throws ClassNotFoundException, SQLException{
		return studentDAO.registerLogin(st);
	}
}
