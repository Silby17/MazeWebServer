import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "MyPrivateData", urlPatterns = {"/secured/MyPrivateData"})
public class MyPrivateData extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<User> users = new ArrayList<User>();
        ServletContext context = getServletContext();
        Object att = context.getAttribute("connection");
        ServerConnectionManager man = (ServerConnectionManager)att;


        HttpSession session = request.getSession(false);
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html><head>");
            out.println("<title>My Form Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div>Welcome " + session.getAttribute("name") + "!</div>");
            out.println("</body></html>");
        }
    }
}