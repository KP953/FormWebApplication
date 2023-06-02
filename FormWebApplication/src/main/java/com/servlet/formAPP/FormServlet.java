package com.servlet.formAPP;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FormServlet extends GenericServlet {

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		String name = arg0.getParameter("name");
		String palce = arg0.getParameter("place");
		String inquery = "insert into form_details.info values(?,?)";
		System.out.println(name + " is form " + palce);

		PrintWriter out = arg1.getWriter();
		out.println("<html>" + "<body bgcolor ='crimson'>" + "<h1>User Details:>" + name + " form " + palce
				+ "</h1></body></html>");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("loded");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=pvk@123");
			System.out.println("connected");

			PreparedStatement psmt = con.prepareStatement(inquery);
			psmt.setString(1, name);
			psmt.setString(2, palce);
			psmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
