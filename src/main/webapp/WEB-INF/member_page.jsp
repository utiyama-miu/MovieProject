<%@ page language="java" contentType="text/html; charset=UTF-8;"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String password = (String)request.getAttribute("password");
String id = (String)request.getAttribute("user_id");
%>
<a href ="/Movie_project/member_recive?id=<%=id%>&password=<%=password%>">予約確認/予約取り消し</a>
<a href ="/Movie_project/Move_table">作品一覧に戻る</a>

</body>
</html>