<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Currency Converter</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
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
<div>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</div>
</body>
</html>