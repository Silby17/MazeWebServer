import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/***************************************************************************
 * This class is Responsible for adding a new user to the application
 ***************************************************************************/
@WebServlet(name = "NewUserForm", urlPatterns = {"/NewUserForm"})
public class NewUserForm extends HttpServlet {


    /************************************************************************
     * This Method gets the html form to be displayed
     * @param request - the request info
     * @param response - response info
     * @throws ServletException
     * @throws IOException
     ************************************************************************/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("SignUpForm.html");
    }


    /************************************************************************
     * This method is in charge of posting that is done from the sign up form
     * @param request - request information
     * @param response - response information
     * @throws ServletException
     * @throws IOException
     ************************************************************************/
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usrName = request.getParameter("username").toLowerCase();
        String pass = request.getParameter("password").toLowerCase();
        String name = request.getParameter("name").toLowerCase();
        String email = request.getParameter("email").toLowerCase();

        String panda = request.getParameter("panda");
        String face = request.getParameter("redFace");
        String nose = request.getParameter("redNose");
        System.out.println("icon logo print: " + panda);
        System.out.println("icon logo print: " + face);
        System.out.println("icon logo print: " + nose);

        //Checks that none of the input boxes are empty.
        if(usrName.equals("") || pass.equals("") || name.equals("") ||
                email.equals("")) {
            PrintWriter out = response.getWriter();
            out.println(getErrorMessage());
        }

        //If all boxes have been filled out then extract the all the info
        //and create a new User to be added to the DataBase
        else{
            System.out.println("In new user Form");
            System.out.println(usrName + " " + pass);
            User newUser = new User(usrName, pass, name, email, "stum");
            ServletContext context = getServletContext();
            Object att = context.getAttribute("database");
            DBManager manager = (DBManager)att;
            manager.addUser(newUser);
            HttpSession session = request.getSession();
            response.sendRedirect("MyFormServlet");
        }
    }


    /**************************************************************************
     * This produces and error message to be displayed to the user telling him
     * o fill in all their details.
     * @return - the Script
     *************************************************************************/
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