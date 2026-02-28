<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Insurance Plans</title>
</head>
<body>

<h2>Available Insurance Plans</h2>

<table border="1">

<tr>
    <th>Plan Name</th>
    <th>Description</th>
    <th>Apply</th>
</tr>

<c:forEach var="plan" items="${plans}">

<tr>
    <td>${plan.name}</td>
    <td>${plan.description}</td>

    <td>
        <form action="apply" method="post">

            Customer ID:
            <input type="number" name="customerId" required />

            <input type="hidden" name="planId"
                   value="${plan.id}" />

            <input type="submit" value="Apply" />
        </form>
    </td>
</tr>

</c:forEach>

</table>

<br>
<a href="/">Back to Registration</a>

</body>
</html>