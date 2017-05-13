<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link
	href="<c:url value="/resources/css/default.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/css/semantic-ui/dist/semantic.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
<script
	src="<c:url value="/resources/css/semantic-ui/dist/semantic.min.js" />"></script>
<meta charset="UTF-8">

<title><tiles:getAsString name="title" /></title>

</head>

<body>
	<tiles:insertAttribute name="header" />
	<div class="ui main container">
	<tiles:insertAttribute name="body" />
	</div>
	<tiles:insertAttribute name="footer" />
</body>

</html>