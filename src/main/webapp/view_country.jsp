<body bgcolor="wheat">
<br><br><br>
<h1 align="center">Welcome to Digital MARKET</h1>
<br><br><br>
<a href="AddCountry.html">Add Country</a>
<a href="view_employee.jsp">view Market</a>
<br><br><br>
<table border="1" cellpadding="20" width="400" height="200" align="center">
<tr><td>Country</td><td>BitCoin</td><td>Ethurum</td><td>C_Money</td><td>grade</td><td>Action</td></tr>
<%@page import="java.sql.*" %>
<%
Connection con=null;
PreparedStatement ps=null;
Class.forName("com.mysql.cj.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/invictus_engineers","root","522306");
ps=con.prepareStatement("select * from employee");
ResultSet rs=ps.executeQuery();
while(rs.next()){
	%>
	<tr>
	<td><%=rs.getInt(1)%></td><td><%=rs.getString(2)%></td><td><%=rs.getInt(3)%></td><td> <%=rs.getString(4)%></td><td><%=rs.getString(5)%></td>
	<td><a href="accept.jsp?id=<%=rs.getInt(1)%>">Accept</a></td>
</tr>
<%}

%>
</table>
</body>
</html>