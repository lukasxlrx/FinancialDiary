import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * 
 */

/**
 * @author dennis
 *
 */
class LoginServletTest {
	private LoginServlet loginServlet = new LoginServlet();
	private int userID;
	private String username;
	private String password;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		userID = 4;
		username = "dennis";
		password = "123456";
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link LoginServlet#loginUserFunction(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testLoginUserFunction() {
		//fail("Not yet implemented");
		var correctCredentials = LoginServlet.loginUserFunction(username, password);
		var wrongCredentials = LoginServlet.loginUserFunction("lukas", "123456");
		assertTrue(!correctCredentials.equals(wrongCredentials));
	}

}
