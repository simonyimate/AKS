<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Unos nove aukcije</title>

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
<body>
<form action="/AKSWebClient/MainServlet" method="get">
		
		
		<hr>
		<br>
		Predmet:
		<br>
		<br>
			Naziv:<input type="text" name="naziv">
			Opis:<input type="text" name="opis">
			<select name="stanje">
				<option value="novo">novo</option>
				<option value="polovno">polovno</option>
				<option value="neispravno">neispravno</option>
			</select>
			Pocetna Cena:<input type="text" name="pocetnaCena">
			Path slike:<input type="file" name="slika" accept="image/*">
			<hr>
			Dodatne informacije o aukciji:<br>
			Dan: <input type="text" name="dan">
			Sat:<input type="text" name="sat">
		<br>
		<br>
	<input type="hidden" name="type" value="aukcija"> 
	<input type="submit" value="Kreiraj aukciju">
	<br>
	<c:if test="${!empty kreiranje}"> 
	Rezultat : <%=request.getAttribute("kreiranje")%>
	</c:if>
	
</form>
	<form action="/AKSWebClient/index.jsp" method="get">
		<br>
		<input type="submit" value="NAZAD"> 
	</form>
</body>
</html>