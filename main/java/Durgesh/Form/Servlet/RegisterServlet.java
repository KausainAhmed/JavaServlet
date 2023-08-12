package Durgesh.Form.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//controller
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();

		out.println("<h1>Login Form Servlet</h1>");

//fetching data
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		String course = req.getParameter("course");
		String cond = req.getParameter("condition");
		if (cond != null) {
			out.println("<h2>Name : " + name + "</h2>");
			out.println("<h2>Email : " + email + "</h2>");
			out.println("<h2>Password : " + password + "</h2>");
			out.println("<h2>Course : " + course + "</h2>");
			out.println("<h2>Gender : " + gender + "</h2>");

			// JDBC code to save data on database
			// let us suppose, data saved
// going to use forward() of request dispatcher
			RequestDispatcher rd = req.getRequestDispatcher("forw");
			rd.forward(req, resp);

		} else {
			out.println("<h2>You haven't accepted the terms and conditions</h2>");
			// Use RequestDispatcher , using include() to show login page again with
			// Unchecked error msg
			RequestDispatcher rd = req.getRequestDispatcher("index.html");
			rd.include(req, resp); //using iclude dispatcher
		}

	}
}
