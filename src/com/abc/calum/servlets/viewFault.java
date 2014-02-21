package com.abc.calum.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class viewFault
 */
@WebServlet("/viewFault")
public class viewFault extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewFault() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String idNum = request.getParameter("id");
		
		String stmt = "SELECT * FROM fault WHERE idfault =?";
		
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/faultdb","root","Cl1m8t3;");
			
			ps = con.prepareStatement(stmt);
				ps.setString(1, idNum);
				
				
			rs=ps.executeQuery();
			
			if (rs.next()) {
				
				String summary = rs.getString("summary");
				String details = rs.getString("details");
				int author = rs.getInt("author_idauthor");
				int section = rs.getInt("section_idsection");
				
				request.setAttribute("summary", summary);
				request.setAttribute("details", details);
				request.setAttribute("author", author);
				request.setAttribute("section", section);
				
				RequestDispatcher rd = request.getRequestDispatcher("viewFault.jsp");
				
				rd.forward(request, response);
				
				
				
				
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
		// 
	}

}
