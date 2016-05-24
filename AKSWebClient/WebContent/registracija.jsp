<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registracija</title>

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
<CENTER><form action="/AKSWebClient/MainServlet" method="get">
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
	<c:if test="${result==true}">
		<br>
	Registracija je uspesna!
	<br>
	<br>
	</c:if>
<form action="/AKSWebClient/index.jsp" method="get">
		<br>
		<br>
		<input type="submit" value="NAZAD"> 
		</form></CENTER>
</body>
</html>