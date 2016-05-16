import java.util.HashMap;

public class DBManager {
    private HashMap<String, User> userMap;


    public DBManager(){
        this.userMap = new HashMap<>();
    }

    public void addUser(User user){
        this.userMap.put(user.getUsername(), user);
    }


    public boolean checkLoginDetails(String userName, String pass){
        if(userMap.get(userName).getPassword() == pass){
            return true;
        }
        else{
            return false;
        }
    }
}
