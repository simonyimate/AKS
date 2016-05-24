<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rezultati Licitacija</title>

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
	<input type="submit" value="Izlistaj licitacije gde sam ucestvovao">
	<input type="hidden" name="type" value="ishodLicitacijeUcestvovao">
	<c:if test="${!empty aukcijeSveLicit}"> 
	<hr>
	<table>
	Sve Aukcija gde sam licitirao:
  		<thead><td  width="13%">Naziv Predmeta</td><td  width="13%">Opis Predmeta</td><td  width="13%">Stanje Predmeta</td><td  width="13%">Vlasnik Predmeta</td><td  width="13%">Najveca Ponuda</td><td  width="13%">Vreme</td><td  width="13%">Uspesna</td></thead>
  			<c:forEach var="a" items="${aukcijeSveLicit}">
  			<tr>
  				<td>${a.akspredmet.naziv}</td>
  				<td>${a.akspredmet.opis}</td>
  				<td>${a.akspredmet.stanje}</td>
  				<td>${a.akskorisnik1.username}</td>
  				<td>${a.najvecaponuda}</td>
  				<td>${a.vreme}</td>
  				<%-- <c:if test2="${==a.}"> --%>
  				<c:if test="${a.uspesna==true}"> 
  					<td><font color="green">USPESNA</font></td>
  				</c:if>
  				<c:if test="${a.uspesna==false}"> 
  					<td><font color="red">USPESNA</font></td>
  				</c:if>
  			</tr>
  			</c:forEach>
  		</table>
	<hr>
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