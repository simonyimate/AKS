<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ulogovani User</title>
</head>
<body>
	<form action="/AKSWebClient/Izlistaj.jsp" method="get">
	<input type="submit" value="Izlistavanje detalja"> 
</form>
<form action="/AKSWebClient/unosAukcije.jsp" method="get">
	<input type="submit" value="Unos nove aukcije"> 
</form>
	Logovanje je : <%=request.getAttribute("result")%>
<form action="/AKSWebClient/index.jsp" method="get">
		<input type="submit" value="NAZAD"> 
</form>
</body>
</html>