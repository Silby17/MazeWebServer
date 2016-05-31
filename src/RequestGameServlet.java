import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RequestGameServlet", urlPatterns = {"/RequestGameServlet"})
public class RequestGameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String gameName = request.getParameter("gameName");
        String command = "3 " + gameName;
        command = command.replaceAll("(\\r|\\n|\\t)", "");
        User user = (User)request.getSession().getAttribute("user");
        user.getConnectionManager().sendRequest(command);
        response.sendRedirect("/Multiplayer.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
