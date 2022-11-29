package com.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Appointment extends HttpServlet{
	Connection con=null;
	PreparedStatement ps=null;
	public void init(ServletConfig config) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","522306");
		}catch(Exception e) {e.printStackTrace();}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
			String doctor =request.getParameter("doctor");
		    String department=request.getParameter("department");
			String roomno=request.getParameter("roomno");
			int rn=Integer.parseInt(roomno);
			String appointmentdate=request.getParameter("appointmentdate");
			String patient=request.getParameter("patient");
			try {
				ps=con.prepareStatement("insert into appointment values(?,?,?,?,?,?)");
				ps.setString(1, doctor);
				ps.setString(2, department);
				ps.setInt(3,rn);
				ps.setString(4, appointmentdate);
				ps.setString(5, patient);
				ps.setString(6, "pending");
				int x=ps.executeUpdate();
				if(x!=0) {
					response.sendRedirect("./index.html?msg=Added Succesfully");
				}
			}catch(Exception e) {e.printStackTrace();}
					
			
	}
}
