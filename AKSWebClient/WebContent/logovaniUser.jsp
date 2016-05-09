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
	<input type="submit" value="Izlistavanje detalja" style="height:30px;width:300px"> 
</form>
<form action="/AKSWebClient/unosAukcije.jsp" method="get">
	<input type="submit" value="Unos nove aukcije" style="height:30px;width:300px"> 
</form>
<form action="/AKSWebClient/rezultatiLicitacija.jsp" method="get">
	<input type="submit" value="Pregledaj ishode licitacija" style="height:30px;width:300px"> 
</form>
<form action="/AKSWebClient/listaGdeSamUcestvovao.jsp" method="get">
	<input type="submit" value="Izlistaj listu predmeta na kojima sam ucestvovao" style="height:30px;width:300px"> 
</form>
<form action="/AKSWebClient/poruka.jsp" method="get">
	<input type="submit" value="Nova poruka za kupca" style="height:30px;width:300px"> 
</form>
<form action="/AKSWebClient/prodavacPoruka.jsp" method="get">
	<input type="submit" value="Nova poruka za prodavca" style="height:30px;width:300px"> 
</form>
<form action="/AKSWebClient/pogledajPorukuKupac.jsp" method="get">
	<input type="submit" value="Pogledaj poruke od kupca" style="height:30px;width:300px"> 
</form>
<form action="/AKSWebClient/pogledajPorukuProdavac.jsp" method="get">
	<input type="submit" value="Pogledaj poruke od prodavca" style="height:30px;width:300px"> 
</form>
<form action="/AKSWebClient/ocenaAndcomentars.jsp" method="get">
	<input type="submit" value="Oceni i komentarisi oglase kao kupac" style="height:30px;width:300px"> 
</form>
<form action="/AKSWebClient/ocenaAndcomentarsKupac.jsp" method="get">
	<input type="submit" value="Oceni i komentarisi oglase kao prodavac" style="height:30px;width:300px"> 
</form>
<form action="/AKSWebClient/ocenaProdavac.jsp" method="get">
	<input type="submit" value="Pogledaj ocene za prodavce" style="height:30px;width:300px"> 
</form>
<form action="/AKSWebClient/ocenaKupac.jsp" method="get">
	<input type="submit" value="Pogledaj ocene za kupce" style="height:30px;width:300px"> 
</form>

	Logovanje je : <%=request.getAttribute("result")%>
<form action="/AKSWebClient/index.jsp" method="get">
		<input type="submit" value="NAZAD"> 
</form>
</body>
</html>