<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String failureMessage = (String)request.getAttribute("loginFailure"); 
String password = (String)request.getAttribute("password");
String id = (String)request.getAttribute("user_id");%>

<% if (failureMessage != null) {%>
	<%=failureMessage %>
<%} %>

<form action="/Movie_project/member_Login?id=<%=id %>&password=<%=password %>" method="post">
	id:<input type="text" name="user_id">
	name:<input type="password" name="password">
	<input  type="submit" value="ログイン">
</form>
</body>
</html>