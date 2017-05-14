package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bo.StudentBO;

/**
 * Servlet implementation class SearchNameServlet
 */
@WebServlet("/SearchNameServlet")
public class SearchNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StudentBO studentBO= new StudentBO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchNameServlet() {
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
		searchStudent(request, response);
	}

	private void searchStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String name= request.getParameter("searchName");
			try {
				if(studentBO.getStudentList(name).size()!=0){
					request.setAttribute("name", name);
					RequestDispatcher dispatcher= request.getRequestDispatcher("/list-user.jsp");
					dispatcher.forward(request, response);
					System.out.println("search ok");
				}
				else{
					System.out.println("no matchedS");
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
