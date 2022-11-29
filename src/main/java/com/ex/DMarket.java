package com.ex;

import java.io.IOException;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DMarket extends HttpServlet{
	Connection con=null;
	PreparedStatement ps=null;
	public void init(ServletConfig config) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/invictus_engineers","root","522306");
		}catch(Exception ee) {
			ee.printStackTrace();
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String country=request.getParameter("country");
		String Bitcoin=request.getParameter("Bitcoin");
		int bc=Integer.parseInt(Bitcoin);
		String Ethurum=request.getParameter("Ethurum");
		int et=Integer.parseInt(Ethurum);
		String C_Money=request.getParameter("C_Money");
		String grade=request.getParameter("grade");
		try {
			ps=con.prepareStatement("insert into employee values(?,?,?,?,?)");
			ps.setString(1, country);
			ps.setInt(2, bc);
			ps.setInt(3, et);
			ps.setString(4, C_Money);
			ps.setString(5, grade);
			int x=ps.executeUpdate();
			if(x!=0) {
				response.sendRedirect("./index.html?msg=Added Successfully");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

