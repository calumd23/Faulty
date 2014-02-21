package com.abc.calum.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class viewAuthor
 */
@WebServlet("/viewAuthor")
public class viewAuthor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAuthor() {
        super();
        // 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String idNum = request.getParameter("id");
		
		String stmt = "SELECT idfault,summary FROM fault WHERE author_idauthor =?";
		LinkedList<String> faultIds = new LinkedList<String>();
		LinkedList<String> summaries = new LinkedList<String>();
		
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/faultdb","root","Cl1m8t3;");
			
			ps = con.prepareStatement(stmt);
				ps.setString(1, idNum);
				
				
			rs=ps.executeQuery();
			
			while (rs.next()) {
				
				String id = rs.getString("idfault");
				String summary = rs.getString("summary");
				
				faultIds.add(id);
				summaries.add(summary);
				
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
		
		request.setAttribute("faultIds", faultIds);
		request.setAttribute("summaries",summaries);
		request.setAttribute("authorID", request.getParameter("id"));
		
		RequestDispatcher rd = request.getRequestDispatcher("viewAuthorFaults.jsp");
		
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 
	}

}
