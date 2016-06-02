import org.json.simple.JSONObject;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GetPlayerMoveServlet", asyncSupported = true, urlPatterns = {"/GetPlayerMoveServlet"})
public class GetPlayerMoveServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Starting doGet of getMOve");
        boolean asyncSupported = request.isAsyncSupported();
        request.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true);
        asyncSupported = request.isAsyncSupported();

        if (asyncSupported) {
            AsyncContext asyncCtx = request.startAsync(request, response);  // req.startAsync();
            asyncCtx.setTimeout(0); // => disable timeout
            AsyncRunnable thread = new AsyncRunnable(asyncCtx);
            asyncCtx.start(thread);
        }

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {}
}


class AsyncRunnable implements Runnable{
    private final AsyncContext asyncContext;

    public AsyncRunnable(AsyncContext asContext){
        this.asyncContext = asContext;
    }

    public void run(){
        System.out.println("Starting running");
        HttpServletResponse res = (HttpServletResponse)asyncContext.getResponse();
        HttpServletRequest req = (HttpServletRequest)asyncContext.getRequest();
        User user = (User)req.getSession().getAttribute("user");
        System.out.println("Got the user from the session");
        PrintWriter out = null;

        try{
            String fromServer = user.getConnectionManager().getMsgFromServer();
            System.out.println("Got from Server =  " + fromServer);
            System.out.println();
            fromServer = fromServer.replaceAll("(\\n|\\r)", "");
            JSONObject obj = new JSONObject();
            obj.put("playerMove", fromServer);
            out = res.getWriter();
            out.println(obj);
            res.setContentType("application/json");
            asyncContext.complete();

        }catch(IOException e){
            e.printStackTrace();
        }

    }
}