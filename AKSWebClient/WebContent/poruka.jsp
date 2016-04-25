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
	Izaberite aukcije za koju zelite da posaljete poruku kupcu:
	<c:if test="${!empty aukcijeUspesneVlasnik}">
	<select name="auk">
		<c:forEach var="ak" items="${aukcijeMoje}">
			<option value="${ak.akspredmet.predmetId}">${ak.akspredmet.naziv}</option>
		</c:forEach>
		</select>
	
	<hr>
		<input type="hidden" name="type" value="porukaKupac">
		Tekst poruke<input type="text" name="text">
		<%=request.getAttribute("lic")%>
	<input type="submit" value="Posalji"> 
	</c:if>
</form>
	
<form action="/AKSWebClient/logovaniUser.jsp" method="get">
		<input type="submit" value="NAZAD"> 
		</form>
</body>
</html>