<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chọn gia vị cho Sandwich</title>
</head>
<body>
<h2>Chọn gia vị cho Sandwich</h2>
<form method="post" action="save">
    <c:forEach items="${condimentsList}" var="condiment">
        <input type="checkbox" name="condiments" value="${condiment}"/>
        <label>${condiment}</label>
    </c:forEach>
    <button type="submit">Save</button>
</form>

<h2>Gia vị đã chọn cho Sandwich</h2>
<div>
    <c:if test="${selectedCondiments != null and not empty selectedCondiments}">
        <ul>
            <c:forEach items="${selectedCondiments}" var="condiment">
                <li>${condiment}</li>
            </c:forEach>
        </ul>
    </c:if>
</div>
<c:if test="${selectedCondiments == null and empty selectedCondiments}">
    <div>
        <p>Chưa chọn gia vị nào!</p>
    </div>
</c:if>
</body>
</html>
