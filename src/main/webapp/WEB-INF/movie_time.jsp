<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%

    String mv_id =(String)request.getAttribute("mv_id");
    String year =(String)request.getAttribute("year");
    String month =(String)request.getAttribute("month");
    String day =(String)request.getAttribute("day");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<% String[] time = {"9:10","10:40","19:00"};%>
<p>上映時間</p>
<table>
<tr>
<td><a href="/Movie_project/Movie_seat?time=<%=time[0]%>&mv_id=<%=mv_id%>&year=<%=year%>&month=<%=month%>&day=<%=day%>"><%=time[0]%></a></td>
<td><a href="/Movie_project/Movie_seat?time=<%=time[1]%>&mv_id=<%=mv_id%>&year=<%=year%>&month=<%=month%>&day=<%=day%>"><%=time[1]%></a></td>
<td><a href="/Movie_project/Movie_seat?time=<%=time[2]%>&mv_id=<%=mv_id%>&year=<%=year%>&month=<%=month%>&day=<%=day%>"><%=time[2]%></a></td>
</tr>
</table>
</body>
</html>