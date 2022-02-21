import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RegisterCollectionTest {

	private RegisterCollection rc;
	private UserClass u1;
	private UserClass u2;
	private UserClass u3;
	private final int REGISTER_COLLECTION_SIZE = 3;

	@BeforeEach
	void setUp() throws Exception {
		// Arrange
		rc = new RegisterCollection();
		u1 = new UserClass(1, "daoyuan", "123", "dy@gmail.com", "dao", "yuan");
		u2 = new UserClass(2, "yongshun", "123", "ys@gmail.com", "yong", "shun");
		u3 = new UserClass(3, "lukas", "123", "lukas@gmail.com", "lukas", "lee");

		rc.addUser(u1);
		rc.addUser(u2);
		rc.addUser(u3);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddUser() {
		// fail("Not yet implemented");
		List<UserClass> testRc = rc.getUsers();
		// Assert that Login Collection is equals to login collection size 4
		assertEquals(testRc.size(), REGISTER_COLLECTION_SIZE);
		// act
		rc.addUser(u1);
	}

}
