<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Calculator</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 50px;
            text-align: center;
        }

        .form-container {
            display: inline-block;
            text-align: left;
        }

        input, select, button {
            margin: 10px;
            padding: 5px;
        }
    </style>
</head>
<body>
<h1>Simple Calculator</h1>
<div class="form-container">
    <form action="/calculate" method="post">
        <label for="num1">Number 1:</label>
        <input type="number" step="any" id="num1" name="num1" required><br>

        <label for="operator">Operator:</label>
        <select id="operator" name="operator" required>
            <option value="+">+</option>
            <option value="-">-</option>
            <option value="*">×</option>
            <option value="/">÷</option>
        </select><br>

        <label for="num2">Number 2:</label>
        <input type="number" step="any" id="num2" name="num2" required><br>

        <button type="submit">Calculate</button>
    </form>
</div>

<h1>Calculator Result</h1>

<c:if test="${not empty result}">
    <div class="result">
        Result: ${result}
    </div>
</c:if>

<c:if test="${not empty error}">
    <div class="error">
        Error: ${error}
    </div>
</c:if>

</body>
</html>