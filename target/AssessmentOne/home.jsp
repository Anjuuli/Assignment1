<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="./templates/header.jsp" %>
<div class="container w-75 p-5">
    <h2 class="text-center">Book Management System</h2>
    <a href="add-update" class="btn btn-primary float-end">Add Book</a>
    <a href="customer" class="btn btn-outline-secondary float-end me-2">Check Customer</a>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Book ID</th>
            <th scope="col">Name</th>
            <th scope="col">Author</th>
            <th scope="col">Stock</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${books}" var="book">
            <tr>
                <th scope="row">${book.id}</th>
                <td>${book.name}</td>
                <td>${book.author}</td>
                <td>${book.stock}</td>
                <td>
                    <a href="./issue-book?id=${book.id}" class="btn btn-sm btn-outline-primary">Issue</a>
                    <a href="./add-update?id=${book.id}" class="btn btn-sm btn-outline-secondary">Edit</a>
                    <a href="./delete-book?id=${book.id}" class="btn btn-sm btn-outline-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="./templates/footer.jsp" %>
