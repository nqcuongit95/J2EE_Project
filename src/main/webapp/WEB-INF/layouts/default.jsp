<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
<link rel="stylesheet"
	href="src/main/webapp/css/semantic-ui/dist/semantic.css" />
<script type="text/javascript"
	src="src/main/webapp/css/semantic-ui/dist/semantic.min.js"></script>
<title><tiles:getAsString name="title" /></title>
</head>

<body>
	<div class="ui red button">test</div>
	<table width="100%">
		<tr class="">
			<td colspan="2"><tiles:insertAttribute name="header" /></td>
		</tr>
		<tr>
			<td width="20%" nowrap="nowrap"><tiles:insertAttribute
					name="menu" /></td>
			<td width="80%"><tiles:insertAttribute name="body" /></td>
		</tr>
		<tr>
			<td colspan="2"><tiles:insertAttribute name="footer" /></td>
		</tr>
	</table>
</body>
</html>