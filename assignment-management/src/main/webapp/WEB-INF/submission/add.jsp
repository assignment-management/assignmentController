
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../title/header.jsp" %>
<div class="container">
    <h1>Add Submission</h1>
    <form action="${SITE_URL}/submission/" method="POST">
        <div class="form-group">
            <label>Submitted By:</label>
            <input type="text" name="dept_name" required="required" placeholder="Enter department name:" class="form-control"/>
        </div>

        <div class="form-group">
            <label>Content:</label>
            <textarea type="text" name="description" required="required" placeholder="Enter department Description" class="form-control" ></textarea>
        </div>

        <div class="form-group">
            <label>Marks:</label>
            <input type="number" name="dept_name" required="required" placeholder="Enter department name:" class="form-control"/>
        </div>

        <div class="form-group">
            <label>Submitted date</label>

        </div>

        <div>
            <button class="btn btn-success" type="submit">Save</button>
            <a href="${SITE_URL}/department" class="btn btn-danger">Back</a>
        </div>

    </form>
</div>
<%@include file="../title/footer.jsp" %>