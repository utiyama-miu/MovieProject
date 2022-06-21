<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.Movie_Calendar"%>
<%
Movie_Calendar mc=(Movie_Calendar)request.getAttribute("mc");
String mv_id =(String)request.getAttribute("mv_id");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="utf-8">
  <title><%=mc.getGengou() %>年<%=mc.getMonth() %>月カレンダー</title>
  <link rel="stylesheet"  href="http://yui.yahooapis.com/3.18.1/build/cssreset/cssreset-min.css">
  <link href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c" rel="stylesheet">
  <link rel="stylesheet"  href="css/main.css">
</head>
<body>
  <div id="container">
    <h1><%=mc.getGengou() %>年<%=mc.getMonth() %>月の予定上映日</h1>
    <p>
		　
    </p>
    <table>
      <tr>
        <th>日</th>
        <th>月</th>
        <th>火</th>
        <th>水</th>
        <th>木</th>
        <th>金</th>
        <th>土</th>
      </tr>
      <%for(String[] row: mc.getData()){ %>
      <tr>
      	<%for(String col:row) {%>
      		<%if (col.startsWith("*")){ %>
      			<td><a href ="/Movie_project/Movie_time?month=<%=mc.getMonth() %>&year=<%=mc.getYear()%>&day=<%=col.substring(1)%>&mv_id=<%=mv_id%>"><%=col.substring(1)%></a></td>
      		<%}else{ %>
      			<td><%=col %></td>
      		<%} %>
      	<%} %>
      </tr>
      <%} %>
    </table>
  </div><!-- end container-->
</body>
</html>