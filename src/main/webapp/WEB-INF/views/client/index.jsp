<%@include file="../shared/header.jsp" %>
<div class="page-header">
    <h1>Client Manager</h1>
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
        <label>Status</label>
        <label><input type="checkbox" name="status" class="status"/>Active</label>
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
                    <a href="${SITE_URL}/clients/followup/${client.id}" class="btn btn-success btn-xs"">
                       <i class="far fa-comment-alt"></i>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<%@include file="../shared/footer.jsp" %>
