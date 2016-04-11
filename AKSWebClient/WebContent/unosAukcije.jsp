<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Unos nove aukcije</title>
</head>
<body>
<form action="/AKSWebClient/MainServlet" method="get">
		
		Dan: <input type="text" name="dan">
		Sat:<input type="text" name="sat">
		Predmet:
		<br>
			Naziv:<input type="text" name="naziv">
			Opis:<input type="text" name="opis">
			<select name="stanje">
				<option value="novo">novo</option>
				<option value="polovno">polovno</option>
				<option value="neispravno">neispravno</option>
			</select>
			Pocetna Cena:<input type="text" name="pocetnaCena">
			Path slika:<input type="text" name="slika">
		
	<input type="hidden" name="type" value="aukcija"> 
	<input type="submit" value="Kreiraj aukciju">
	
</form>
	<form action="/AKSWebClient/index.jsp" method="get">
		<input type="submit" value="NAZAD"> 
	</form>
</body>
</html>