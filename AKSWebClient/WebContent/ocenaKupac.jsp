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
Unesite ime kupca za koji zelite da vidite komentare:<input type="text" name="kupac">
	<input type="submit" value="Prikazi komentare i ocene"><br><br>
	<input type="hidden" name="type" value="commKup">
	<c:if test="${!empty KomentariKup}"> 
	<table>
	<thead><td  width="13%">Komentar</td><td  width="13%">Ocena</td><td  width="13%">Naziv Predmeta</td></thead>	
	<c:forEach var="k" items="${KomentariKup}">
  			<tr>
  				<td>${k.tekstk}</td>
  				<c:if test="${k.ocena==1}"> 
  					<td><font color="red">*</font></td>
  				</c:if>
  				<c:if test="${k.ocena==2}"> 
  					<td><font color="orange">**</font></td>
  				</c:if>
  				<c:if test="${k.ocena==3}"> 
  					<td><font color="yellow">***</font></td>
  				</c:if>
  				<c:if test="${k.ocena==4}"> 
  					<td><font color="lightgreen">****</font></td>
  				</c:if>
  				<c:if test="${k.ocena==5}"> 
  					<td><font color="green">*****</font></td>
  				</c:if>
  				<td>${k.aksaukcija.akspredmet.naziv}</td>
  			</tr>
  			</c:forEach>
	</table>
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