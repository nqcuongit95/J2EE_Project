<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld" %>
<div id="home-body-div">
	<div class="ui grid">
  <div class="row" style="padding-top: 0">
  	<div class="sixteen wide column">
      	<h3>List of books borrowed</h3>
      	<table class="ui single line table">
		  <thead>
		    <tr>
		      <th>ID </th>
		      <th>Name</th>
		      <th>Phone</th>
		      <th>Address</th>
		      <th>Note</th>
		      <th>Date</th>
		      <th></th>
		    </tr>
		  </thead>
		  <tbody>
		  <c:forEach items="${data}" var="item">
			    <tr>
		      <td>${item.id}</td>
		      <td>${item.tenDocGia}</td>
		      <td>${item.soDienThoai}</td>
		      <td>${item.diaChi}</td>
		       <td>${item.ghiChu}</td>
		      <td>${item.ngayTao}</td>
		       <td><a href="<c:url value='/bookrenting/${item.id}' />" >Details</a></td>
		    </tr>
			</c:forEach>    
		  </tbody>
		</table>
		<tag:paginate max="10" offset="${offset}" count="${count}" uri="bookrenting" next="»" previous="«"/>
    </div>
  </div>
</div>
	
</div>