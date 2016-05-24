<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

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
<CENTER><form action="/AKSWebClient/MainServlet" method="get">
	Izaberite aukcije za koju zelite da posaljete poruku kupcu:
	<c:if test="${!empty aukcijeUspesneVlasnik}">
	<select name="auk">
		<c:forEach var="ak" items="${aukcijeUspesneVlasnik}">
			<option value="${ak.aukcijaId}">${ak.akspredmet.naziv}</option>
		</c:forEach>
		</select>
	
	<hr>
		<input type="hidden" name="type" value="porukaKupac">
		Tekst poruke<input type="text" name="text">
		<c:if test="${!empty por}">
		<%=request.getAttribute("por")%>
		</c:if>
	<input type="submit" value="Posalji"> 
	<br>
	<br>
	</c:if>
</form>
	
<form action="/AKSWebClient/logovaniUser.jsp" method="get">
		<input type="submit" value="NAZAD">
		<br>
		<br> 
		</form>
		</CENTER>
</body>
</html>