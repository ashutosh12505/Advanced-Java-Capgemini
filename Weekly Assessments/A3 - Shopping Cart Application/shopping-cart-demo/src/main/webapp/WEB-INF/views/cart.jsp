<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Your Cart</title>
</head>
<body>

<h2>Your Shopping Cart</h2>

<table border="1">

<tr>
    <th>Product</th>
    <th>Quantity</th>
    <th>Total</th>
    <th>Update</th>
    <th>Remove</th>
</tr>

<c:forEach var="item" items="${cartItems}">

<tr>

    <td>${item.product.name}</td>

    <!-- UPDATE -->
    <td>
        <form action="update" method="post">
            <input type="number" name="quantity"
                   value="${item.quantity}" min="1"/>
            <input type="hidden" name="productId"
                   value="${item.product.id}"/>
    </td>

    <td>${item.total}</td>

    <td>
            <input type="submit" value="Update"/>
        </form>
    </td>

    <!-- REMOVE -->
    <td>
        <form action="remove" method="post">
            <input type="hidden" name="productId"
                   value="${item.product.id}"/>
            <input type="submit" value="Remove"/>
        </form>
    </td>

</tr>

</c:forEach>

</table>

<br>
<h3>Total Amount: ${total}</h3>

<br>
<a href="products">Back to Products</a>

</body>
</html>