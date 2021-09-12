<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" pageEncoding="UTF-8" %>
<html>
<head>
</head>
<body>
<h1>Witaj w mieście</h1>
<h2>Twój inwentarz</h2>
<ul>
    <c:forEach items="${hero.getInventory()}" var="item">
    <li>${item.getName()}</li>
    </c:forEach>
</ul>
<h2>Posiadasz sztuk złota: ${hero.getMoney()}</h2>
<p>Wybierz co chcesz robić?</p>
<a href="/adventure">Idź na południe</a><br>
<a href="/adventure">Idź na wschód</a><br>
<a href="/shop">Kup coś</a><br>
<a href="/sell">Sprzedaj coś</a><br>
<a href="/rumours">Posłuchaj plotek</a><br>
<a href="/">Koniec</a><br>

</body>
</html>