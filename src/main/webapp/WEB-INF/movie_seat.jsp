<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,java.util.List,movie.movie_receive"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<% List<movie_receive> mv = (List<movie_receive>)request.getAttribute("movie_table"); %>
<% String[] seat = {"A1","A2","A3","A4","A5","B1","B2","B3","B4","B5"};
String mv_id =(String)request.getAttribute("mv_id");
String year =(String)request.getAttribute("year");
String month =(String)request.getAttribute("month");
String day =(String)request.getAttribute("day");
String time =(String)request.getAttribute("time");
%>
<p>上映時間</p>

<table>
<tr>
<th>A</th>



<td><a href="/Movie_project/Movie_Login?seat=<%=seat[0]%>&mv_id=<%=mv_id%>&year=<%=year%>&month=<%=month%>&day=<%=day%>&time=<%=time%>"><%=seat[0]%></a></td>



<td><a href="/Movie_project/Movie_Login?seat=<%=seat[1]%>&mv_id=<%=mv_id%>&year=<%=year%>&month=<%=month%>&day=<%=day%>&time=<%=time%>"><%=seat[1]%></a></td>

<td><a href="/Movie_project/Movie_Login?seat=<%=seat[2]%>&mv_id=<%=mv_id%>&year=<%=year%>&month=<%=month%>&day=<%=day%>&time=<%=time%>"><%=seat[2]%></a></td>

<td><a href="/Movie_project/Movie_Login?seat=<%=seat[3]%>&mv_id=<%=mv_id%>&year=<%=year%>&month=<%=month%>&day=<%=day%>&time=<%=time%>"><%=seat[3]%></a></td>

<td><a href="/Movie_project/Movie_Login?seat=<%=seat[4]%>&mv_id=<%=mv_id%>&year=<%=year%>&month=<%=month%>&day=<%=day%>&time=<%=time%>"><%=seat[4]%></a></td>


</tr>
<tr>
<th>B</th>
<td><a href="/Movie_project/Movie_Login?seat=<%=seat[5]%>&mv_id=<%=mv_id%>&year=<%=year%>&month=<%=month%>&day=<%=day%>&time=<%=time%>"><%=seat[5]%></a></td>
<td><a href="/Movie_project/Movie_Login?seat=<%=seat[6]%>&mv_id=<%=mv_id%>&year=<%=year%>&month=<%=month%>&day=<%=day%>&time=<%=time%>"><%=seat[6]%></a></td>
<td><a href="/Movie_project/Movie_Login?seat=<%=seat[7]%>&mv_id=<%=mv_id%>&year=<%=year%>&month=<%=month%>&day=<%=day%>&time=<%=time%>"><%=seat[7]%></a></td>
<td><a href="/Movie_project/Movie_Login?seat=<%=seat[8]%>&mv_id=<%=mv_id%>&year=<%=year%>&month=<%=month%>&day=<%=day%>&time=<%=time%>"><%=seat[8]%></a></td>
<td><a href="/Movie_project/Movie_Login?seat=<%=seat[9]%>&mv_id=<%=mv_id%>&year=<%=year%>&month=<%=month%>&day=<%=day%>&time=<%=time%>"><%=seat[9]%></a></td>
</tr>
</table>

</body>
</html>

	
	
	

	
	