<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Reservation History</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<h1>Reservation History</h1>
<c:if test="${not empty reservations}">
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
        <c:forEach items="${reservations}" var="reservation">
            <tr>
                <td>${reservation.mealName}</td>
                <td>${reservation.mealType}</td>
                <td>${reservation.status}</td>
                <td>${reservation.quantity}</td>
                <td>${reservation.totalPrice}</td>
                <td>${reservation.reservationDate}</td>
                <td>
                    <button onclick="deleteReservation(${reservation.id})">Delete</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <button type="button" onclick="redirectToPaymentPage(${user.id})">Pay</button>
</c:if>
<a href="/home">Back to Home</a>
<c:if test="${empty reservations}">
    <p>No reservations found.</p>
</c:if>
</body>
</html>
<script>
    function deleteReservation(id) {
        $.ajax({
            url: '/reservation/delete',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({id: id}),
            success: function (response) {
                alert("Reservation deleted successfully.");
                window.location.reload();
            },
            error: function () {
                alert("Failed to delete reservation. Please try again.");
            }
        });

    }

    function redirectToPaymentPage(userId) {
        window.location.href = '/payment?userId=' + userId;
    }

</script>
