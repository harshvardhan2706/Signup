package com.signup.registration;

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
import javax.servlet.RequestDispatcher;


@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("name");
		String uemail = request.getParameter("email");
		String upwd = request.getParameter("pass");
		String umobile = request.getParameter("contact");
		RequestDispatcher rd = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			Connection con = DriverManager.getConnection("dbc:mysql://sql12.freesqldatabase.com:3306/sql12789786?useSSl=false","sql12789786","5K5QMECeFs");
			System.out.println("Connection Established...");
			PreparedStatement pstm = con.prepareStatement("INSERT INTO users(uname,upwd,uemail,umobile) VALUES(?,?,?,?)");
			pstm.setString(1, uname);
			pstm.setString(2, upwd);
			pstm.setString(3, uemail);
			pstm.setString(4, umobile);
			int rowCount = pstm.executeUpdate();

			rd = request.getRequestDispatcher("/registration.jsp");
			if(rowCount>0) {
				request.setAttribute("status", "success");
			}else {
				request.setAttribute("status", "failed");
				request.setAttribute("errorMessage", "Account creation failed. Please try again.");
			}
			rd.forward(request, response);
			con.close();
		}catch(ClassNotFoundException e) {
			System.err.println("Class Not found");
			request.setAttribute("status", "failed");
			request.setAttribute("errorMessage", "Internal server error. Please try again later.");
			request.getRequestDispatcher("/registration.jsp").forward(request, response);
			e.printStackTrace();
		}catch(SQLException e) {
			System.err.println("SQL Exception");
			request.setAttribute("status", "failed");
			request.setAttribute("errorMessage", "Database error. Please try again later.");
			request.getRequestDispatcher("/registration.jsp").forward(request, response);
			e.printStackTrace();
		}
	}

}
