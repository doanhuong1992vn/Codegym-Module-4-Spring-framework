<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<form action="/search" method="get">
    <fieldset>
        <legend>Dictionary Web Application</legend>
        <table>
            <tr>
                <td><label for="word">English: </label></td>
                <td><input type="text" name="word" id="word" placeholder="Enter word" value="${word}"></td>
            </tr>
            <tr>
                <td>Vietnamese: </td>
                <td>${result}</td>
            </tr>
            <tr>
                <td></td>
                <td><button>Search</button></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>