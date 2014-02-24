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
 * Servlet implementation class editFault
 */
@WebServlet("/editFault")
public class editFault extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editFault() {
        super();
        // 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		PreparedStatement ps = null;
		
		String faultID = request.getParameter("id");
		System.out.println("faultID = " + faultID);
		String function = request.getParameter("function");
		System.out.println("function = " + function);
		
		if(function.equals("1")){
				//Mark Solved
				String stmt = "UPDATE fault SET solved=? WHERE idfault=?";
				
				
				
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/faultdb","root","Cl1m8t3;");
					
					ps = con.prepareStatement(stmt);
						ps.setString(1, "true");
						ps.setString(2, faultID);
						
						
						
					ps.executeUpdate();
					
					response.sendRedirect("viewFault?id=" + faultID);
					
					
						
				} catch (Exception e) {
					System.out.println(e);
					response.sendRedirect("viewFault?id=" + faultID);
				}
				
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
				
			} else if (function.equals("2")){
			//Delete Fault
			String stmt = "DELETE FROM fault WHERE idfault=?";
			
			
			
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/faultdb","root","Cl1m8t3;");
				
				
				ps = con.prepareStatement(stmt);
					ps.setString(1, faultID);
					
					
					
				ps.executeUpdate();
				
				response.sendRedirect("Faults" + faultID);
				
				
					
			} catch (Exception e) {
				System.out.println(e);
				response.sendRedirect("Faults" + faultID);
			}
			
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			
		
		}
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 
	}

}
