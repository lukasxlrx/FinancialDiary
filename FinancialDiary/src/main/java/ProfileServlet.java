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

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Step 1: Prepare list of variables used for database connections
	 private String jdbcURL = "jdbc:mysql://localhost:3306/financialdiary";
	 private String jdbcUsername = "root";
	 private String jdbcPassword = "Password";
	 //Step 2: Prepare list of SQL prepared statements to perform CRUD to our database
	 private static final String INSERT_USERS_SQL = "INSERT INTO UserDetails" + " (username, password, email, firstname, lastname) VALUES " + " (?, ?, ?, ?, ?, ?);";
	 private static final String SELECT_USER_BY_ID = "select userID,username,password,email,firstname,lastname from User where userID =?";
	 private static final String SELECT_ALL_USERS = "select * from User ";
	 private static final String DELETE_USERS_SQL = "delete from User where userID = ?;";
	 private static final String UPDATE_USERS_SQL = "update User set username = ?,password= ?, email =?,firstname =?, lastname=? where userID = ?;";
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
	 
	 
	 
	//Step 5: listUsers function to connect to the database and retrieve all users records
	 private void listUsers(HttpServletRequest request, HttpServletResponse response)
	 throws SQLException, IOException, ServletException
	 {
	 List <UserClass> users = new ArrayList <>();
	  try (Connection connection = getConnection();
	  // Step 5.1: Create a statement using connection object
	  PreparedStatement preparedStatement =
	 connection.prepareStatement(SELECT_ALL_USERS);) {
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
	 // Step 5.4: Set the users list into the listUsers attribute to be pass to the userManagement.jsp
	 request.setAttribute("listUsers", users);
	 request.getRequestDispatcher("/userManagement.jsp").forward(request, response);
	 }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//Step 4: Depending on the request servlet path, determine the function to invoke using the follow switch statement.
		String action = request.getServletPath();
		 try {
		 switch (action) {
		 case "/insert":
		 break;
		 case "/delete":
		 break;
		 case "/edit":
		 break;
		 case "/update":
		 break;
		 default:
		 listUsers(request, response);
		 break;
		 }
		 } catch (SQLException ex) {
		 throw new ServletException(ex);
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
