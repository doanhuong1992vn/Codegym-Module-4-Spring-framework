<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Condiments</title>
</head>
<body>
<h1>Condiments has chose</h1>
<ul>
    <c:forEach items="${condiments}" var="condiment">
        <li>${condiment}</li>
    </c:forEach>
</ul>
</body>
</html>
