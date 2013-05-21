<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Home page</title>
<link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css" />
<script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
<script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
<script>
  $(document).ready(function() {
  
	var contextPath = "${pageContext.request.contextPath}/team/listJson";
  
	$('#team-resultsTable').dataTable({
	    "bProcessing": true,
	    "sAjaxSource": contextPath,
	    "aoColumns": [
         { "mData": "name" },
         { "mData": "rating" }
		]
	});
});
</script>
<style>
#team-results {
	width:35%;
}
</style>
</head>
<body>
	<h1>Home page</h1>
	<p>${message} <br />
	
		<a href="${pageContext.request.contextPath}/team/add.html">Add team</a>
		<a href="${pageContext.request.contextPath}/team/list.html">List teams</a>
	</p>
	
	<div id="team-results">
		<table id="team-resultsTable">
		<thead>
			<tr>
				<th>Name</th>
				<th>Rating</th>
			</tr>
		</thead>
		<tbody>
			
		</tbody>
		</table>
	</div>
</body>
</html>