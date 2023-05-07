<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Simple Calculator</title>
</head>
<body>
<fieldset>
    <legend>Simple Calculator</legend>
    <form action="/calculator">
        <label for="firstOperand">The first operand</label>
        <input id="firstOperand" name="firstOperand" type="number" step="any" placeholder="Enter the first operand" required>
        <br><br>
        <label for="secondOperand">The second operand</label>
        <input id="secondOperand" name="secondOperand" type="number" step="any" placeholder="Enter the second operand" required>
        <br><br>
        <button name="operator" value="+">Addition(+)</button>
        <button name="operator" value="-">Subtraction(-)</button>
        <button name="operator" value="*">Multiplication(X)</button>
        <button name="operator" value="/">Division(/)</button>
        <c:if test="${result != null}">
            <hr>
            <p>${result}</p>
        </c:if>
    </form>
</fieldset>
</body>
</html>