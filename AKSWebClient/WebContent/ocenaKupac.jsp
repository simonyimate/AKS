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
Unesite ime kupca za koji zelite da vidite komentare:<input type="text" name="kupac">
	<input type="submit" value="Prikazi komentare i ocene">
	<input type="hidden" name="type" value="commKup">
	<c:if test="${!empty KomentariKup}"> 
	<c:forEach var="k" items="${KomentariKup}">
  			<tr>
  				<td>${k.tekstk}</td>
  				<td>${k.ocena}</td>
  				
  			</tr>
  			</c:forEach>
	</c:if>
</form>
	<form action="/AKSWebClient/logovaniUser.jsp" method="get">
		<input type="submit" value="NAZAD"> 
	</form>
</body>
</html>