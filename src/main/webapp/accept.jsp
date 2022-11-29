<%@page import="java.sql.*" %>
<%
Connection con=null;
PreparedStatement ps=null;
Class.forName("com.mysql.cj.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","522306");
String doctor=request.getParameter("doctor");
ps=con.prepareStatement("update appointment set status=? where doctor=?");
ps.setString(1,"Accepted");
ps.setString(2,doctor);
int x=ps.executeUpdate();
if(x!=0){
	response.sendRedirect("PatientAppointment.jsp?msg=Accepted");
}
%>