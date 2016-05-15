import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class MyServletContextListener implements ServletContextListener {

    private ServerConnectionManager serverManager;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Context initialized");
        ServletContext context = servletContextEvent.getServletContext();
        serverManager = new ServerConnectionManager("127.0.0.1", 80);

        context.setAttribute("connection", serverManager);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Context destroyed");
    }
}