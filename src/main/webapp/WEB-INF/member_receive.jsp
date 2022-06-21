<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,java.util.List,movie.movie_receive"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
List<movie_receive> movie = (List<movie_receive>)request.getAttribute("movie_receive");
%>
<table>
	<tr>
	<th>映画タイトル</th>
	<th>日程</th>
	<th>上映開始時間</th>
	<th>座席番号</th>
	<th></th>
	</tr>
	<tr>
	<%for(movie_receive members:movie){ %>
	<td><%=members.get_mv_id() %></td>
	<td><%=members.get_month() %>月<%=members.get_day() %>日</td>
	<td><%=members.get_time() %></td>
	<td><%=members.get_seat() %></td>
	<td><a href="/Movie_project/Receive_delete?password=<%=members.get_password() %>&user_id=<%=members.get_userid() %>&mv_id=<%=members.get_mv_id() %>&year=<%=members.get_year() %>&month=<%=members.get_month() %>&day=<%=members.get_day() %>&time=<%=members.get_time() %>&seat=<%=members.get_seat() %>">予約削除</a></td>
	</tr>
	<%} %>
	</table>
</body>
</html>
