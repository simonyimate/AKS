<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ulogovani User</title>

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
<CENTER><img src="http://s33.postimg.org/cp9ezeo3j/title2.jpg" alt="title" height="150" width="400"></CENTER>
<CENTER>
<table>
<tr><td>
	<form action="/AKSWebClient/Izlistaj.jsp" method="get">
	<input type="submit" value="Izlistavanje detalja" style="height:40px;width:350px"> 
	</form>
</td><td>
	<form action="/AKSWebClient/unosAukcije.jsp" method="get">
	<input type="submit" value="Unos nove aukcije" style="height:40px;width:350px"> 
	</form>
</td></tr><tr><td>
	<form action="/AKSWebClient/rezultatiLicitacija.jsp" method="get">
	<input type="submit" value="Pregledaj ishode licitacija" style="height:40px;width:350px"> 
	</form>
</td><td>
	<form action="/AKSWebClient/listaGdeSamUcestvovao.jsp" method="get">
	<input type="submit" value="Izlistaj listu predmeta na kojima sam ucestvovao" style="height:40px;width:350px"> 
	</form>
</td></tr><tr><td>
	<form action="/AKSWebClient/poruka.jsp" method="get">
	<input type="submit" value="Nova poruka za kupca" style="height:40px;width:350px"> 
	</form>
</td><td>
	<form action="/AKSWebClient/prodavacPoruka.jsp" method="get">
	<input type="submit" value="Nova poruka za prodavca" style="height:40px;width:350px"> 
	</form>
</td></tr><tr><td>
	<form action="/AKSWebClient/pogledajPorukuKupac.jsp" method="get">
	<input type="submit" value="Pogledaj poruke od kupca" style="height:40px;width:350px"> 
	</form>
</td><td>
	<form action="/AKSWebClient/pogledajPorukuProdavac.jsp" method="get">
	<input type="submit" value="Pogledaj poruke od prodavca" style="height:40px;width:350px"> 
	</form>
</td></tr><tr><td>
	<form action="/AKSWebClient/ocenaAndcomentars.jsp" method="get">
	<input type="submit" value="Oceni i komentarisi oglase kao kupac" style="height:40px;width:350px"> 
	</form>
</td><td>
	<form action="/AKSWebClient/ocenaAndcomentarsKupac.jsp" method="get">
	<input type="submit" value="Oceni i komentarisi oglase kao prodavac" style="height:40px;width:350px"> 
	</form>
</td></tr><tr><td>
	<form action="/AKSWebClient/ocenaProdavac.jsp" method="get">
	<input type="submit" value="Pogledaj ocene za prodavce" style="height:40px;width:350px"> 
	</form>
</td><td>
	<form action="/AKSWebClient/ocenaKupac.jsp" method="get">
	<input type="submit" value="Pogledaj ocene za kupce" style="height:40px;width:350px"> 
	</form>
</td></tr></table>
<br>
	<c:if test="${result==true}">
		Logovanje je Uspesno!
		<br>
		<br>
	</c:if>
	
	<c:if test="${!empty petNajboljih}">
		Korisnici meseca:
		<br>
		<br>
		<table>
		
  		<thead><td width="13%">Ime</td><td width="13%">Prezime</td><td width="13%">Email</td></thead>
  			<c:forEach var="k" items="${petNajboljih}">
  			<tr>
  				<td>${k.ime}</td>
  				<td>${k.prezime}</td>
  				<td>${k.email}</td>
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