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
        if (request.getParameter("username").equals("admin") &&
                request.getParameter("password").equals("admin")) {
            HttpSession session = request.getSession();
            response.sendRedirect("secured/MyPrivateData");
        } else {
            request.setAttribute("error", true);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}