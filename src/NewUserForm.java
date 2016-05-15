import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "NewUserForm", urlPatterns = {"/NewUserForm"})
public class NewUserForm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("SignUpForm.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("username").equals("")) {
            PrintWriter out = response.getWriter();
            out.println(getErrorMessage());
        }
    }

    private String getErrorMessage(){
        String messageScript = "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                "<title>Private data</title>\n" +
                "<script>\n" +
                "alert('Please Enter in all your details!');\n" +
                "window.location = 'SignUpForm.html';" +
                "</script>\n" +
                "</head>";
        return messageScript;
    }
}