<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/AKSWebClient/MainServlet" method="get">
		<table>
		<tr><td>Kome saljemo :  </td><td><input type="text" name="userName"></td></tr>
		<input type="hidden" name="type" value="poruka">
		<tr><td>Tekst poruke  </td><td><input type="text" name="text"></td></tr>
		</table>
	<input type="submit" value="Posalji"> 
</form>
	
<form action="/AKSWebClient/logovaniUser.jsp" method="get">
		<input type="submit" value="NAZAD"> 
		</form>
</body>
</html>