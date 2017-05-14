package model.bo;

import java.sql.SQLException;

import model.dao.CheckLoginDAO;

public class CheckLoginBO {
	CheckLoginDAO LoginDAO= new CheckLoginDAO();
	public boolean isValidUser(String userName, String password) throws ClassNotFoundException, SQLException {		
		return LoginDAO.login(userName, password);
	}
}
