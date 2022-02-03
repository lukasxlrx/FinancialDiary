public class TransactionClass
{
	protected int transactionid;
	protected String name;
	protected String price;
	protected String payment;
	protected int user_id;
	
	public int getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public TransactionClass(int transactionid, String name, String price, String payment, int user_id) {
		super();
		this.transactionid = transactionid;
		this.name = name;
		this.price = price;
		this.payment = payment;
		this.user_id = user_id;
	}
}
