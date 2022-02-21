
import java.util.*;

public class LoginCollection {

    private ArrayList<UserClass> users = new ArrayList<>();
    private int capacity;

    public LoginCollection() {
		
		users.add(new UserClass(0,"dennis","123456", "dennis@gmail.com", "dennis","test")); 
		users.add(new UserClass(1,"yongshun","123456", "ys@gmail.com","yong", "shun")); 
		users.add(new UserClass(2,"lukas","123456","lukas@gmail.com", "lukas", "lee"));
		 

        this.capacity = 20;
    }

    public LoginCollection(int capacity) {
        this.capacity = capacity;
    }
    
    public void addUser(UserClass user) {
    	if(users.size() != capacity) {
    		users.add(user);
    	}
    }

    public List<UserClass> getUsers() {
        return users;
    }

}
