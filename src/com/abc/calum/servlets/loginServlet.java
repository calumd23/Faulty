package com.abc.calum.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Login Started");
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String stmt = "SELECT * FROM users WHERE uname=? AND pass=?";
		
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/faultdb","root","Cl1m8t3;");
			
			ps = con.prepareStatement(stmt);
				ps.setString(1, username);
				ps.setString(2, password);
				
			rs=ps.executeQuery();
			
			if (rs.next()) {
				
				HttpSession session = request.getSession(true);
				session.setAttribute("username", rs.getString("uname"));
				session.setAttribute("id", rs.getInt("idNum"));
				session.setAttribute("permissions", rs.getString("permissions"));
				String permissions = rs.getString("permissions");
				
				if(permissions.equals("admin"))
				{
					System.out.println("Admin Logged In");
				}
				else if (permissions.equals("dev"))
				{
					System.out.println("Developer Logged In");
				}
				
				response.sendRedirect("home.jsp");
				
			}
			else
			{
				response.sendRedirect("loginFailure.jsp");
			}
				
		} catch (Exception e)
		{
			System.out.println(e);
		}
		
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
