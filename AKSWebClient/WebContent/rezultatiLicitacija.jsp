<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rezultati Licitacija</title>
</head>
<body>
<form action="/AKSWebClient/MainServlet" method="get">
	<input type="submit" value="Izlistaj ishode licitacije">
	<input type="hidden" name="type" value="ishodLicitacije">
	<c:if test="${!empty aukcijeSveVlasnik}"> 
	<table>
	Sve Aukcija gde sam vlasnik:
  		<thead><td width="13%">Naziv Predmeta</td><td width="13%">Opis Predmeta</td><td width="13%">Stanje Predmeta</td><td width="13%">Vlasnik Predmeta</td><td width="13%">Najveca Ponuda</td><td width="13%">Vreme</td><td width="13%">Uspesna</td></thead>
  			<c:forEach var="a" items="${aukcijeSveVlasnik}">
  			<tr>
  				<td>${a.akspredmet.naziv}</td>
  				<td>${a.akspredmet.opis}</td>
  				<td>${a.akspredmet.stanje}</td>
  				<td>${a.akskorisnik1.username}</td>
  				<td>${a.najvecaponuda}</td>
  				<td>${a.vreme}</td>
  				<c:if test="${a.uspesna==true}"> 
  					<td><font color="green">${a.uspesna}</font></td>
  				</c:if>
  				<c:if test="${a.uspesna==false}"> 
  					<td><font color="red">${a.uspesna}</font></td>
  				</c:if>
  				
  			</tr>
  			</c:forEach>
  		</table>
	</c:if>
	<hr>
	<c:if test="${!empty aukcijeSveLicit}"> 
	<table>
	Sve Aukcija gde sam licitirao:
  		<thead><td>Naziv Predmeta</td><td>Opis Predmeta</td><td>Stanje Predmeta</td><td>Vlasnik Predmeta</td><td>Najveca Ponuda</td><td>Vreme</td><td>Uspesna</td></thead>
  			<c:forEach var="a" items="${aukcijeSveLicit}">
  			<tr>
  				<td>${a.akspredmet.naziv}</td>
  				<td>${a.akspredmet.opis}</td>
  				<td>${a.akspredmet.stanje}</td>
  				<td>${a.akskorisnik1.username}</td>
  				<td>${a.najvecaponuda}</td>
  				<td>${a.vreme}</td>
  				<%-- <c:if test2="${==a.}"> --%>
  				<td>${a.uspesna}</td>
  			</tr>
  			</c:forEach>
  		</table>
	</c:if>
	<hr>
	<%--<c:if test="${!empty aukcijeUspesneVlasnik}"> 
	<table>
	Sve uspesne Aukcija gde sam vlasnik:
  		<thead><td>Naziv Predmeta</td><td>Opis Predmeta</td><td>Stanje Predmeta</td><td>Vlasnik Predmeta</td><td>Najveca Ponuda</td><td>Vreme</td><td>Uspesna</td></thead>
  			<c:forEach var="a" items="${aukcijeUspesneVlasnik}">
  			<tr>
  				<td>${a.akspredmet.naziv}</td>
  				<td>${a.akspredmet.opis}</td>
  				<td>${a.akspredmet.stanje}</td>
  				<td>${a.akskorisnik1.username}</td>
  				<td>${a.najvecaponuda}</td>
  				<td>${a.vreme}</td>--%>
  				<%-- <c:if test2="${==a.}"> --%>
  				<%-- <td>${a.uspesna}</td>
  			</tr>
  			</c:forEach>
  		</table>
	</c:if>
	<hr>
	<c:if test="${!empty aukcijeUspesneKupac}"> 
	<table>
	Sve uspesne Aukcija gde sam kupac:
  		<thead><td>Naziv Predmeta</td><td>Opis Predmeta</td><td>Stanje Predmeta</td><td>Vlasnik Predmeta</td><td>Najveca Ponuda</td><td>Vreme</td><td>Uspesna</td></thead>
  			<c:forEach var="a" items="${aukcijeUspesneKupac}">
  			<tr>
  				<td>${a.akspredmet.naziv}</td>
  				<td>${a.akspredmet.opis}</td>
  				<td>${a.akspredmet.stanje}</td>
  				<td>${a.akskorisnik1.username}</td>
  				<td>${a.najvecaponuda}</td>
  				<td>${a.vreme}</td>--%>
  				<%-- <c:if test2="${==a.}"> --%>
  				<%--<td>${a.uspesna}</td>
  			</tr>
  			</c:forEach>
  		</table>
	</c:if>--%>
</form>
</form>
	<form action="/AKSWebClient/logovaniUser.jsp" method="get">
		<input type="submit" value="NAZAD"> 
	</form>
</body>
</html>