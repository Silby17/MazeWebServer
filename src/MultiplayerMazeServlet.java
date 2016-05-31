import org.json.simple.JSONObject;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "MultiplayerMazeServlet", asyncSupported = true, urlPatterns = {"/MultiplayerMazeServlet"})
public class MultiplayerMazeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response){}



    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
