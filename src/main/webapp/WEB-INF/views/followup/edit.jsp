<%@include file="../shared/header.jsp" %>
<div class="jumbotron jumbotron-fluid">
  <div class="container text-center">
    <h1 class="display-4">Edit</h1>
  </div>
</div>
<form  method="post" action="${SITE_URL}/clients/followup/${followup.clientId}/save">
 <div class="form-group">
        <label>Message</label>
        <textarea type="text" name="message" required="required" class="form-control" style="height:150px;">${followup.message}</textarea>
    </div>
    <input type="hidden" name="id" value="${followup.id}"/>
    <button type="submit" class="btn btn-success">Save</button>
</form>
<%@include file="../shared/footer.jsp" %>