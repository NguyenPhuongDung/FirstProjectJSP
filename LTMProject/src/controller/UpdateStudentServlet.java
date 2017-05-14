package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Student;
import model.bo.StudentBO;

/**
 * Servlet implementation class UpdateStudentServlet
 */
@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    StudentBO studentBO= new  StudentBO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentServlet() {
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
		updateStudent(request,response);
		
	}

	private void updateStudent(HttpServletRequest request,HttpServletResponse response ) throws IOException, ServletException {
		String userName= request.getParameter("userName");
		String passWord= request.getParameter("passWord");
		String fullName= request.getParameter("fullName");
		System.out.println(userName + " " + passWord + " " + fullName);
		String nameSearch = request.getParameter("nameSearch");
		Student st= new Student(userName, passWord, fullName);
		try {
			System.out.println("in"+passWord);
			if(studentBO.isExistsStudent(userName)==true){
				System.out.println("call first "+passWord);
				studentBO.UpdateStudent(st);
				System.out.println("call 2"+passWord);
				request.setAttribute("name", nameSearch);
				RequestDispatcher dispatcher= request.getRequestDispatcher("/list-user.jsp");
				dispatcher.forward(request, response);
				System.out.println("after dispatcher"+passWord);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
