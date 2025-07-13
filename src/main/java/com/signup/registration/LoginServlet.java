package com.signup.registration;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uemail = request.getParameter("username");
		String upwd = request.getParameter("password");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			try (java.sql.Connection con = DriverManager.getConnection("dbc:mysql://sql12.freesqldatabase.com:3306/sql12789786?useSSl=false","sql12789786","5K5QMECeFs");
				 PreparedStatement pstm = con.prepareStatement("SELECT * FROM users WHERE uemail = ? and upwd = ?")) {
				System.out.println("Connection Established...");
				pstm.setString(1, uemail);
				pstm.setString(2, upwd);

				try (ResultSet rs = pstm.executeQuery()) {
					if(rs.next()) {
						session.setAttribute("name", rs.getString("uname"));
						dispatcher = request.getRequestDispatcher("index.jsp");
					}else {
						request.setAttribute("status", "failed");
						request.setAttribute("errorMessage", "Wrong Username or Password");
						dispatcher=request.getRequestDispatcher("login.jsp");
					}
					dispatcher.forward(request, response);
				}
			}
		}catch(Exception e) {
			System.err.println("Error");
			request.setAttribute("status", "failed");
			request.setAttribute("errorMessage", "Internal server error. Please try again later.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			e.printStackTrace();
		}
	}

}
