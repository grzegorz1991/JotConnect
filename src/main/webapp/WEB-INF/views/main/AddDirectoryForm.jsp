<div class="col-12 grid-margin stretch-card">
    <div class="card">
        <div class="card-body">
            <h4 class="card-title">Create Directory</h4>
            <form action="/saveDirectory" method="post" class="forms-sample">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <div class="form-group">
                    <label for="exampleInputName">Name</label>
                    <input type="text" class="form-control" id="exampleInputName" name="name" placeholder="Name" required>
                </div>
                <div class="form-group">
                    <label for="parentDirectory">Parent Directory</label>
                    <select class="form-control" id="parentDirectory" name="parentDirectory.id" required>
                        <option value="">Select a Parent Directory</option>
                        <c:forEach var="directory" items="${directories}">
                            <option value="${directory.id}">${directory.name}</option>
                        </c:forEach>
                    </select>
                </div>

                <button type="submit" class="btn btn-primary mr-2">Save Directory</button>
                <button type="button" class="btn btn-dark" onclick="goBack()">Cancel</button>
            </form>
        </div>
    </div>
</div>

<script>
    function goBack() {
        window.history.back();
    }
</script>
