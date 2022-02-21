import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author pys30
 *
 */

class TransactionServletTest {
	TransactionServlet transactionservlet = new TransactionServlet();
	private int TransactionID;
	private String name;
	private int price;
	private String payment;
	private int UserID;
	private int FakeUserID;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		TransactionID = 1;
		name = "Dao Yuan";
		price = 2;
		payment = "Ez-Link";
		UserID = 4;
		FakeUserID = 0;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link TransactionServlet#CreateTransaction(java.lang.String, int, java.lang.String, int)}.
	 * @throws ServletException 
	 */
	@Test
	void testCreateTransaction(){
		int i = transactionservlet.CreateTransaction(name, price, payment, UserID);
		assertTrue(i > 0);
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link TransactionServlet#RetrieveTransaction(java.util.List, int, javax.servlet.http.HttpSession, java.io.PrintWriter)}.
	 */
	@Test
	void testRetrieveTransaction() {
		List<TransactionClass> retrievetransaction = transactionservlet.RetrieveTransaction(UserID);
		assertTrue(!retrievetransaction.equals(null));
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link TransactionServlet#UpdateTransaction(int, java.lang.String, int, java.lang.String, int)}.
	 */
	@Test
	void testUpdateTransaction() {
		boolean checkUpdated = transactionservlet.UpdateTransaction(1, "Mr Lim", 2, "Card", 4);
		assertEquals(checkUpdated, true);
	}

	/**
	 * Test method for {@link TransactionServlet#DeleteTransaction(int)}.
	 */
	@Test
	void testDeleteTransaction() {
		boolean checkDeleted = transactionservlet.DeleteTransaction(4);
		assertEquals(checkDeleted, true);
	}

}
