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

    /*************************************************************************
     * Initialization method that will initialize the Server Connection
     * as well as the DataBase manager
     * @param servletContextEvent
     ************************************************************************/
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Context Created");
        ServletContext context = servletContextEvent.getServletContext();

        this.dbManager = new DBManager();

        /**TO REMOVE BELOW**/
        User temp = new User("admin", "admin", "Yossi", "yo@s.com", "redNose.png");
        dbManager.addUser(temp);
        User temp2 = new User("admin2", "admin2", "Joes", "s@c.com", "panda.png");
        dbManager.addUser(temp2);
        System.out.println("Created new USer");

        context.setAttribute("database", dbManager);
        //context.setAttribute("connection", serverManager);
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

}