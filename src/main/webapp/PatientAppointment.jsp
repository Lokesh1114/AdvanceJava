<!DOCTYPE html>
<html>

<body bgcolor="wheat" align="center">
<br>
<h1 align="center" style="color:blue">welcome to LKS CARES </h1>
<img alt="lks" src="https://cdn.freebiesupply.com/logos/large/2x/lks-lodz-logo-png-transparent.png" height="100" width="100">
<h2 align="center"><a href="index.html">Home</a></h2>

<table border="1" cellpadding="20" width="400" height="200" align="center">
<tr>
<td>doctor</td><td>department</td><td>roomno</td><td>appointmentdate</td><td>patient</td><td>status</td>
<td>patientName</td><td>PatientNumber</td>
<td>AppointmentStatus</td>
<%@page import="java.sql.*" %>
<%
Connection con=null;
PreparedStatement ps=null;
Class.forName("com.mysql.cj.jdbc.Driver");
String url = "jdbc:mysql://localhost:3306/hospital";
String username= "root";
String password= "522306";
 con=DriverManager.getConnection(url, username, password);
 request.getParameter("pname");
 ps=con.prepareStatement("select * from appointment");
 ResultSet rs=ps.executeQuery();
 while(rs.next()){
%>
<tr>
<td><%=rs.getString(1)%></td><td><%=rs.getString(2)%></td><td><%=rs.getInt(3)%></td><td><%=rs.getString(4)%></td><td><%=rs.getString(5)%></td>
<td><%=rs.getString(6)%></td><td><%=rs.getString(7) %></<td><td><%=rs.getInt(8) %></td><td><a href="accept.jsp?doctor=<%=rs.getString(1)%>">Accept</a>||<a href="reject.jsp?doctor=<%=rs.getString(1)%>">Reject</a></td>
</tr>
<%}
 %>
</table>
</body>
</html>