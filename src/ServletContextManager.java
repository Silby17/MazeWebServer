import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.*;

/******************************************************************************
 * This Class will initialize the Contexts and add attributes that will be
 * able to be accessed throughout the application
 *****************************************************************************/
public class ServletContextManager implements ServletContextListener {
    private DBManager dbManager;
    private ServerConnectionManager serverManager;
    private String IP;
    private int PORT;


    /*************************************************************************
     * Initialization method that will initialize the Server Connection
     * as well as the DataBase manager
     * @param servletContextEvent
     ************************************************************************/
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Context Created");
        readConfigInfo();
        ServletContext context = servletContextEvent.getServletContext();
        serverManager = new ServerConnectionManager(IP, PORT);
        this.dbManager = new DBManager();

        /**TO REMOVE BELOW**/
        User temp = new User("admin", "admin", "Yossi", "yo@s.com", "redNose.png");
        dbManager.addUser(temp);


        context.setAttribute("database", dbManager);
        context.setAttribute("connection", serverManager);
        System.out.println("Context initialized");
    }


    /************************************************************************
     * This method will destroy the context at the end of the running
     * of the application
     * @param servletContextEvent
     ***********************************************************************/
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Context destroyed");
    }


    /*******************************************************************
     * This method will read the IP and PORT from the cinfig.txt file
     * for connection with the server
     ******************************************************************/
    private void readConfigInfo(){
        InputStream in = getClass().getResourceAsStream("config.txt");
        Reader nr = null;
        BufferedReader br = null;
        try{
            br = new BufferedReader(new InputStreamReader(in));
            IP = br.readLine();
            PORT = Integer.parseInt(br.readLine());
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}