package com.app;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
 
public class PatientLogin extends HttpServlet { 
	Connection con=null;
	PreparedStatement ps=null;
	public void init(ServletConfig config){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","522306");
		}catch(Exception e) {e.printStackTrace();}
	}
public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
	int id=Integer.parseInt(request.getParameter("pid"));
	String p=request.getParameter("name");
try {	
	ps=con.prepareStatement("select * from patient where pid=? and name=?");
	ps.setInt(1,id);  
	ps.setString(2,p);   
	ResultSet rs=ps.executeQuery(); 
	if(rs.next()) {
	response.sendRedirect("PatientPage.html");
	}
	else {
		response.sendRedirect("PatientLogin.html?msg=%%Login Fail%%%");
	}
	
} catch (SQLException e) {
	e.printStackTrace();
}
}

}  
