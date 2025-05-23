<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Greeting</title>
</head>
<body>
<c:choose>
  <c:when test="${not empty name}">
    <h1>Hello: ${name}</h1>
  </c:when>
  <c:otherwise>
    <h1>Hello Spring MVC</h1>
  </c:otherwise>
</c:choose>

</body>
</html>