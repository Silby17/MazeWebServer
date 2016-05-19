import java.util.HashMap;


/*************************************************************
 * This Class will deal with the User Database,
 * it will add anew users and check if the login details
 * are correct for an existing user.
 ************************************************************/
public class DBManager {
    private HashMap<String, User> userMap;


    /******************************************************************
     * Default Constructor that will create a initialize the HashMap
     *****************************************************************/
    public DBManager(){
        this.userMap = new HashMap<>();
    }


    /******************************************************************
     * Adds a new user to the HashMap
     * @param user - New user to be added
     ******************************************************************/
    public void addUser(User user){
        this.userMap.put(user.getUserName(), user);
    }


    /******************************************************************
     * This Method will check if the users Login details are correct
     * @param userName - userName of user
     * @param pass - Password of the user
     * @return = True if they are correct and False if incorrect
     ******************************************************************/
    public boolean checkLoginDetails(String userName, String pass){
        System.out.println("in details check");
        System.out.println(userMap.size());
        if(userMap.get(userName) == null)
        {
            return false;
        }
        else{
            if(userMap.get(userName).getPassword().toLowerCase().
                    equals(pass.toLowerCase())){
                System.out.println("return true");
                return true;
            }
            else{
                System.out.println("return false");
                return false;
            }
        }
    }

    public User getUser(String username){
        return userMap.get(username);
    }
}