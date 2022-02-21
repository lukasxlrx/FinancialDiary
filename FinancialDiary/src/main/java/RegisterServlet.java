
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	public int register(String username, String password, String email, String firstname, String lastname)
	{
		
		int i = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/financialdiary", "root",
					"password");

			// Step 4: implement the sql query using prepared statement
			// (https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html)
			PreparedStatement ps = con.prepareStatement("insert into USER values(?,?,?,?,?,?)");

			// Step 5: parse in the data retrieved from the web form request into the
			// prepared statement accordingly
			ps.setInt(1, 0);
			ps.setString(2, username);
			ps.setString(3, password);
			ps.setString(4, email);
			ps.setString(5, firstname);
			ps.setString(6, lastname);

			// Step 6: perform the query on the database using the prepared statement
			i = ps.executeUpdate();
			
			return i;
		}

		// Step 8: catch and print out any exception
		catch (Exception exception) {
			System.out.println(exception);
		}
		return i;
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");

		// Step 1: Initialize a PrintWriter object to return the html values via the
		// response
		PrintWriter out = response.getWriter();

		// Step 2: retrieve the four parameters from the request from the web form
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		
		int i = register(username, password, email, firstname, lastname);
		
		if (i > 0) {
			response.sendRedirect("/FinancialDiary/Login.jsp");
		}
		else {
			//alert("Unsuccessful Registration. Please try again.");
			showMessageDialog(null, "Unsuccessful Registration.");
			response.sendRedirect("/FinancialDiary/Register.jsp");
		}
		
		doGet(request, response);
	}
	
}
	

