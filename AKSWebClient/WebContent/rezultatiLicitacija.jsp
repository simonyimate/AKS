<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rezultati Licitacija</title>
</head>
<body>
<table>
	Aukcija:
  		<thead><td>Naziv Predmeta</td><td>Opis Predmeta</td><td>Stanje Predmeta</td><td>Vlasnik Predmeta</td><td>Najveca Ponuda</td><td>Vreme</td></thead>
  			<c:forEach var="a" items="${aukcije}">
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
</body>
</html>