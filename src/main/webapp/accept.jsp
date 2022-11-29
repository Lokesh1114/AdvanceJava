<%@page import="java.sql.*" %>
<%
Connection con=null;
PreparedStatement ps=null;
Class.forName("com.mysql.cj.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/invictus_engineers","root","522306");
String country=request.getParameter("country");
ps=con.prepareStatement("update employee set grade=? where country=?");
ps.setString(1, "Accepted");
ps.setString(2, "country");
int x=ps.executeUpdate();
if(x!=0){
	response.sendRedirect("view_employee.jsp?msg=Accepted");
}
%>