
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//for login
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

// Import libraris from java.io and java.sql
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String jdbcURL = "jdbc:mysql://localhost:3306/financialdiary";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";

	//using email, password
//	private static final String INSERT_USERS_SQL = "INSERT INTO UserDetails"
//			+ " (password, email,) VALUES " + " (?, ?, ?);";

	private static final String SELECT_USER_BY_ID = "select * from user where UserID =?";
	private static final String SELECT_ALL_USERS = "select * from user ";
	private static final String DELETE_USERS_SQL = "delete from user where UserID = ?;";
	private static final String UPDATE_USERS_SQL = "update user set username = ?,password= ?,email =?, firstname =?, lastname =? where UserID = ?;";
	
	// For login SQL statement
	private static final String LOGIN_USER_SQL = "SELECT * FROM user WHERE username =? and password =?";
	
	//implementing the getConnection method which facilitate connection to database via JDBC
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
	public LoginServlet() {
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
		
		// Depending on the request servlet path, determine the function to
		// invoke using the follow switch statement.
		
		String action = request.getServletPath();
		try {
			switch (action) {
			
			case "/LoginServlet/login":
				break;
			case "LoginServlet/logout":
				break;
			case "/delete":
				break;
			case "/edit":
				break;
			case "/update":
				break;
			default:
				loginUsers(request, response);
				break;
				
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	

	
	// for login
	private void loginUsers(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		HttpSession session = request.getSession();
		String enterUsername = request.getParameter("username");
		String enterPassword = request.getParameter("password");
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			preparedStatement.setString(1, enterUsername);
			preparedStatement.setString(2, enterPassword);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				if (rs.getString("username").equals(enterUsername)
						&& (rs.getString("password").equals(enterPassword))) {
					int uid = rs.getInt("UserID");
					String username = rs.getString("username");
					// setAttribute() is to save an object in session by assigning a unique string
					// to the object.
					session.setAttribute("UserID", uid);
					session.setAttribute("username", username);
					session.setAttribute("isLoggedIn", true);
					// getAttribute() the object stored by setAttribute method is fetched from
					// session using getAttribute method
					session.getAttribute("UserID");
					session.getAttribute("username");
					session.getAttribute("isLoggedIn");
					System.out.println(session.getAttribute("UserID"));
					System.out.println(session.getAttribute("username"));
					response.sendRedirect("http://localhost:8090/FinancialDiary/Profile?UserID=" + uid);
				}
			} else {
				System.out.println("Wrong username or password");
				response.sendRedirect("http://localhost:8090/FinancialDiary/Login.jsp");
			}
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// For Logging Out
	private void LogOutUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		session.invalidate();
		System.out.println("You are logged out");
		response.sendRedirect("http://localhost:8090/FinancialDiary/login.jsp");

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
