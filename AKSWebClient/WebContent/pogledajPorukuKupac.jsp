<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
	Poruke:
  		<thead><td>Datum Poruke</td><td>Tekst Poruke</td><td>Aukcija za koju se odnosi</td><td>Ko je poslao</td></thead>
  			<c:forEach var="p" items="${poruke}">
  			<tr>
  				<td>${p.datump}</td>
  				<td>${p.tekstp}</td>
  				<td>${p.aksaukcija.akspredmet.naziv}</td>
  				<td>${p.aksaukcija.akskorisnik1.username}</td>
  			</tr>
  			</c:forEach>
  		</table>
</body>
</html>