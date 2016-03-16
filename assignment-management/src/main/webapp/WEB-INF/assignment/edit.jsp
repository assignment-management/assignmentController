
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../title/header.jsp" %>
<h1>Edit Assignment</h1>
<form action="${SITE_URL}/assignment/edit" method="POST">
    <div class="form-group">
        <label >Name:</label>
        <c:out value="${submission.submittedBy}"/>
        <input type="text" name="submittedBy" required="required" placeholder="Submitted By:" class="form-control" value="${assignment.title}"/>
    </div>

    <div class="form-group">
        <label>Content</label>
        <textarea type="text" name="content" required="required" placeholder="Enter content" class="form-control" ></textarea>
    </div>

    <div class="checkbox">
        <label>Status:</label>
        <label />
        <input type="checkbox" name="status"/>Active</input>
        </label>
    </div>

    <div> 
        <button class="btn btn-success" type="submit">Save</button>
        <a href="${SITE_URL}/department" class="btn btn-danger">Back</a>
    </div>

</form>
<%@include file="../title/footer.jsp" %>
