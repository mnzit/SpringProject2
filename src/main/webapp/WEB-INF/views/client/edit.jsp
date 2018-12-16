<%@include file="../shared/header.jsp" %>
<div class="jumbotron jumbotron-fluid">
  <div class="container text-center">
    <h1 class="display-4">Edit</h1>
  </div>
</div>
<form  method="post" action="${SITE_URL}/clients/save">
    <div class="form-group">
        <label>First name</label>
        <input type="text" name="firstName" required="required" class="form-control" value="${client.firstName}"/>
    </div>
    <div class="form-group">
        <label>Last name</label>
        <input type="text" name="lastName" required="required" class="form-control" value="${client.lastName}"/>
    </div>
    <div class="form-group">
        <label>Email</label>
        <input type="email" name="email" required="required" class="form-control" value="${client.email}"/>
    </div>
    <div class="form-group">
        <label>Contact no</label>
        <input type="text" name="contactNo" required="required" class="form-control" value="${client.contactNo}"/>
    </div>
    <div class="form-inline">
        <label>Status  </label>
        <label><input type="checkbox" name="status" class="status" <c:if test="${client.status}">checked = "checked"</c:if>/>  Active</label>
    </div>
    <input type="hidden" name="id" value="${client.id}"/>

    <button type="submit" class="btn btn-success">Save</button>
</form>
<%@include file="../shared/footer.jsp" %>