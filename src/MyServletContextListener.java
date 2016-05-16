import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/******************************************************************************
 * This Class will initialize the Contexts and add attributes that will be
 * able to be accessed throughout the application
 *****************************************************************************/
public class MyServletContextListener implements ServletContextListener {
    private DBManager dbManager;
    private ServerConnectionManager serverManager;


    /*************************************************************************
     * Initialization method that will initialize the Server Connection
     * as well as the DataBase manager
     * @param servletContextEvent
     ************************************************************************/
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext context = servletContextEvent.getServletContext();
        serverManager = new ServerConnectionManager("127.0.0.1", 80);
        this.dbManager = new DBManager();
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
}