package com.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Patient extends HttpServlet{
	static int id;
	static String name;
	Connection con=null;
	PreparedStatement ps=null;
	public void init(ServletConfig config) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","522306");
		}catch(Exception e) {e.printStackTrace();}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
			String pid =request.getParameter("pid");
			id=Integer.parseInt(pid);
		    name=request.getParameter("name");
			String gender=request.getParameter("gender");
			String bloodgrp=request.getParameter("bloodgrp");
			String number=request.getParameter("number");
			int num=Integer.parseInt(number);
			String email=request.getParameter("email");
			try {
				ps=con.prepareStatement("insert into patient values(?,?,?,?,?,?)");
				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setString(3,gender);
				ps.setString(4, bloodgrp);
				ps.setInt(5, num);
				ps.setString(6, email);
				int x=ps.executeUpdate();
				if(x!=0) {
					response.sendRedirect("index.html?msg=Added Succesfully");
				}
			}catch(Exception e) {e.printStackTrace();}
					
			
	}
}
