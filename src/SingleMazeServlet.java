import org.json.simple.JSONObject;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;


@WebServlet(name = "SingleMazeServlet", urlPatterns = {"/SingleMazeServlet"})
public class SingleMazeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Inside doGet of SingleMazeServlet");
        ServletContext context = getServletContext();
        Object att = context.getAttribute("connection");
        ServerConnectionManager con = (ServerConnectionManager) att;

        //Makes a random number for the Maze Name
        Random rand = new Random();
        int randNum = rand.nextInt(40);
        String number = Integer.toString(randNum);
        String singleCommand = "1 Game";
        singleCommand += number + " " + 0;

        //Sends the command for a new maze to the server
        String mazeFromServer = con.sendToServer(singleCommand);
        System.out.println("Maze From Server NEW: " + mazeFromServer);

        String mazeString = mazeFromServer.substring(0, 234);
        JSONObject object = new JSONObject();
        object.put("singleMaze", mazeString);
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.println(object);
    }
}
