<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login - Food Reservation System</title>
</head>
<body>
<div>
    <h2>Login to Your Account</h2>

    <div>
        <form action="/home/login" method="POST">
            <input type="text" name="username" placeholder="Username" required/>
            <input type="password" name="password" placeholder="Password" required/>
            <button type="submit">Login</button>
        </form>
        <c:if test="${not empty errorMessage}">
            <p style="color: red; text-align: center;">${errorMessage}</p>
        </c:if>
    </div>
</div>
</body>
</html>
