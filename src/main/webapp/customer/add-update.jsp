<%@include file="../templates/header.jsp" %>
<div class="container w-75 p-5">
    <h2 class="text-center">Add a Customer</h2>
    <form action="./add-update-customer" method="POST">
        <div class="col-md-6 mt-3 w-100">
            <label for="name" class="form-label">Customer Name</label>
            <input type="text" class="form-control" id="name" name="name" required
                   placeholder="John Doe" value="">
        </div>

        <div class="row">
            <div class="col mb-3 w-75">
                <label for="address" class="col-sm-2 col-form-label">Address</label>
                <div class="col">
                    <input type="text" class="form-control" id="address" name="address" required
                           placeholder="London" value="">
                </div>
            </div>

            <div class="col mb-3 w-25">
                <label for="contact" class="col col-form-label">Contact Number</label>
                <div class="col">
                    <input type="number" class="form-control" id="contact" name="contact" required placeholder="123456789"
                           value="">
                </div>
            </div>
        </div>

        <div>
            <input type="hidden" class="form-control" id="id" name="id" value="">
        </div>

        <button type="submit" class="btn btn-primary float-end">${action}</button>
    </form>
</div>
<%@include file="../templates/footer.jsp" %>
