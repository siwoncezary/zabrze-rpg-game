<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" pageEncoding="UTF-8" %>
<html>
<head>
</head>
<body>
<h2>Stan inwentarza po przygodzie</h2>
<ul>
    <c:forEach items="${hero.getInventory()}" var="item">
        <li>${item.getName()}</li>
    </c:forEach>
</ul>
<h2>Posiadasz sztuk złota: ${hero.getMoney()}</h2>
<br>
<a href="/adventure">Dalej</a>
</body>
</html>