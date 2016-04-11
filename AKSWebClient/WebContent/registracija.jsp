<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registracija</title>
</head>
<body>
<form action="/AKSWebClient/MainServlet" method="get">
		<table>
		<tr><td>Ime: </td><td><input type="text" name="ime"></td></tr>
		<tr><td>Prezime: </td><td><input type="text" name="prezime"></td></tr>
		<tr><td>UserName: </td><td><input type="text" name="userName"></td></tr>
		<input type="hidden" name="type" value="registracija"> </td></tr>
		<tr><td>Password: </td><td><input type="text" name="password"></td></tr>
		<tr><td>E-mail: </td><td><input type="text" name="email"></td></tr>
		</table>
	<input type="submit" value="Registracija"> 
</form>
	Registracija je : <%=request.getAttribute("result")%>
<form action="/AKSWebClient/index.jsp" method="get">
		<input type="submit" value="NAZAD"> 
		</form>
</body>
</html>