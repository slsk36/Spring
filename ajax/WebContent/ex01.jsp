<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#ex02").on("click",function(){
		$.ajax({
			url : "ex02.jsp",
			type: "get",
			success: function(result){ 
				$("#printDiv").html(result);
			},
			error: function(){ alert("error")}
		});
	})
})
</script>
</head>
<body>
	<div>
		<button id="ex02">ex02</button>
	</div>
	
	<div id="printDiv"></div>
</body>
</html>