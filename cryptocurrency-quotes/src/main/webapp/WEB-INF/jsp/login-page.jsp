<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${userId != null}">
    <c:redirect url="/${userId}"/>
</c:if>
<!doctype HTML>
<html>
<head>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta charset="utf-8">
    <title>Home</title>
</head>
<body>
</body>
    <h1>Authorization</h1>
    ${exception}
    <form action="/check-login" method="post">
        <input type="text" placeholder="Nickname" name="nickname" autofocus/><br>
        <input type="text" placeholder="Crypto symbol" name="symbol"/><br>
        <button type="submit">Login/Registration</button>
    </form>
    <a href ="/available-cryptocurrencies">
        <button type="button">Available cryptocurrencies</button>
    </a>
</html>