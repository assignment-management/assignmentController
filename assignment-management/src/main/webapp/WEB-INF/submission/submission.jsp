
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../title/header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

<div class="pull-right">
    <p>
        <a href="${SITE_URL}/assignment-management/submission/add" class="btn btn-primary"><span class="glyphicon glyphicon-plus"></span></a>
    </p>
</div>

<table class="table tab-content table-striped table-bordered ">
    <tr>
        <th>Submission Id</th>
        <th>Submitted By</th>
        <th>Content</th>
        <th>Marks</th>
        <th>Submission Date</th>
        <th>Action</th>
    </tr>

    <c:forEach var="dept" items="${requestScope.submission}">
        <tr>
            <td>${dept.id}</td>
            <td>${dept.submittedBy}</td>
            <td>${dept.content}</td>
            <td>
                ${dept.marks}
            </td>
            <td>${dept.submissionDate}</td>
            <td>
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@getbootstrap">Open modal for @getbootstrap</button>
                <a href="${SITE_URL}/assignment-management/submission/edit.jsp?id=${dept.id}" class="btn btn-success"><span class="glyphicon glyphicon-pencil"></span></a>
                <a href="${SITE_URL}/assignment-management/submission/delete?id= ${dept.id}" class="btn btn-danger" onclick="return confirm('are you suer')"><span class="glyphicon glyphicon-trash"></span></a>
            </td>
        </tr>
    </c:forEach>
</table>



<script>
    $('#exampleModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget);
        var recipient = button.data('whatever');
        // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
        // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
        var modal = $(this);
        modal.find('.modal-title').text('New message to ' + recipient);
        modal.find('.modal-body input').val(recipient);
    });
</script>

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="exampleModalLabel">New message</h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="recipient-name" class="control-label">Recipient:</label>
                        <input type="text" class="form-control" id="recipient-name">
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="control-label">Message:</label>
                        <textarea class="form-control" id="message-text"></textarea>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Send message</button>
            </div>
        </div>
    </div>
</div>
















<%@include file="../title/footer.jsp" %>