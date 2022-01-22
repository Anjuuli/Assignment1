<%@include file="./templates/header.jsp" %>
<div class="container w-75 p-5">
    <h2 class="text-center">Add a Book</h2>
    <form>
        <div class="col mt-3 w-100">
            <label for="customerName" class="form-label">Customer Name</label>
            <input type="email" class="form-control" id="customerName" name="customerName" required
                   placeholder="John Doe">
        </div>

        <button type="submit" class="btn btn-primary float-end mt-3">Issue</button>
    </form>
</div>
<%@include file="./templates/footer.jsp" %>
