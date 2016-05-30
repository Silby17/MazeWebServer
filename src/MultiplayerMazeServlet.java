import org.json.simple.JSONObject;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "MultiplayerMazeServlet", urlPatterns = {"/MultiplayerMazeServlet"})
public class MultiplayerMazeServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mazeName = request.getParameter("mazeName");
        System.out.println("Maze name from request: " + mazeName);
        mazeName = mazeName.replaceAll("(\\r|\\n|\\t)", "");

        System.out.println("Done");
        String command = "3 " + mazeName;
        User user = (User)request.getSession().getAttribute("user");
        System.out.println("Session ID: " + request.getSession().getId());

        String multipleMaze = user.getConnectionManager().sendToServer(command);

        System.out.println("MultipleMaze:");
        System.out.println(multipleMaze);
        JSONObject obj = new JSONObject();
        obj.put("multiMaze", multipleMaze);
        response.setContentType("application/json");
        try{
            PrintWriter out = response.getWriter();
            out.println(obj);
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Maze has been put into Object");


/**
        Thread getThread = new Thread(){
            public void run(){

                JSONObject obj = new JSONObject();
                obj.put("multiMaze", multipleMaze);
                response.setContentType("application/json");
                try {
                    PrintWriter out = response.getWriter();
                    out.println(obj);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Maze has been put into Object");
            }
        };
        getThread.start();
 **/

    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
