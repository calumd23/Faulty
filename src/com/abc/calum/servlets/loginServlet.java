package com.abc.calum.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.abc.calum.lib.Dbutils;


/**
 * Servlet implementation class loginServlet
 */
@WebServlet(
		urlPatterns = { 
				"/loginServlet"
		}, 
		initParams = { 
				@WebInitParam(name = "data-source", value = "jdbc/faultdb")
		}
		
)
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataSource _ds = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        
    }
    
    public void init(ServletConfig config) throws ServletException {
		// 
		Dbutils db = new Dbutils();
		db.createSchema();
		_ds=db.assemble(config);
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
		
		String stmt = "SELECT * FROM author WHERE uname=? AND pass=? AND enabled=?";
		
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/faultdb","root","Cl1m8t3;");
			
			ps = con.prepareStatement(stmt);
				ps.setString(1, username);
				ps.setString(2, password);
				ps.setString(3, "true");
				
			rs=ps.executeQuery();
			
			if (rs.next()) {
				
				HttpSession session = request.getSession(true);
				session.setAttribute("username", rs.getString("uname"));
				session.setAttribute("id", rs.getInt("idauthor"));
				session.setAttribute("permissions", rs.getString("permissions"));
				session.setAttribute("loggedIn", "true");
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
