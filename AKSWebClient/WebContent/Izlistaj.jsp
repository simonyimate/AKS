<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Izlistaj</title>
</head>
<body>
<form action="/AKSWebClient/MainServlet" method="get">
		Naziv: <input type="text" name="naziv">
		Stanje: <input type="text" name="stanje">
		<input type="hidden" name="type" value="izlistaj"> 
		<select name="tip1">
			<option value="aktivna">aktivna</option>
			<option value="zavrsena">zavrsena</option>
			<option value="sve">sve</option>
		</select>
		<select name="tip2">
			<option value="naziv">naziv</option>
			<option value="nazivVlasnik">nazivVlasnik</option>
			<option value="nazivStanje">nazivStanje</option>
			<option value="nazivCena">nazivCena</option>
		</select>
		Dolnja Cena: <input type="text" name="dolnjaCena">
		Gornja Cena: <input type="text" name="gornjaCena">
	<input type="submit" value="Izlistaj"> 
	<c:if test="${!empty aukcije}"> 
	<br>Aukcije: 
  		<table>
  		<thead><td>Najvecaponuda</td><td>Uspesna</td><td>Vreme</td><td>Naziv Predmeta</td>
  		<td>Opis Predmeta</td></thead>
  			<c:forEach var="a" items="${aukcije}">
  			<tr>
  				<td>${a.najvecaponuda}</td>
  				<td>${a.uspesna}</td>
  				<td>${a.vreme}</td>
  				<td>${a.akspredmet.naziv}</td>
  				<td>${a.akspredmet.opis}</td>
  				
  			</tr>
  			</c:forEach>
  		</table>
  		</c:if>
</form>
	<form action="/AKSWebClient/index.jsp" method="get">
		<input type="submit" value="NAZAD"> 
	</form>
</body>
</html>