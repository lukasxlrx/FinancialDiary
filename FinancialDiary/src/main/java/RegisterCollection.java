import java.util.*;

public class RegisterCollection {

    private ArrayList<UserClass> users = new ArrayList<>();
    private int capacity;

    public RegisterCollection() {
    	/*users.add(new UserClass(0, "daoyuan","123","dy@gmail.com", "dao", "yuan"));
    	users.add(new UserClass(1, "yongshun","123","ys@gmail.com", "yong", "shun"));
    	users.add(new UserClass(2, "dennis","123","dennis@gmail.com", "den", "nis"));
    	users.add(new UserClass(3, "lukas", "123", "lukas@gmail.com", "lukas", "lee"));*/

        this.capacity = 20;
    }

    public RegisterCollection(int capacity) {
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
