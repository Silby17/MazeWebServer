import com.sun.org.apache.xpath.internal.SourceTree;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*****************************************************************************
 * This class will handle the closing of the Multiplayer game with the Server
 *****************************************************************************/
@WebServlet(name = "CloseGameServlet", urlPatterns = {"/CloseGameServlet"})
public class CloseGameServlet extends HttpServlet {

    /*************************************************************************
     * This method will get the name of the game from the request
     * and send a close request to the server
     * @param request - request from client
     * @param response - response to send
     * @throws ServletException
     * @throws IOException
     *************************************************************************/
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("In close Game Servlet");
        User user = (User)request.getSession().getAttribute("user");
        String fromClient = request.getParameter("gameName");
        System.out.println("string from Client");
        String closeCommand = 5 + " " + fromClient;
        user.getConnectionManager().sendRequest(closeCommand);
        try{
            Thread.sleep(3000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        response.sendRedirect("controllers.MenuServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {}
}
