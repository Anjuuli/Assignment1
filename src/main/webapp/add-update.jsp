<%@include file="./templates/header.jsp" %>
<div class="container w-75 p-5">
    <h2 class="text-center">Add a Book</h2>
    <form action="./add-update" method="POST">
        <div class="col-md-6 mt-3 w-100">
            <label for="bookName" class="form-label">Book Name</label>
            <input type="text" class="form-control" id="bookName" name="bookName" required
                   placeholder="Goosebumps - Stay Out of the Basement" value="${book.bookName}">
        </div>

        <div class="row">
            <div class="col mb-3 w-75">
                <label for="author" class="col-sm-2 col-form-label">Author</label>
                <div class="col">
                    <input type="text" class="form-control" id="author" name="author" required
                           placeholder="R. L. Stine" value="${book.author}">
                </div>
            </div>

            <div class="col mb-3 w-25">
                <label for="stock" class="col-sm-2 col-form-label">Stock</label>
                <div class="col">
                    <input type="number" class="form-control" id="stock" name="stock" required placeholder="10"
                           value="${book.stock}">
                </div>
            </div>
        </div>

        <div>
            <input type="hidden" class="form-control" id="id" name="id" value="${book.id}">
        </div>

        <button type="submit" class="btn btn-primary float-end">${action}</button>
    </form>
</div>
<%@include file="./templates/footer.jsp" %>
