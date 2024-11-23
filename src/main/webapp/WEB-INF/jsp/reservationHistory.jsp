<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reservation History</title>
</head>
<body>
<h1>Reservation History</h1>
<c:if test="${not empty reservations}">
    <table>
        <thead>
        <tr>
            <th>meal name</th>
            <th>meal type</th>
            <th>status</th>
            <th>quantity</th>
            <th>total price</th>
            <th>reservation date</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${reservations}" var="reservation">
            <p>${reservation}</p>
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
            data: JSON.stringify({ id: id }),
            success: function (response) {
                window.location.reload();
            }
        });
    }
</script>
