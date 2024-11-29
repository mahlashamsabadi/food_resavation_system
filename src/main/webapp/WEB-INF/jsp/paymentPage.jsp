<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Payment Page</title>
</head>
<body>
<h1>Payment Details</h1>

<h2>Customer Information</h2>
<p>Full Name: ${paymentDetail.personDto.fullName}</p>
<p>National Codde: ${paymentDetail.personDto.nationalCode}</p>

<h2>Contacts</h2>
<table>
    <thead>
    <tr>
        <th>Contact Type</th>
        <th>Contact Value</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="contact" items="${paymentDetail.personDto.contacts}">
        <tr>
            <td>${contact.contactTypeName}</td>
            <td>${contact.value}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<h2>Addresses</h2>
<table>
    <thead>
    <tr>
        <th>Address</th>
        <th>City</th>
        <th>Postal Code</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="address" items="${paymentDetail.personDto.addresses}">
        <tr>
            <td>${address.value}</td>
            <td>${address.city}</td>
            <td>${address.postalCode}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<h2>Reservations</h2>
<table border="1">
    <thead>
    <tr>
        <th>Meal Name</th>
        <th>Meal Type</th>
        <th>Status</th>
        <th>Quantity</th>
        <th>Total Price</th>
        <th>Reservation Date</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${paymentDetail.reservationDtos}" var="reservation">
        <tr>
            <td>${reservation.mealName}</td>
            <td>${reservation.mealType}</td>
            <td>${reservation.status}</td>
            <td>${reservation.quantity}</td>
            <td>${reservation.totalPrice}</td>
            <td>${reservation.reservationDate}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<h3>Total Price: ${paymentDetail.totalPrice}</h3>
<form action="/confirmPayment" method="post">
    <input type="hidden" name="userId" value="${paymentDetail.personDto.userId}"/>
    <button type="submit">Pay</button>
</form>
</body>
</html>
