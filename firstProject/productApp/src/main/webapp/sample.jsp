<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Hello</h2>
	<!-- Scriptlets for java statements -->
	<%
		for(int i=2;i<3200;i++)
		{
	%> 
		character for <%= i %> is : &#<%=i %>; <br/>
	<%
		}
	%>

</body>
</html>