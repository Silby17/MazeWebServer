import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "MultiplayerMazeServlet", urlPatterns = {"/MultiplayerMazeServlet"})
public class MultiplayerMazeServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mazeName = request.getParameter("mazeName");

        ServletContext context = getServletContext();
        Object att = context.getAttribute("connection");
        ServerConnectionManager manager = (ServerConnectionManager)att;
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
