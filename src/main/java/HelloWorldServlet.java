import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello-world")
public class HelloWorldServlet extends HttpServlet {

//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println("Not Hello, world!");
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html");

        try{
            PrintWriter out = response.getWriter();
            out.println("Hello World");
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
