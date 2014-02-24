package com.abc.calum.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.LinkedList;


/**
 * Servlet implementation class viewUsers
 */
@WebServlet("/viewUsers")
public class viewUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewUsers() {
        super();
        //
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs= null;



		String stmt = "SELECT uname,permissions,enabled FROM author WHERE idauthor !=?";
		LinkedList<String> unames = new LinkedList<String>();
		LinkedList<String> permissions = new LinkedList<String>();
		LinkedList<String> enableds = new LinkedList<String>();
		
		try {
			HttpSession session = request.getSession(true);
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/faultdb","root","Cl1m8t3;");
			
			ps = con.prepareStatement(stmt);
				ps.setString(1,session.getAttribute("id").toString());
				
			rs=ps.executeQuery();
			
			while (rs.next()) {
				
				String uname = rs.getString("uname");
				String perm = rs.getString("permissions");
				String enab = rs.getString("enabled");
				
				unames.add(uname);
				permissions.add(perm);
				enableds.add(enab);
				
				
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
		
		request.setAttribute("usernames",unames);
		request.setAttribute("permissions",permissions);
		request.setAttribute("enableds", enableds);
		
		RequestDispatcher rd = request.getRequestDispatcher("viewUsers.jsp");
		
		rd.forward(request,response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 
	}

}
