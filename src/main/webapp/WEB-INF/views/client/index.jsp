<%@include file="../shared/header.jsp" %>
<div class="jumbotron jumbotron-fluid">
    <div class="container text-center">
        <h1 class="display-4">Client Manager</h1>
    </div>
</div>
<form  method="post" action="${SITE_URL}/clients/save">
    <div class="form-group">
        <label>First name</label>
        <input type="text" name="firstName" required="required" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Last name</label>
        <input type="text" name="lastName" required="required" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Email</label>
        <input type="email" name="email" required="required" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Contact no</label>
        <input type="text" name="contactNo" required="required" class="form-control"/>
    </div>
    <div class="form-inline">
        <label>Status  </label>
        <label><input type="checkbox" name="status" class="status"/>  Active</label>
    </div>
    <input type="hidden" name="id" value="0"/>

    <button type="submit" class="btn btn-success">Save</button>
</form>
<br/>
<table class="table">
    <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Email</th>
            <th>Contact No</th>
            <th>Status</th>
            <th>Follow ups</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="client" items="${clients}">
            <tr>
                <td>${client.id}</td>
                <td>${client.firstName} ${client.lastName}</td>
                <td>${client.email}</td>
                <td>${client.contactNo}</td>
                <td>${client.status}</td>
                <td>${client.followUps}</td>
                <td>
                    <a href="${SITE_URL}/clients/edit/${client.id}" class="btn btn-success btn-xs">
                        <i class="fas fa-edit"></i>
                    </a>
                    <a href="${SITE_URL}/clients/delete/${client.id}" class="btn btn-success btn-xs" onClick="confirm('Are you sure to delete?')">
                        <i class="fas fa-window-close"></i>
                    </a>

                    <a href="javascript:void(0)" class="btn btn-success btn-xs" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo" onclick="fetch(${client.id})"">
                        <i class="far fa-comment-alt"></i>
                    </a>
                </td>
            </tr>


        </c:forEach>
    </tbody>
</table>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">New message</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="modalCloser()">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label>Message:</label>
                        <textarea class="form-control" name="message"></textarea>
                    </div>
                </form>
                <table class="table">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Message</th>
                            <th>Added Date</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody id="follow-ups">
                    </tbody>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Send message</button>
            </div>
        </div>
    </div>
</div>
<%@include file="../shared/footer.jsp" %>
