package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Student;
import model.bo.StudentBO;

/**
 * Servlet implementation class CheckRegisterServlet
 */
@WebServlet("/CheckRegisterServlet")
public class CheckRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    StudentBO studentBO= new StudentBO();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		String fullName= request.getParameter("fullName");
		
		try {
			if (studentBO.isExistsStudent(userName)) {
				response.sendRedirect("ErrorLogin.jsp");
			}
			else{
				studentBO.RegisterLogin(new Student(userName, passWord, fullName));
				RequestDispatcher dispatcher= request.getRequestDispatcher("/login.jsp");
				dispatcher.forward(request, response);
				System.out.println("ok");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
