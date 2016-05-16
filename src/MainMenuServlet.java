import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*********************************************************************
 * This Class is the Servlet that will deal with the Main Game Menu
 *********************************************************************/
@WebServlet(name = "MainMenuServlet", urlPatterns = {"/MainMenuServlet"})
public class MainMenuServlet extends HttpServlet {

    /******************************************************************
     * This method gets the info that was posted from the html file
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     ******************************************************************/
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Checks what Button on the Menu was clicked
        if(request.getParameter("singleBtn") != null)
        {
            System.out.println("Single player button was clicked");
        }
        else if(request.getParameter("multiBtn") != null){
            System.out.println("Multiplayer button was pressed");
        }
    }

    /************************************************************************
     * This method will get the html file to send to the client to display
     * @param request - the request info
     * @param response - the response info
     * @throws ServletException
     * @throws IOException
     ************************************************************************/
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //The MainMenu html file
        response.sendRedirect("MainMenu.html");
    }
}
