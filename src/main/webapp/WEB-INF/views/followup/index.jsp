<%@include file="../shared/header.jsp" %>
<form  method="post" action="${SITE_URL}/followup/save">
 <div class="form-group">
        <label>Message</label>
        <textarea type="text" name="message" required="required" class="form-control" style="height:150px;"></textarea>
    </div>
    <input type="hidden" name="id" value="0"/>
    <input type="hidden" name="clientId" value="${client_id}"/>
    <button type="submit" class="btn btn-success">Save</button>
</form>
<br/>
<table class="table">
    <thead>
        <tr>
            <th>Id</th>
            <th>Message</th>
             <th>Added Date</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="followup" items="${followups}">
            <tr>
                <td>${followup.id}</td>
                <td>${followup.message}</td>
                <td>${followup.addedDate}</td>
                  <td>
                    <a href="${SITE_URL}/clients/followup/edit/${followup.id}" class="btn btn-success btn-xs">
                        <i class="fas fa-edit"></i>
                    </a>
                    <a href="${SITE_URL}/clients/followup/delete/${followup.id}" class="btn btn-success btn-xs" onClick="confirm('Are you sure to delete?')">
                        <i class="fas fa-window-close"></i>
                    </a>
            </tr>
        </c:forEach>
    </tbody>
</table>
<%@include file="../shared/footer.jsp" %>
