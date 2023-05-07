<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Condiments</title>
</head>
<body>
<h1>Condiments has chose</h1>
<c:forEach items="${condiments}" var="condiment">
    <p>${condiment}</p>
</c:forEach>
</body>
</html>
