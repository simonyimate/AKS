<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prikaz aukcije koja najskorije istice</title>
</head>
<body bgcolor="C8D7E3">
<br>
<CENTER><c:if test="${!empty aukcije}">
	Ne postoji aukcija koja najskorije istice!
</c:if>
	
	<c:if test="${!empty aukcijeIsticu}"> 
	<br>Aukcija koja najskorije istice: <br>
  		<table>
  		<thead><td width="13%">Naziv Predmeta</td><td width="13%">Opis Predmeta</td><td width="13%">Stanje Predmeta</td><td width="13%">Vlasnik Predmeta</td><td width="13%">Najveca Ponuda</td><td width="13%">Vreme</td></thead>
  			<c:forEach var="a" items="${aukcijeIsticu}">
  			<tr>
  				<td>${a.akspredmet.naziv}</td>
  				<td>${a.akspredmet.opis}</td>
  				<td>${a.akspredmet.stanje}</td>
  				<td>${a.akskorisnik1.username}</td>
  				<td>${a.najvecaponuda}</td>
  				<td>${a.vreme}</td>
  				
  				
  			</tr>
  			</c:forEach>
  		</table>
  		</c:if>
	<form action="/AKSWebClient/index.jsp" method="get">
		<input type="submit" value="NAZAD"> 
		<br>
		<br>
	</form>
	</CENTER>
</body>
</html>