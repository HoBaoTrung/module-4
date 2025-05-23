<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Từ điển Anh - Việt</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 40px;
            max-width: 600px;
            margin: auto;
        }
        h1 {
            text-align: center;
        }
        input, button {
            padding: 10px;
            font-size: 16px;
        }
        #result {
            margin-top: 20px;
            font-weight: bold;
            color: #333;
        }
    </style>
</head>
<body>
<h1>Từ điển Anh - Việt</h1>
<form action="translate" method="post">
    <input type="text" name="word" placeholder="Nhập từ tiếng Anh..." required />
    <button type="submit">Tra cứu</button>
</form>

<div id="result">
    <c:if test="${not empty result}">
        ${result}
    </c:if>
</div>
</body>
</html>
