
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="../title/header.jsp" %>
<div class="container">
    <h1>Add Assignment</h1>

    <form action="${SITE_URL}/assignment-management/assignments" method="POST">

        <div class="form-group">
            <label>Title</label>
            <input type="text" name="title" required="required" placeholder="Enter Title:" class="form-control"/>
        </div>

        <div class="form-group">
            <label>Description</label>
            <input type="text" name="description" required="required" placeholder="Enter description" class="form-control"/>
        </div>

        <div class="form-group">
            <label>Total Student</label>
            <input type="number" name="totalStudent" required="required" placeholder="Enter the number of student" class="form-control"/>
        </div>

        <div class="container">
            <div class="row">
                <div class='col-sm-6'>
                    <div class="form-group">
                        <div class='input-group date' id='datetimepicker1'>
                            <input type='text' class="form-control" />
                            <span class="input-group-addon">
                                <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                        </div>
                    </div>
                </div>
                <script type="text/javascript">



                    $(function () {
                        $('#datetimepicker1').datetimepicker();
                    });
                </script>
            </div>
        </div>

        <div>
            <button class="btn btn-success" type="submit">Save</button>
            <a href="${SITE_URL}/assignment-management/department" class="btn btn-danger">Back</a>
        </div>

    </form>
</div>
<%@include file="../title/footer.jsp" %>