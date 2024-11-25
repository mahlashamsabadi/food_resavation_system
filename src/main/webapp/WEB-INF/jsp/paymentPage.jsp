<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Payment Page</title>
</head>
<body>
<h1>Payment Information</h1>
<h3>Client Information</h3>
<p>Name: ${person.name}</p>

<h3>Reservations</h3>
<table border="1">
    <thead>
    <tr>
        <th>Meal Name</th>
        <th>Price</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${reservations}" var="reservation">
        <tr>
            <td>${reservation.mealName}</td>
            <td>${reservation.price}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<h3>Total Price: ${totalPrice}</h3>

<form action="/payment/confirm" method="POST">
    <input type="hidden" name="userId" value="${user.id}" />
    <button type="submit">Confirm Payment</button>
</form>
</body>
</html>
