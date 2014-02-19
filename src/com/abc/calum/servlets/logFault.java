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
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class logFault extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logFault() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Logging Fault Started");
		
		Connection con = null;
		PreparedStatement ps = null;
		
		HttpSession session = request.getSession(true);
		
		String summary = request.getParameter("summary");
		String details = request.getParameter("details");
		int section = Integer.parseInt(request.getParameter("section"));
		int id = Integer.parseInt(session.getAttribute("id").toString());
		
		String stmt = "INSERT INTO fault (summary, details, author_idauthor, section_idsection) VALUES (?,?,?,?)";
		
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/faultdb","root","Cl1m8t3;");
			
			ps = con.prepareStatement(stmt);
				ps.setString(1, summary);
				ps.setString(2, details);
				ps.setInt(3,id);
				ps.setInt(4,section);
				
				
				
			ps.executeUpdate();
			response.sendRedirect("/Faulty/Faults");
			
			
				
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
