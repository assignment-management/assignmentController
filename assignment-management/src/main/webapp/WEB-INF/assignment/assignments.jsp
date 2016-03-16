
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../title/header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="pull-right">
    <p>
        <a href="${SITE_URL}/assignment-management/assignment/add" class="btn btn-primary"><span class="glyphicon glyphicon-plus"></span></a>
    </p>
</div>

<table class="table tab-content table-striped table-bordered ">
    <tr>
        <th>Assignment Id</th>
        <th>Assignment Title</th>
        <th>Assignment Description</th>
        <th>Total Student</th>
        <th>Submission Date</th>
        <th>Added Date</th>
        <th>Action</th>
    </tr>

    <c:forEach var="dept" items="${requestScope.assignments}">
        <tr>
            <td>${dept.id}</td>
            <td>${dept.title}</td>
            <td>${dept.description}</td>
            <td>${dept.totalStudent}</td>
            <td>${dept.submissionDate}</td>
            <td>${dept.addedDate}</td>
            <td>
                <a href="${SITE_URL}/assignment-management/assignments/edit.jsp?id=${dept.id}" class="btn btn-success"><span class="glyphicon glyphicon-pencil"></span></a>
                <a href="${SITE_URL}/assignment-management/assignments/delete?id= ${dept.id}" class="btn btn-danger" onclick="return confirm('are you suer')"><span class="glyphicon glyphicon-trash"></span></a>
            </td>
        </tr>
    </c:forEach>

</table>



<%@include file="../title/footer.jsp" %>