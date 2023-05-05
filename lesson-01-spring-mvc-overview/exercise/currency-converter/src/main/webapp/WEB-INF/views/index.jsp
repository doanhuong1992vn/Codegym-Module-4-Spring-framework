<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Currency Converter</title>
</head>
<body>
<form action="/convert" method="get">
    <fieldset>
        <legend>Currency Converter From USD To VND</legend>
        <div class="form-group">
            <label for="currency">USD</label>
            <input type="number" step="any" name="currency" class="form-control" id="currency" placeholder="Nhập USD"
            <c:if test="${currency != null}"> value="${currency}"</c:if>
            >
        </div>
        <div class="form-group">
            <label for="rate">Exchange rate</label>
            <input type="number" step="any" name="rate" class="form-control" id="rate" value="${rate}">
        </div>
        <div class="form-group">
            <button>Convert</button>
        </div>
        <c:if test="${result != null}">
            <c:out value="Result = ${result} VNĐ"/>
        </c:if>
    </fieldset>
</form>
</body>
</html>