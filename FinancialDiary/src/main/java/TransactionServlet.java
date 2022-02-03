import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TransactionServlet
 */
@WebServlet("/TransactionServlet")
public class TransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	//Step 1: Prepare list of variables used for database connections
	 private String jdbcURL = "jdbc:mysql://localhost:3306/financialdiary";
	 private String jdbcUsername = "root";
	 private String jdbcPassword = "password";
	 
	 
	//Step 2: Prepare list of SQL prepared statements to perform CRUD to our database
	 private static final String INSERT_TRANSACTIONS_SQL 
	 = "INSERT INTO transaction" + " (transactionid, name, price, payment, user_id) VALUES " + " (?, ?, ?, ?, ?); ";
	 
	 private static final String SELECT_TRANSACTIONS_BY_user_id 
	 = "select transactionid, name, price, payment, user_id from transaction where user_id = ?";
	 
	 private static final String SELECT_ALL_TRANSACTIONS 
	 = "select * from transaction";
	 
	 private static final String DELETE_TRANSACTIONS_SQL 
	 = "delete from transaction where name = ?;";
	 
	 private static final String UPDATE_TRANSACTIONS_SQL 
	 = "update transaction set name = ?, price= ?, payment =? where user_id = ?;";
	 
	 
	//Step 3: Implement the getConnection method which facilitates connection to the database via JDBC
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	 

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TransactionServlet() {
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
		
		
		//Step 4: Depending on the request servlet path, determine the function to invoke using the following switch statement.
		String action = request.getServletPath();
		try {
			switch (action) {
//			case "/insert":
//				break;
//			case "/delete":
//				break;
//			case "/edit":
//				break;
//			case "/update":
//				break;
			case "/TransactionServlet/dashboard":
				listTransactions(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	
	}

	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		// Step 1: Initialize a PrintWriter object to return the html values via the
		// response
		PrintWriter out = response.getWriter();

		// Step 2: retrieve the four parameters from the request from the web form
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String payment = request.getParameter("payment");

		// Step 3: attempt connection to database using JDBC, you can change the
		// username and password accordingly using the phpMyAdmin > User Account
		// dashboard
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/financialdiary", "root", "password");

			// Step 4: implement the sql query using prepared statement
			// (https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html)
			PreparedStatement ps = con.prepareStatement("insert into TRANSACTION values(?,?,?,?,?)");

			// Step 5: parse in the data retrieved from the web form request into the
			// prepared statement accordingly
			ps.setInt(1, 0);
			ps.setString(2, name);
			ps.setString(3, price);
			ps.setString(4, payment);
			ps.setInt(5, 1);

			// Step 6: perform the query on the database using the prepared statement
			int i = ps.executeUpdate();

			// Step 7: check if the query had been successfully execute, return “You are
			// successfully registered” via the response,

			if (i > 0) {
				PrintWriter writer = response.getWriter();
				response.sendRedirect("http://localhost:8090/FinancialDiary/TransactionServlet/dashboard");
				writer.close();
			}
		}

		// Step 8: catch and print out any exception
		catch (Exception exception) {
			System.out.println(exception);
			out.close();
		}
		//doGet(request, response);
	}
	
	
	
	// Step 5: listUsers function to connect to the database and retrieve all users
	// records
	private void listTransactions(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		List<TransactionClass> transactions = new ArrayList<>();
		
		try (Connection connection = getConnection();
				
				// Step 5.1: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TRANSACTIONS);) {

			// Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
				int transactionid = rs.getInt("transactionid");
				String name = rs.getString("name");
				String price = rs.getString("price");
				String payment = rs.getString("payment");
				int user_id = rs.getInt("user_id");
				
				transactions.add(new TransactionClass(transactionid, name, price, payment, user_id));
			}
			
			//System.out.println(transactionid, name, price, payment, user_id);
			System.out.println("line 192: " + transactions);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		// Step 5.4: Set the users list into the listUsers attribute to be pass to the
		// userManagement.jsp
		request.setAttribute("listTransactions", transactions);
		request.getRequestDispatcher("/Transaction.jsp").forward(request, response);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
