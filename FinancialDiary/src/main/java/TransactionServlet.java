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
import javax.servlet.http.HttpSession;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

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
	 

	// Step 1: Prepare list of variables used for database connections
	private String jdbcURL = "jdbc:mysql://localhost:3306/financialdiary";
	private String jdbcUsername = "root";
	private String jdbcPassword = "Password";

	// Step 2: Prepare list of SQL prepared statements to perform CRUD to our
	// database

	private static final String INSERT_TRANSACTION_SQL = "INSERT INTO transactiondb" + " (transactionid, name, price, payment) VALUES " + " (?, ?, ?);";
	private static final String SELECT_TRANSACTION_BY_ID = "select transactionid ,name, price, payment, user_id from transactiondb where transactionid = ?";
	private static final String SELECT_ALL_TRANSACTION = "select * from transactiondb ";
	private static final String DELETE_TRANSACTION_SQL = "delete from transactiondb where transactionid = ?;";
	private static final String UPDATE_TRANSACTION_SQL = "update transactiondb set transactionid=?, name = ?, price = ?,payment = ?, user_id = ? where transactionid = ?;";

	// Step 3: Implement the getConnection method which facilitates connection to
	// the database via JDBC
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("hi database");
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
<<<<<<< HEAD
		
		
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
	
=======

		// Step 4: Depending on the request servlet path, determine the function to
		// invoke using the follow switch statement.
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/insert":
				break;
			case "/TransactionServlet/delete":
				System.out.println("hi delete");
				deleteTransaction(request, response); 
				break;
			case "/TransactionServlet/edit":
				System.out.println("hi edit");
				System.out.println(Integer.parseInt(request.getParameter("transactionID")));
				showEditForm(request, response);
				break;
			case "/TransactionServlet/update":
				System.out.println("hi update");
				System.out.println("Hi Update" + Integer.parseInt(request.getParameter("TransactionID")));
				updateTransaction(request, response); 
				break;
			default:
				System.out.println("has getting");
			case "/TransactionServlet/dashboard":
				listUsers(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
>>>>>>> branch 'lukasBranch' of https://github.com/lukasxlrx/FinancialDiary
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
		HttpSession session = request.getSession();
		int uid = (int) session.getAttribute("userID");
		// Step 2: retrieve the four parameters from the request from the web form
<<<<<<< HEAD
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String payment = request.getParameter("payment");
=======
		String n = request.getParameter("name");
		int p = Integer.parseInt((request.getParameter("price")));
		String e = request.getParameter("payment");
>>>>>>> branch 'lukasBranch' of https://github.com/lukasxlrx/FinancialDiary

		// Step 3: attempt connection to database using JDBC, you can change the
		// username and password accordingly using the phpMyAdmin > User Account
		// dashboard
		try {
			Class.forName("com.mysql.jdbc.Driver");

<<<<<<< HEAD
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/financialdiary", "root", "password");
=======
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/financialdiary", "root",
					"Password");
>>>>>>> branch 'lukasBranch' of https://github.com/lukasxlrx/FinancialDiary

			// Step 4: implement the sql query using prepared statement
			// (https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html)
<<<<<<< HEAD
			PreparedStatement ps = con.prepareStatement("insert into TRANSACTION values(?,?,?,?,?)");
=======
			PreparedStatement ps = con.prepareStatement("insert into transactiondb values(?,?,?,?,?)");

			System.out.println("my session storage is " + session.getAttribute("userID"));
>>>>>>> branch 'lukasBranch' of https://github.com/lukasxlrx/FinancialDiary

			// Step 5: parse in the data retrieved from the web form request into the
			// prepared statement accordingly
			ps.setInt(1, 0);
<<<<<<< HEAD
			ps.setString(2, name);
			ps.setString(3, price);
			ps.setString(4, payment);
			ps.setInt(5, 1);
=======
			ps.setString(2, n);
			ps.setInt(3, p);
			ps.setString(4, e);
			ps.setInt(5, uid);
>>>>>>> branch 'lukasBranch' of https://github.com/lukasxlrx/FinancialDiary

			// Step 6: perform the query on the database using the prepared statement
			int i = ps.executeUpdate();

			// Step 7: check if the query had been successfully execute, return “You are
			// successfully registered” via the response,

			if (i > 0) {
				PrintWriter writer = response.getWriter();
<<<<<<< HEAD
=======
				// writer.println("<h1>" + "You have successfully registered an account!" +
				// "</h1>");
>>>>>>> branch 'lukasBranch' of https://github.com/lukasxlrx/FinancialDiary
				response.sendRedirect("http://localhost:8090/FinancialDiary/TransactionServlet/dashboard");
				writer.close();
			}
		}

		// Step 8: catch and print out any exception
		catch (Exception exception) {
			System.out.println(exception);
			out.close();
		}
