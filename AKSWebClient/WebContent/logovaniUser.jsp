<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ulogovani User</title>
</head>
<body>
	<form action="/AKSWebClient/Izlistaj.jsp" method="get">
	<input type="submit" value="Izlistavanje detalja"> 
</form>
<form action="/AKSWebClient/unosAukcije.jsp" method="get">
	<input type="submit" value="Unos nove aukcije"> 
</form>
<form action="/AKSWebClient/rezultatiLicitacija.jsp" method="get">
	<input type="submit" value="Pregledaj ishode licitacija"> 
</form>
<form action="/AKSWebClient/listaGdeSamUcestvovao.jsp" method="get">
	<input type="submit" value="Izlistaj listu predmeta na kojima sam ucestvovao"> 
</form>
<form action="/AKSWebClient/poruka.jsp" method="get">
	<input type="submit" value="Nova poruka za kupca"> 
</form>
<form action="/AKSWebClient/prodavacPoruka.jsp" method="get">
	<input type="submit" value="Nova poruka za prodavca"> 
</form>
<form action="/AKSWebClient/pogledajPorukuKupac.jsp" method="get">
	<input type="submit" value="Pogledaj poruke od kupca"> 
</form>
<form action="/AKSWebClient/pogledajPorukuProdavac.jsp" method="get">
	<input type="submit" value="Pogledaj poruke od prodavca"> 
</form>
<form action="/AKSWebClient/ocenaAndcomentars.jsp" method="get">
	<input type="submit" value="Oceni i komentarisi oglase kao kupac"> 
</form>
<form action="/AKSWebClient/ocenaAndcomentarsKupac.jsp" method="get">
	<input type="submit" value="Oceni i komentarisi oglase kao prodavac"> 
</form>
<form action="/AKSWebClient/ocenaProdavac.jsp" method="get">
	<input type="submit" value="Pogledaj ocene za prodavce"> 
</form>
<form action="/AKSWebClient/ocenaKupac.jsp" method="get">
	<input type="submit" value="Pogledaj ocene za kupce"> 
</form>

	Logovanje je : <%=request.getAttribute("result")%>
<form action="/AKSWebClient/index.jsp" method="get">
		<input type="submit" value="NAZAD"> 
</form>
</body>
</html>