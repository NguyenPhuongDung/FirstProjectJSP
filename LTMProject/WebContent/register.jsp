<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center><h1>Welcome, <%=session.getAttribute("userName") %></h1></center>
	<form action="CheckRegisterServlet" method="post">
        UserName: <input type="text" name="userName"/>
        PassWord: <input type="password" name="passWord"/>
        FullName: <input type="text" name="fullName"/>
        <input type="submit" value="Register" />        
    </form>
</body>
</html>