<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,java.util.List,movie.movie_table" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>上映中映画一覧</title>
</head>
<body>
	<% List<movie_table> books = (List<movie_table>)request.getAttribute("movie_table"); %>
	<a href="/Movie_project/member_Login">ログイン</a>
	<a href="/Movie_project/member_insert">会員登録</a>
	<table>
	<tr>
	<th>映画タイトル</th>
	<th></th>
	</tr>
	<tr>
	<%for(movie_table members:books){ %>
	<td><%=members.get_Movie_titel() %></td>
	
	<td><a href ="/Movie_project/Movie_calendar?mv_id=<%=members.get_Movie_titel()%>">予約状況</a></td>
	</tr>
	<%} %>
	</table>
</body>
</html>  