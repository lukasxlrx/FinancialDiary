import java.util.*;

public class TransactionCollection {

    private ArrayList<TransactionClass> transactions = new ArrayList<>();
    private int capacity;

    public TransactionCollection() {
//        transactions.add(new TransactionClass(1, "Dao Yuan", 1, "Popular Voucher", 1));
//        transactions.add(new TransactionClass(1, "Dao Yuan", 2, "CreditCard", 1));
//        transactions.add(new TransactionClass(1, "Dao Yuan", 3, "Cash", 1));
//        transactions.add(new TransactionClass(1, "Dao Yuan", 4, "Ez-link Card", 1));

        this.capacity = 20;
    }

    public TransactionCollection(int capacity) {
        this.capacity = capacity;
    }

    public List<TransactionClass> listUsers() {
      int uid = 1;
//      function B() {
//    	  
//      }
      return transactions;
    }
    
    

    public void addTransaction(TransactionClass transaction) {
        if(transactions.size() != capacity) {
            transactions.add(transaction);
        }
    }
}