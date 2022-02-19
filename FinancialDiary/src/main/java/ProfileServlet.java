
import java.io.IOException;
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

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Step 1: Prepare list of variables used for database connections
	private String jdbcURL = "jdbc:mysql://localhost:3306/financialdiary";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";
	// Step 2: Prepare list of SQL prepared statements to perform CRUD to our
	// database
	private static final String INSERT_USERS_SQL = "INSERT INTO user" + " (username, password, email, firstname, lastname) VALUES " + " (?, ?, ?, ?, ?, ?);";
	private static final String SELECT_USER_BY_ID_UPDATE = "select userID,username,password,email,firstname,lastname from user where username =?";
	private static final String SELECT_ALL_USERS = "select * from user ";
	private static final String SELECT_USER_BY_ID = "select * from user where userID = ?";
	private static final String DELETE_USERS_SQL = "delete from user where username = ?";
	private static final String UPDATE_USERS_SQL = "update user set userID = ?,username = ?,password= ?, email =?,firstname =?, lastname=? where username = ?;";

	// Step 3: Implement the getConnection method which facilitates connection to
	// the database via JDBC
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

	// Step 5: listUsers function to connect to the database and retrieve all users
	// records
	private void listUsers(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		// Get userID from session
		HttpSession session = request.getSession();
		session.getAttribute("userID");
		session.getAttribute("username");
		System.out.println("4.1. Get userID from session storage");

		List<UserClass> users = new ArrayList<>();
		try (Connection connection = getConnection();
				// Step 5.1: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			// Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
				int userID = rs.getInt("userID");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				users.add(new UserClass(userID, username, password, email, firstname, lastname));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5.4: Set the users list into the listUsers attribute to be pass to the
		// userManagement.jsp
		request.setAttribute("listUsers", users);
		request.getRequestDispatcher("/Profile.jsp").forward(request, response);
	}

	// method to get parameter, query database for existing user data and redirect
	// to user edit page
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// get parameter passed in the URL
		String username = request.getParameter("username");
		UserClass existingUser = new UserClass(0, "", "", "", "", "");
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID_UPDATE);) {
			preparedStatement.setString(1, username);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object
			while (rs.next()) {
				int userID = rs.getInt("userID");
				username = rs.getString("username");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				existingUser = new UserClass(userID, username, password, email, firstname, lastname);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5: Set existingUser to request and serve up the userEdit form
		request.setAttribute("user", existingUser);
		request.getRequestDispatcher("/userEdit.jsp").forward(request, response);
	}

	// method to update the user table base on the form data
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// Step 1: Retrieve value from the request
		int userID = Integer.parseInt(request.getParameter("userID"));
		String oriName = request.getParameter("oriName");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");

		// Step 2: Attempt connection with database and execute update user SQL query
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setInt(1, userID);
			statement.setString(2, username);
			statement.setString(3, password);
			statement.setString(4, email);
			statement.setString(5, firstname);
			statement.setString(6, lastname);
			statement.setString(7, oriName);
			int i = statement.executeUpdate();
		}
		// Step 3: redirect back to UserServlet (note: remember to change the url to
		// your project name)
		response.sendRedirect("http://localhost:8090/FinancialDiary/ProfileServlet/dashboard");
	}

	// method to delete user
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// Step 1: Retrieve value from the request
		String username = request.getParameter("username");
		// Step 2: Attempt connection with database and execute delete user SQL query
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setString(1, username);
			int i = statement.executeUpdate();
		}
		HttpSession session = request.getSession();
		session.removeAttribute("userID");
		session.removeAttribute("username");
		session.invalidate();
		// Step 3: redirect back to UserServlet dashboard (note: remember to change the
		// url to your project name)
		response.sendRedirect("http://localhost:8090/FinancialDiary/Login.jsp");
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfileServlet() {
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

		// Step 4: Depending on the request servlet path, determine the function to
		// invoke using the follow switch statement.
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/ProfileServlet/delete":
				deleteUser(request, response);
				break;
			case "/ProfileServlet/edit":
				showEditForm(request, response);
				break;
			case "/ProfileServlet/update":
				updateUser(request, response);
				break;
			case "/ProfileServlet/dashboard":
				listUsers(request, response);
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
		doGet(request, response);
	}
}
