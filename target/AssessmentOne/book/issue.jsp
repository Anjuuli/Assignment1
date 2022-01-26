<%@include file="../templates/header.jsp" %>
<div class="container w-75 p-5">
    <h2 class="text-center">Add a Book</h2>
    <form action="issue-book" method="post">
        <div class="col mt-3 w-100">
            <label for="customerId" class="form-label">Customer ID</label>
            <input type="number" class="form-control" id="customerId" name="customerId" required
                   placeholder="John Doe">
        </div>
        <input type="hidden" class="form-control" id="bookId" name="bookId" value="${bookId}">

        <button type="submit" class="btn btn-primary float-end mt-3">Issue</button>
    </form>
</div>
<%@include file="../templates/footer.jsp" %>
