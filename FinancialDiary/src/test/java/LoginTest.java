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
class LoginTest {
	
	private LoginCollection lc;
	private UserClass u1;
	private UserClass u2;
	private UserClass u3;
	private final int LOGIN_COLLECTION_SIZE = 3;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		//Arrange
		lc = new LoginCollection();
		u1 = new UserClass(0,"dennis","123456", "dennis@gmail.com", "dennis", "test");
		u2 = new UserClass(1,"yongshun","123456", "ys@gmail.com", "yong", "shun");
		u3 = new UserClass(2,"lukas","123456", "lukas@gmail.com", "lukas", "lee");
		lc.addUser(u1);
		lc.addUser(u2);
		lc.addUser(u3);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link LoginCollection#addUser(UserClass)}.
	 */
	@Test
	void testAddUser() {
		//fail("Not yet implemented");
		List<UserClass> testLc = lc.getUsers();
		//Assert that Login Collection is equals to login collection size 4
		assertEquals(testLc.size(), LOGIN_COLLECTION_SIZE);
		//act
		lc.addUser(u1);
		
	}

	/**
	 * Test method for {@link LoginCollection#getUsers()}.
	 */
	@Test
	void testGetUsers() {
		//fail("Not yet implemented");
		List<UserClass> testLc = lc.getUsers();
        assertEquals(testLc.size(), LOGIN_COLLECTION_SIZE);
        assertEquals(lc.getUsers().size(), LOGIN_COLLECTION_SIZE);
	}

}
