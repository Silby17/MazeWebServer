package controllers;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import beans.DBManager;
import beans.User;


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
        ServletContext context = servletContextEvent.getServletContext();
        this.dbManager = new DBManager();

        /**TO REMOVE BELOW**/
        User temp = new User("admin", "admin", "Yossi", "yo@s.com", "redNose.png");
        dbManager.addUser(temp);
        User temp2 = new User("admin2", "admin2", "Joe", "s@c.com", "panda.png");
        dbManager.addUser(temp2);

        context.setAttribute("database", dbManager);
        System.out.println("Context initialized Successfully");
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