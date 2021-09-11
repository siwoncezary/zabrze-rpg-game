<%@page language="java" pageEncoding="UTF-8" %>
<html>
<head>
</head>
<body>
<h1>Przygoda</h1>
<p>${adventure.description()}</p>
<ul>
    <li><a href="/takepart">Bierz udział</a></li>
    <li><a href="/adventure">Idź dalej</a></li>
    <li><a href="/start">Wracaj do miasta</a></li>
</ul>
</body>
</html>