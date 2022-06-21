<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String failureMessage = (String)request.getAttribute("loginFailure"); %>

<% if (failureMessage != null) {%>
	<%=failureMessage %>
<%} %>

<%
String mv_id =(String)request.getAttribute("mv_id");
String year =(String)request.getAttribute("year");
String month =(String)request.getAttribute("month");
String day =(String)request.getAttribute("day");
String time =(String)request.getAttribute("time");
String seat =(String)request.getAttribute("seat");

%>
<form action="/Movie_project/Movie_Login?seat=<%=seat%>&mv_id=<%=mv_id%>&year=<%=year%>&month=<%=month%>&day=<%=day%>&time=<%=time%>" method="post">
	id:<input type="text" name="user_id">
	name:<input type="password" name="password">
	<input  type="submit" value="ログイン">
</form>
</body>
</html>