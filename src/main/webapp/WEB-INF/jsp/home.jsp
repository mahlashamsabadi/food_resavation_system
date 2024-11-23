<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <title>Home Page</title>
</head>
<body>
<div class="header">
    <h1>Welcome to the Food Reservation System</h1>
</div>
<div class="content">

    <div class="sidebar">
        <c:forEach items="${user.roleDtoList}" var="role">
            <c:if test="${role.code == 'EMPLOYEE'}">
                <button type="button" onclick="viewReservationHistory(${user.id})">Reservation History</button>
            </c:if>
        </c:forEach>
    </div>

    <c:if test="${not empty user}">
        <p>Welcome back, ${user.username}!</p>

        <h3>Daily Meal</h3>
        <table>
            <thead>
            <tr>
                <th>Meal Name</th>
                <th>Meal Type</th>
                <th>Price</th>
                <th>Available Date</th>
                <th>Inventory</th>
                <th>Food Items</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${meals}" var="meal">
                <tr id="meal-row-${meal.id}">
                    <td>${meal.name}</td>
                    <td>${meal.mealTypeName}</td>
                    <td>${meal.price}</td>
                    <td>${meal.availableDate}</td>
                    <td>${meal.inventory}</td>
                    <td>${meal.foodItemName}</td>
                    <td>
                        <c:forEach items="${user.roleDtoList}" var="role">
                            <c:if test="${role.code == 'EMPLOYEE'}">
                                <button type="button" onclick="reserveMeal(${user.id},${meal.id})">Reserve</button>
                            </c:if>
                            <c:if test="${role.code == 'STAFF'}">
                                <button type="button" onclick="modifyMeal(${meal.id})">Edit</button>
                                <button type="button" onclick="deleteMeal(${meal.id})">Delete</button>
                            </c:if>
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <c:forEach items="${user.roleDtoList}" var="role">
            <c:if test="${role.code == 'STAFF'}">
                <button type="button" onclick="openAddMealDialog()">Add Meal</button>
            </c:if>
            <c:if test="${role.code == 'ADMIN'}">
                <button type="button" onclick="generateReport()">Generate Report</button>
            </c:if>
        </c:forEach>

    </c:if>

    <c:if test="${empty user}">
        <div>
            <form action=/home/login" method="GET">
                <button type="submit">Login</button>
            </form>
        </div>
    </c:if>
</div>
<div id="mealModal"
     style="display:none; position: fixed; top: 50%; left: 50%; transform: translate(-50%, -50%); padding: 20px; background-color: white; border: 1px solid #ccc; width: 400px; z-index: 1000;">
    <h3>Meal Details</h3>
    <form id="mealForm">
        <input type="hidden" id="mealId">
        <input type="hidden" id="formMode" value="add">
        <div>
            <label for="mealName">Meal Name:</label>
            <input type="text" id="mealName" name="mealName" required>
        </div>
        <div>
            <label for="mealType">Meal Type:</label>
            <select id="mealType" name="mealType" required>
                <c:forEach items="${mealTypes}" var="mealType">
                    <option value="${mealType.id}">${mealType.name}</option>
                </c:forEach>
            </select>
        </div>
        <div>
            <label for="mealPrice">Price:</label>
            <input type="number" id="mealPrice" name="mealPrice" required>
        </div>
        <div>
            <label for="mealInventory">Inventory:</label>
            <input type="number" id="mealInventory" name="mealInventory" required>
        </div>
        <div>
            <label for="availableDate">Available Date:</label>
            <input type="date" id="availableDate" name="availableDate" required>
        </div>
        <div>
            <label for="foodItems">Food Items:</label>
            <select id="foodItems" name="foodItems">
                <c:forEach items="${foodItems}" var="foodItem">
                    <option value="${foodItem.id}">${foodItem.name}</option>
                </c:forEach>
            </select>
        </div>
        <div>
            <button type="button" onclick="saveMeal()">Save Meal</button>
            <button type="button" onclick="closeModal()">Cancel</button>
        </div>
    </form>
</div>
</body>
</html>

<script>
    function modifyMeal(mealId) {
        var row = document.getElementById("meal-row-" + mealId);
        var mealName = row.cells[0].innerText;
        var mealDescription = row.cells[1].innerText;
        var price = row.cells[2].innerText;
        var availableDate = row.cells[3].innerText;
        var inventory = row.cells[4].innerText;

        $('#mealId').val(mealId);
        $('#mealName').val(mealName);
        $('#mealDescription').val(mealDescription);
        $('#mealPrice').val(price);
        $('#mealInventory').val(inventory);
        $('#availableDate').val(availableDate);
        $('#formMode').val('edit');
        $('#mealModal').show();
    }


    function openAddMealDialog() {
        $('#mealId').val('');
        $('#mealName').val('');
        $('#mealDescription').val('');
        $('#mealPrice').val('');
        $('#mealInventory').val('');
        $('#availableDate').val('');
        $('#formMode').val('add');
        $('#mealModal').show();
    }

    function saveMeal() {
        debugger
        var mealData = {
            id: $('#mealId').val() !== "" ? $('#mealId').val() : -1,
            name: $('#mealName').val(),
            mealTypeId: $('#mealType').val(),
            price: $('#mealPrice').val(),
            inventory: $('#mealInventory').val(),
            availableDate: $('#availableDate').val(),
            foodItemId: $('#foodItems').val()
        };
        var formMode = $('#formMode').val();
        var url = formMode === 'edit' ? '/meal/edit' : '/meal/add';
        $.ajax({
            url: url,
            type: 'POST',
            data: mealData,
            success: function (response) {
                alert("Meal saved successfully!");
                $('#mealModal').hide();
                window.location.reload();
            },
            error: function (error) {
                alert("Error saving meal!");
            }
        });
    }

    function closeModal() {
        $('#mealModal').hide();
    }

    function deleteMeal(mealId) {
        $.ajax({
            url: '/meal/delete',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({id: mealId}),
            success: function (response) {
                window.location.reload();
            }
        });
    }

    function reserveMeal(userId, mealId) {
        $.ajax({
            url: '/reservation/create',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({
                userId: userId,
                mealId: mealId
            }),
            success: function (response) {
                alert('Reservation created successfully!');
            },
        });
    }

    function viewReservationHistory(userId) {
        window.location.href = '/reservation/showHistory/' + userId;
    }

</script>