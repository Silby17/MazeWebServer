package beans;

import beans.User;

import java.io.*;
import java.util.HashMap;


/*************************************************************
 * This Class will deal with the beans.User Database,
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
        //deserializeUsers();
    }


    /******************************************************************
     * Adds a new user to the HashMap
     * @param user - New user to be added
     ******************************************************************/
    public void addUser(User user){
        this.userMap.put(user.getUserName(), user);
        //serializeUsers();
    }


    /******************************************************************
     * This Method will check if the users Login details are correct
     * @param userName - userName of user
     * @param pass - Password of the user
     * @return = True if they are correct and False if incorrect
     ******************************************************************/
    public boolean checkLoginDetails(String userName, String pass){
        if(userMap.get(userName) == null)
        {
            return false;
        }
        else{
            if(userMap.get(userName).getPassword().toLowerCase().
                    equals(pass.toLowerCase())){
                return true;
            }
            else{
                return false;
            }
        }
    }

    public User getUser(String username){
        return userMap.get(username);
    }


    /**********************************************************************
     * This method will save all the users by serializing them to a file
     *********************************************************************/
    public void serializeUsers(){
        try{
            FileOutputStream fos = new FileOutputStream("users.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(userMap);
            oos.close();
            fos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**********************************************************************
     * This method will deserialize the HashMap of all the Users
     *********************************************************************/
    public void deserializeUsers(){

        try{
            FileInputStream fis = new FileInputStream("users.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            userMap = (HashMap)ois.readObject();
            ois.close();
            fis.close();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException c){
            c.printStackTrace();
        }
    }
}