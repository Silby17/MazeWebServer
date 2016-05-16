import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "MyFormServlet", urlPatterns = {"/MyFormServlet"})
public class MyFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = getServletContext();
        Object att = context.getAttribute("database");
        DBManager manager = (DBManager)att;
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        if(userName.equals("admin") && password.equals("admin")){
            HttpSession session = request.getSession();
            response.sendRedirect("/MainMenuServlet");
        }
        else{
            request.setAttribute("error", true);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        /**
        if(manager.checkLoginDetails(userName, password))
        {
            HttpSession session = request.getSession();
            response.sendRedirect("secured/MyPrivateData");
        }
        else {
            request.setAttribute("error", true);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
         **/
    }
}