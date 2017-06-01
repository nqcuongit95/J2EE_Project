<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2 class="ui dividing header">Searching Books</h2>

<jsp:include page="/WEB-INF/pages/searching/search-form.jsp"/>

<h4 class="ui horizontal divider header" id="divider-result">
	<i class="search icon"></i> Results
</h4>
	
<jsp:include page="/WEB-INF/pages/searching/search-results.jsp" />

<jsp:include page="/WEB-INF/pages/searching/details-modal.jsp" />
<jsp:include page="/WEB-INF/pages/searching/renting-modal.jsp" />
