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
	Izaberite aukcije za koju zelite da ostavite komentar:
	<c:if test="${!empty aukcijeUspesneVlasnik}">
	<select name="auk">
		<c:forEach var="ak" items="${aukcijeUspesneVlasnik}">
			<option value="${ak.aukcijaId}">${ak.akspredmet.naziv}</option>
		</c:forEach>
		</select>
	
	<hr>
		<input type="hidden" name="type" value="commentKupac">
		Tekst komentara:<input type="text" name="text">
		Vasa ocena: <select name="oc">
					<option value="1">*</option>
					<option value="2">**</option>
					<option value="3">***</option>
					<option value="4">****</option>
					<option value="5">*****</option>
				</select>
		<%=request.getAttribute("por")%>
	<input type="submit" value="Posalji"> 
	</c:if>
</form>
	
<form action="/AKSWebClient/logovaniUser.jsp" method="get">
		<input type="submit" value="NAZAD"> 
		</form>
</body>
</html>