
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

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getIcon() {
        return icon;
    }
}