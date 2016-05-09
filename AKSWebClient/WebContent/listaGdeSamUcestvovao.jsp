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
</form>
	<form action="/AKSWebClient/logovaniUser.jsp" method="get">
		<input type="submit" value="NAZAD"> 
	</form>
</body>
</html>