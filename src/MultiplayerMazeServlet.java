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
    private AsyncContext asyncContext;
    private ServerConnectionManager server;


    @Override
    public void init() throws ServletException {
        System.out.println("INIT");
        generator.start();
    }
    @Override
    public void destroy() {
        generator.interrupt();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        System.out.println("doGet of MultiMazeServlet");
        User user = (User)request.getSession().getAttribute("user");
        this.server = user.getConnectionManager();
        System.out.println(user.getUserName());
        AsyncContext async = request.startAsync();
        async.setTimeout(0);
        asyncContext = async;
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    private final Thread generator = new Thread(){
        private int counter = 0;
        @Override
        public void run(){
            System.out.println("Running run of thread");

            while(!Thread.currentThread().isInterrupted()){
                try{
                    Thread.sleep(1000);
                    if (asyncContext == null) {
                        asyncContext = null;
                        this.counter = 0;
                    }
                    else{
                        System.out.println("Waiting for reply from server...");
                        String jsonString = server.getMsgFromServer();
                        jsonString = jsonString.replaceAll("(\\r|\\n)", "");

                        int i = 520;
                        int j = 521;
                        boolean end = true;
                        while(end){
                            if(jsonString.charAt(i) == '}' && jsonString.charAt(j) == '}'){
                                jsonString = jsonString.substring(0, j + 1);
                                end = false;
                            }
                            else{
                                i++;
                                j++;
                            }
                        }
                        JSONObject obj = new JSONObject();
                        obj.put("multiMaze", jsonString);
                        System.out.println("Put in object");
                        HttpServletResponse resp = (HttpServletResponse)asyncContext.getResponse();
                        resp.getWriter().println(obj);
                        resp.setContentType("application/json");
                        System.out.println("Before Complete");

                        asyncContext.complete();
                    }

                }catch (IOException e){
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };
}
