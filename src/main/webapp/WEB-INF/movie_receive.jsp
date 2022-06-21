<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String password =(String)request.getAttribute("password");
String userId =(String)request.getAttribute("user_id");
String mv_id =(String)request.getAttribute("mv_id");
String year =(String)request.getAttribute("year");
String month =(String)request.getAttribute("month");
String day =(String)request.getAttribute("day");
String time =(String)request.getAttribute("time");
String seat =(String)request.getAttribute("seat");
%>
<p>予約内容確認</p>
<table>

<tr>
<th>作品</th>
<th>予約日程</th>
<th>予約時間</th>
<th>座席</th>
</tr>
<tr>
<td><%=mv_id %></td>
<td><%=month %>月<%=day %>日</td>
<td><%=time %></td>
<td><%=seat %></td>
</tr>
</table>
<a href="/Movie_project/Movie_receive2?seat=<%=seat%>&mv_id=<%=mv_id%>&year=<%=year%>&month=<%=month%>&day=<%=day%>&time=<%=time%>&user_id=<%=userId%>&pass=<%=password%>">予約完了</a>
<form action="/Movie_project/movie_table" method="get">
	<input  type="submit" value="キャンセル">
</form>
</body>
</body>




</body>
</html>