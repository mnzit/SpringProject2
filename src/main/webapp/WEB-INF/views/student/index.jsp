<%@include file="../shared/header.jsp" %>
<div class="jumbotron jumbotron-fluid">
  <div class="container text-center">
    <h1 class="display-4">Student Manager</h1>
  </div>
</div>
<form  method="post" action="${SITE_URL}/students/save">
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
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="student" items="${students}">
            <tr>
                <td>${student.id}</td>
                <td>${student.firstName} ${student.lastName}</td>
                <td>${student.email}</td>
                <td>${student.contactNo}</td>
                <td>${student.status}</td>
                <td>
                    <a href="${SITE_URL}/students/edit/${student.id}" class="btn btn-success btn-xs">
                        <i class="fas fa-edit"></i>
                    </a>
                    <a href="${SITE_URL}/students/delete/${student.id}" class="btn btn-success btn-xs" onClick="confirm('Are you sure to delete?')">
                        <i class="fas fa-window-close"></i>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<%@include file="../shared/footer.jsp" %>
