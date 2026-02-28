<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Product Catalog</h2>

<table border="1">
<tr>
    <th>Name</th>
    <th>Price</th>
    <th>Quantity</th>
    <th>Action</th>
</tr>

<c:forEach var="p" items="${products}">
<tr>
    <form action="add" method="post">
        <td>${p.name}</td>
        <td>${p.price}</td>
        <td>
            <input type="number" name="quantity" value="1" min="1"/>
            <input type="hidden" name="productId" value="${p.id}"/>
        </td>
        <td>
            <input type="submit" value="Add to Cart"/>
        </td>
    </form>
</tr>
</c:forEach>
</table>

<br>
<a href="cart">View Cart</a>