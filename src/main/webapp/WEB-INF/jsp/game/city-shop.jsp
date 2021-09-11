<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" pageEncoding="UTF-8" %>
<html>
<head>
</head>
<body>
<h1>Witaj w sklepie</h1>
<p>Masz  sztuk złota: ${hero.getMoney()}</p>
<p>Wybierz co chcesz kupić?</p>
<ul>
<c:forEach items="${items}" var="item" varStatus="status">
    <li><a href="/buyitem?id=${status.index}">${item.getName()} cena: ${item.getPrice()}</a></li>
</c:forEach>
</ul>
</body>
</html>