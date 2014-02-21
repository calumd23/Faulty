package com.abc.calum.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class editUser
 */
@WebServlet("/editUser")
public class editUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editUser() {
        super();
        // 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		PreparedStatement ps = null;
		
		String[] unameperms = request.getParameter("uname").split(";");
		String uname = unameperms[0];
		String perms = unameperms[1];
		
		System.out.println(request.getParameter("uname"));
		System.out.println(uname);
		System.out.println(perms);
		
		
		System.out.println(request.getParameter("submit"));
		
			if(request.getParameter("submit").equals("Change Permissions")){
				
				String stmt = "UPDATE author SET permissions=? WHERE uname=?";
				
				
				
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/faultdb","root","Cl1m8t3;");
					
					ps = con.prepareStatement(stmt);
					if(perms.equals("admin")){
						ps.setString(1, "dev");
					} else {
						ps.setString(1,"admin");
					}
						
						ps.setString(2, uname);
						
						
						
					ps.executeUpdate();
					
					response.sendRedirect("viewUsers");
					
					
						
				} catch (Exception e) {
					System.out.println(e);
					response.sendRedirect("viewUsers");
				}
				
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
				
			} else if (request.getParameter("submit").equals("Delete User")){
			
			String stmt = "DELETE FROM author WHERE uname=? AND permissions=?";
			
			
			
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/faultdb","root","Cl1m8t3;");
				
				ps = con.prepareStatement(stmt);
					ps.setString(1, uname);
					ps.setString(2, perms);
					
					
					
				ps.executeUpdate();
				
				response.sendRedirect("viewUsers");
				
				
					
			} catch (Exception e) {
				System.out.println(e);
				response.sendRedirect("viewUsers");
			}
			
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			
		
		}
		
		//response.sendRedirect("viewUsers");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 
	}

}
