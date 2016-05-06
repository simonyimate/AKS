<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/AKSWebClient/MainServlet" method="get">
	<input type="hidden" name="type" value="pogledajPorukuProdavac">
	Izaberite aukciju za koju zelite da pogledate poruke:
	<c:if test="${!empty aukcijeUspesneKupac}"> 
		<select name="auk">
		<c:forEach var="ak" items="${aukcijeUspesneKupac}">
			<option value="${ak.aukcijaId}">${ak.akspredmet.naziv}</option>
		</c:forEach>
		</select>
	
	<input type="submit" value="Prikazi poruke">
	<c:if test="${!empty poruke}">
	Poruke:  
	<table>
  		<thead><td>Datum Poruke</td><td>Tekst Poruke</td><td>Aukcija za koju se odnosi</td><td>Ko je poslao</td></thead>
  			<c:forEach var="p" items="${poruke}">
  			<tr>
  				<td>${p.datump}</td>
  				<td>${p.tekstp}</td>
  				<td>${p.aksaukcija.akspredmet.naziv}</td>
  				<c:if test="${p.prodavacp == true}"> 
  					<td><font color="red">${p.aksaukcija.akskorisnik1.username}</font></td>
  				</c:if>
  				<c:if test="${p.prodavacp == false}"> 
  					<td><font color="green">${p.aksaukcija.akskorisnik2.username}</font></td>
  				</c:if>
  			</tr>
  			</c:forEach>
  		</table>
  		</c:if>
  	</c:if>
</form>
  		<form action="/AKSWebClient/logovaniUser.jsp" method="get">
		<input type="submit" value="NAZAD"> 
		</form>
</body>
</html>