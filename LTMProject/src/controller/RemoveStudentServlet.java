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

import model.bo.StudentBO;

/**
 * Servlet implementation class RemoveStudentServlet
 */
@WebServlet("/RemoveStudentServlet")
public class RemoveStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    StudentBO studentBO= new StudentBO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		delStudent(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		delStudent(request, response);
	}

	private void delStudent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String userName= request.getParameter("userName");
		String nameSearch= request.getParameter("nameSearch");
		HttpSession session=request.getSession();
		try {
			System.out.println("UserName:"+userName);
			System.out.println("Session is:"+session.getAttribute("userName"));
			if(studentBO.isExistsStudent(userName)==true){
				if(userName.equals(session.getAttribute("userName"))){
					studentBO.RemoveStudent(userName);
					request.getSession().invalidate();
					response.sendRedirect("login.jsp");
				}
				else{
					studentBO.RemoveStudent(userName);
					System.out.println("in delete servlet");
					RequestDispatcher dispatcher= request.getRequestDispatcher("/list-user.jsp");
					request.setAttribute("name", nameSearch);
					dispatcher.forward(request, response);
				}
			}
			else{
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
