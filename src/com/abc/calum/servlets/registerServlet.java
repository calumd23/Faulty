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
 * Servlet implementation class registerServlet
 */
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerServlet() {
        super();
        // 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		HttpSession session = request.getSession(true);
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		String stmt = "INSERT INTO author (uname, pass, firstName, lastName) VALUES (?,?,?,?)";
		
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/faultdb","root","Cl1m8t3;");
			
			ps = con.prepareStatement(stmt);
				ps.setString(1, uname);
				ps.setString(2, pass);
				ps.setString(3,firstName);
				ps.setString(4,lastName);
				
				
				
			ps.executeUpdate();
			session.setAttribute("userCreated","true");
			response.sendRedirect("login.jsp");
			
			
				
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
