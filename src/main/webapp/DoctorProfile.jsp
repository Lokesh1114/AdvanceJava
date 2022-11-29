<!DOCTYPE html>
<html>

<body bgcolor="wheat" align="center">
<br>
<h1 align="center" style="color:blue">welcome to LKS CARES </h1>
<img alt="lks" src="https://cdn.freebiesupply.com/logos/large/2x/lks-lodz-logo-png-transparent.png" height="100" width="100">
<table border="1" cellpadding="20" width="400" height="200" align="center">
<tr>
<td>pid</td><td>name</td><td>gender</td><td>bloodgrp</td><td>number</td><td>email</td>
<td>specilization</td>
<%@page import="java.sql.*" %>
<%
Connection con=null;
PreparedStatement ps=null;
Class.forName("com.mysql.cj.jdbc.Driver");
String url = "jdbc:mysql://localhost:3306/hospital";
String username= "root";
String password= "522306";
 con=DriverManager.getConnection(url, username, password);
 ps=con.prepareStatement("select * from doctor");
 ResultSet rs=ps.executeQuery();
 while(rs.next()){
%>
<tr>
<td><%=rs.getInt(1)%></td><td><%=rs.getString(2)%></td><td><%=rs.getString(3)%></td><td><%=rs.getString(4)%></td><td><%=rs.getInt(5)%></td>
<td><%=rs.getString(6)%></td><td><%=rs.getString(7) %></td>
</tr>
<%}
 %>
</table>
</body>
</html>