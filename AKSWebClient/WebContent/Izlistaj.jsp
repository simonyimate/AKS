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
		<table>
		<tr><td>Filtriraj po</td><td>
		<select name="tip2">
			<option value="naziv">naziv</option>
			<option value="nazivVlasnik">nazivVlasnik</option>
			<option value="nazivStanje">nazivStanje</option>
			<option value="nazivCena">nazivCena</option>
		</select>
		</td></tr>
		<tr><td>Status Aukcije:</td><td>
		<select name="tip1">
			<option value="aktivna">aktivna</option>
			<option value="zavrsena">zavrsena</option>
			<option value="sve">sve</option>
		</select>
		</td></tr>
		<tr><td>Naziv: </td><td><input type="text" name="naziv"></td></tr>
		<tr><td>Vlasnik: </td><td><input type="text" name="vlasnik"></td></tr>
		<input type="hidden" name="type" value="izlistaj">
		<tr><td>Stanje: </td>
		<td><select name="stanje">
				<option value="novo">novo</option>
				<option value="polovno">polovno</option>
				<option value="neispravno">neispravno</option>
			</select> 
		</td></tr>
		<tr><td>Dolnja Cena: <input type="number" name="dolnjaCena" size="10" step="0.01"></td><td>
		Gornja Cena: <input type="number" name="gornjaCena" size="10" step="0.01"></td></tr>
		</table>
	<input type="submit" value="Izlistaj"> 
	<c:if test="${!empty aukcije}"> 
	<br>Aukcije: 
  		<table>
  		<thead><td width="13%">Naziv Predmeta</td><td width="13%">Opis Predmeta</td><td width="13%">Stanje Predmeta</td><td width="13%">Vlasnik Predmeta</td><td width="13%">Najveca Ponuda</td><td width="13%">Vreme</td></thead>
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
  		</c:if>
</form>
<form action="/AKSWebClient/MainServlet" method="get">
	<c:if test="${!empty aukcije}"> 
		<%-- <c:if test="${tip1 != zvr}"> --%> 
		<input type="hidden" name="type" value="licitiraj">
		Izaberite aukciju za koju zelite da date ponudu:
			
			<select name="auk">
			<c:forEach var="ak" items="${aukcije}">
			
				<option value="${ak.akspredmet.predmetId}">${ak.akspredmet.naziv}</option>
			
			</c:forEach>
			</select>
			Unesite iznos licitacije:
			
			<input type="number" name="iznos">
			<input type="submit" value="LICITIRAJ">
			  <%=request.getAttribute("lic")%>
		<%--</c:if>--%>
	</c:if>
</form>
	<form action="/AKSWebClient/index.jsp" method="get">
		<input type="submit" value="NAZAD"> 
	</form>
</body>
</html>