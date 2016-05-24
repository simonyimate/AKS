<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

<link href="css/src/css/buttons.css" rel="stylesheet" type="text/css"/>
<link href="css/src/css/input.css" rel="stylesheet" type="text/css"/>
<link href="css/src/css/header.css" rel="stylesheet" type="text/css"/>
<link href="css/src/css/base.css" rel="stylesheet" type="text/css"/>
<link href="css/src/css/typography.css" rel="stylesheet" type="text/css"/>
<link href="css/src/css/badge.css" rel="stylesheet" type="text/css"/>
<link href="css/src/css/grid.css" rel="stylesheet" type="text/css"/>
<link href="css/src/css/breadcrumb.css" rel="stylesheet" type="text/css"/>
<link href="css/src/css/footer.css" rel="stylesheet" type="text/css"/>
<link href="css/src/css/navbar.css" rel="stylesheet" type="text/css"/>
<link href="css/src/css/panel.css" rel="stylesheet" type="text/css"/>
<link href="css/src/css/normalize.css" rel="stylesheet" type="text/css"/>
<link href="css/src/css/pagination.css" rel="stylesheet" type="text/css"/>
<link href="css/src/css/thumbnails.css" rel="stylesheet" type="text/css"/>
<link href="css/src/css/utilites.css" rel="stylesheet" type="text/css"/>
<link href="css/src/css/alert.css" rel="stylesheet" type="text/css"/>
<link href="css/src/css/tables.css" rel="stylesheet" type="text/css"/>
<link href="css/src/css/card.css" rel="stylesheet" type="text/css"/>

</head>
<body bgcolor="C8D7E3">
<br>
	 <CENTER><img src="http://s33.postimg.org/u2v8i5ncv/title.jpg" alt="title" height="200" width="800"></CENTER>
<form action="/AKSWebClient/MainServlet" method="get">
		<CENTER><table>
		<tr><td>UserName:  </td><td><input type="text" name="userName"></td></tr>
		<input type="hidden" name="type" value="login">
		<tr><td>Password:  </td><td><input type="text" name="password"></td></tr>
		</table></CENTER>
	<CENTER><input type="submit" value="Login"></CENTER> 
	<br>
	<br>
</form>
	<%--Logovanje je : <%=request.getAttribute("result")%> --%>
<form action="/AKSWebClient/index.jsp" method="get">
		<CENTER><input type="submit" value="NAZAD"></CENTER> 
		</form>
</body>
</html>