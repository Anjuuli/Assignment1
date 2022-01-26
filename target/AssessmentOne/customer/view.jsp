<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../templates/header.jsp" %>
<div class="container w-75 p-5">
    <h2 class="text-center">Customer</h2>
    <a href="./" class="btn btn-outline-primary">Back</a>
    <a href="add-update-customer" class="btn btn-primary float-end">Add Customer</a>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Customer ID</th>
            <th scope="col">Name</th>
            <th scope="col">Address</th>
            <th scope="col">Contact</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customers}" var="customer">
            <tr>
                <th scope="row">${customer.id}</th>
                <td>${customer.name}</td>
                <td>${customer.address}</td>
                <td>${customer.contact}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="../templates/footer.jsp" %>
