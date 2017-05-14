<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.Student"%>
<%@page import="java.util.List"%>
<%@page import="model.bo.StudentBO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<%
		StudentBO StudentBO = new StudentBO();
		List<Student> list = new ArrayList<Student>();
		System.out.println("in list"+request.getAttribute("name"));
		if (request.getAttribute("name") == null) {
			list = StudentBO.getStudentList("");
		}
		else {
			list = StudentBO.getStudentList((String)request.getAttribute("name"));
		}
		%>
	<center><h1>Welcome, <%=session.getAttribute("userName") %></h1></center>
	
	<table>
		<thead>
			<tr>
				<td>UserName</td>
				<td>PassWord</td>
				<td>FullName</td>
				<td>Edit</td>
			</tr>
		</thead>
		<tbody>
			<%for(Student s: list) {%>
			<tr>
				<form action="UpdateStudentServlet" method="post">
					<input type="hidden" name="nameSearch" value="<%=request.getAttribute("name") %>" >
					<td><input type="text" name="userName" readonly="readonly" value="<%=s.getUserName() %>"></td>
					<td><input type="text" name="passWord" value="<%=s.getPassWord() %>"></td>
					<td><input type="text" name="fullName" value="<%=s.getFullName() %>"></td>
					<td><input type="submit" value="Update"></td>
					<td><a href="RemoveStudentServlet?nameSearch=<%=request.getAttribute("name") %>&userName=<%=s.getUserName()%>">Delete</a></td>
				</form>	
			</tr>
			<%} %>
			
		</tbody>
		
	</table>
	
</body>
</html>