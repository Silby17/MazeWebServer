
public class User {
    private String userName;
    private String password;
    private String name;
    private String email;
    private String icon;


    public User(){}

    public User(String usrName, String pswrd, String name,
                String email, String icon) {

        this.userName = usrName;
        this.password = pswrd;
        this.name = name;
        this.email = email;
        this.icon = icon;
    }

    public String getUsername() {
        return userName;
    }

    public String getPassword(){
        return this.password;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getIcon(){
        return icon;
    }
}