<<<<<<< HEAD
		//doGet(request, response);
=======
		// doGet(request, response);
	}

	// Step 5: listUsers function to connect to the database and retrieve all users
	// records
	private void listUsers(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		HttpSession session = request.getSession();
		int uid = (int) session.getAttribute("userID");
		List<TransactionClass> users = new ArrayList<>();
		try (Connection connection = getConnection();

				// Step 5.1: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TRANSACTION);) {
			//System.out.println(uid);
			//System.out.println("userID");
			// Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
				int UserID = rs.getInt("user_id");
				if (UserID == uid) {
					int TransactionID = rs.getInt("transactionID");
					String name = rs.getString("name");
					int price = rs.getInt("price");
					String payment = rs.getString("payment");
					//System.out.println(TransactionID);
					users.add(new TransactionClass(TransactionID, name, price, payment, UserID));
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		// Step 5.4: Set the users list into the listUsers attribute to be pass to the
		// userManagement.jsp
		request.setAttribute("listUsers", users);
		System.out.println(users);
		request.getRequestDispatcher("/Transaction.jsp").forward(request, response);
	}

	// Update - Show Edit Form
	// method to get parameter, query database for existing user data and redirect
	// to user edit page
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int TransactionID = Integer.parseInt((request.getParameter("transactionID")));
		//int price = Integer.parseInt((request.getParameter("price")));
		HttpSession session = request.getSession();
		int uid = (int) session.getAttribute("userID");

		TransactionClass existingTransaction = new TransactionClass(TransactionID, "", 0 , "", uid);
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
		// Step 2:Create a statement using connection object
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TRANSACTION_BY_ID);) {
		preparedStatement.setInt(1, TransactionID);
		// Step 3: Execute the query or update query
		ResultSet rs = preparedStatement.executeQuery();
		// Step 4: Process the ResultSet object
		while (rs.next()) {
				TransactionID = rs.getInt("transactionID");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				String payment = rs.getString("payment");
				int UserID = rs.getInt("user_id");
				System.out.println(rs.getInt("transactionID"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getInt("price"));
				System.out.println(rs.getString("payment"));
				System.out.println("user id"+UserID);
				System.out.println(rs.getInt("user_id"));
				System.out.println(uid);
				System.out.println(session.getAttribute("userID"));
				existingTransaction = new TransactionClass(TransactionID, name, price, payment, UserID);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5: Set existingUser to request and serve up the userEdit form
		request.setAttribute("transaction", existingTransaction);
		request.getRequestDispatcher("/UpdateTransaction.jsp").forward(request, response);

	}

	// Update
	// method to update the user table base on the form data
	private void updateTransaction(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		// Step 1: Retrieve value from the request
		int TransactionID = Integer.parseInt((request.getParameter("TransactionID")));
		System.out.println("Updte transaction getting transaction id " + TransactionID);
		String name = request.getParameter("name");
		int price = Integer.parseInt((request.getParameter("price")));
		String payment = request.getParameter("payment");
		int UserID = Integer.parseInt((request.getParameter("UserID")));

		// Step 2: Attempt connection with database and execute update user SQL query
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_TRANSACTION_SQL);) {
			statement.setInt(1, TransactionID);
			statement.setString(2, name);
			statement.setInt(3, price);
			statement.setString(4, payment); 	
			statement.setInt(5, UserID);
			statement.setInt(6, TransactionID);
			int i = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 3: redirect back to UserServlet (note: remember to change the url to
		// your project name)
		response.sendRedirect("http://localhost:8090/FinancialDiary/TransactionServlet/dashboard");
	}

	// Delete
	// method to delete user
	private void deleteTransaction(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		// Step 1: Retrieve value from the request
		//System.out.println(Integer.parseInt(request.getParameter("transactionID")));
		int TransactionID = Integer.parseInt(request.getParameter("transactionID"));
		System.out.println(TransactionID);
		// Step 2: Attempt connection with database and execute delete user SQL query
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_TRANSACTION_SQL);) {
			statement.setInt(1, TransactionID);
			int i = statement.executeUpdate();
		}
		// Step 3: redirect back to UserServlet dashboard (note: remember to change the
		// url to your project name)
		response.sendRedirect("http://localhost:8090/FinancialDiary/TransactionServlet/dashboard");
>>>>>>> branch 'lukasBranch' of https://github.com/lukasxlrx/FinancialDiary
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
