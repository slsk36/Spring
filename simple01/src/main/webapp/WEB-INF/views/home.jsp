<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<meta charset="utf-8">
	<title>Home</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<h1>
	<a href="/simple01">Hello world!</a>
</h1>

  	<div class="jumbotron">
		<p>
			The time on the server is ${serverTime}.<br/> 
			<a href="/simple01/aajoin">joinform</a><br>
			<a href="/simple01/aaselectall">aaselectall</a><br>
			<a href="/simple01/aaupdate">aaupdateform</a><br>
			<a href="/simple01/aadelete">aadelete</a><br>
		</p>
	</div>
</div>


</body>
</html>
