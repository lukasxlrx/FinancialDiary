import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RegisterServletJunitTest {
	private RegisterServlet registerServlet = new RegisterServlet();
	private String username;
	private String password;
	private String email;
	private String firstname;
	private String lastname;

	@BeforeEach
	void setUp() throws Exception {
		username = "junitTest";
		password = "123";
		email = "junit@gmail.com";
		firstname = "junit";
		lastname = "test";
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testRegister() {
		//fail("Not yet implemented");
		int i = registerServlet.register(username, password, email, firstname, lastname);
		
		assertTrue(i > 0);
	}

	@Test
	void testDoPostHttpServletRequestHttpServletResponse() {
		//fail("Not yet implemented");
	}

}
