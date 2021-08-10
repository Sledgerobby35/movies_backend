import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet(name = "ServletExercise", urlPatterns = "/servEx")
public class ServletExercise extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html");

        try{
            PrintWriter out = response.getWriter();
            out.println("This is just a test!!!!!!");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
