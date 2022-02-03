public class TransactionClass {
	protected int TransactionID;

	protected String name;

	protected int price;

	protected String payment;

	protected int UserID;

	public TransactionClass(int transactionID, String name, int price, String payment, int UserID) {
		super();
		this.TransactionID = transactionID;
		this.name = name;
		this.price = price;
		this.payment = payment;
		this.UserID = UserID;
	}

	public int getTransactionID() {
		return TransactionID;
	}

	public void setTransactionID(int transactionID) {
		TransactionID = transactionID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int UserID) {
		this.UserID = UserID;
	}
}
