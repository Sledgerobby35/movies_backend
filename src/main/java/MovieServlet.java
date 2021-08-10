import com.google.gson.Gson;
import data.DaoFactory;
import data.Movie;
import data.MoviesDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

@WebServlet(name = "MovieServlet", urlPatterns = "/movies")
public class MovieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("application/json");

        try{
            PrintWriter out = response.getWriter();

//            Movie movie = new Movie(2,"Lion King", "1996-06-17", "Walt Disney",
//                    "People", "no poster", "Family", "A lion grows up");

            MoviesDao moviesDao =
                    DaoFactory.getMoviesDao(DaoFactory.ImplType.IN_MEMORY);

            String movieString = new Gson().toJson(moviesDao.all());

            out.println(movieString);

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("application/json");

        PrintWriter out = null;

        try{
            out = response.getWriter();
            Movie[] movies = new Gson().fromJson(request.getReader(), Movie[].class);
            DaoFactory.getMoviesDao(DaoFactory.ImplType.IN_MEMORY).insert(movies[0]);
            for(Movie movie : movies){
                System.out.println(movie.getId());
                System.out.println(movie.getTitle());
                System.out.println(movie.getActors());
                System.out.println(movie.getDirector());
                System.out.println(movie.getGenre());
                System.out.println(movie.getPlot());
                System.out.println(movie.getYear());
                System.out.println(movie.getPoster());
                System.out.println("*****************************************");
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        out.println(new Gson().toJson("{message: \"Movies POST was successful\"}"));
        response.setStatus(200);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("application/json");

        PrintWriter out = null;
        try {
            out = response.getWriter();
            Movie movie = new Gson().fromJson(request.getReader(), Movie.class);
            DaoFactory.getMoviesDao(DaoFactory.ImplType.IN_MEMORY).update(movie);
        } catch (SQLException e) {
            out.println(new Gson().toJson(e.getLocalizedMessage()));
            response.setStatus(500);
            e.printStackTrace();
            return;
        } catch (Exception e) {
            out.println(new Gson().toJson(e.getLocalizedMessage()));
            response.setStatus(400);
            e.printStackTrace();
            return;
        }

        out.println(new Gson().toJson("{message: \"Movie UPDATE was successful\"}"));
        response.setStatus(200);
//        try{
//
//            // Get stream of characters from the request
//            BufferedReader reader = request.getReader();
//            // Turn that stream into an array of Movies
//            Movie[] movies = new Gson().fromJson(reader, Movie[].class);
//            // sout the properties of the each movie
//            for(Movie movie : movies){
//                System.out.println(movie.getId());
//                System.out.println(movie.getTitle());
//                System.out.println(movie.getActors());
//                System.out.println(movie.getDirector());
//                System.out.println(movie.getGenre());
//                System.out.println(movie.getPlot());
//                System.out.println(movie.getYear());
//                System.out.println(movie.getPoster());
//                System.out.println("*****************************************");
//            }
//
//        }catch (Exception ex){
//            System.out.println(ex.getMessage());
//        }
//        out.println(new Gson().toJson("{message: \"Movies PUT was successful\"}"));
//        response.setStatus(200);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("application/json");
        PrintWriter out = null;

        try{
            out = response.getWriter();
            int id = new Gson().fromJson(request.getReader(), int.class);
            DaoFactory.getMoviesDao(DaoFactory.ImplType.IN_MEMORY).destroy(id);
            System.out.printf("The id of movie to delete is: %s", id);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        // Meaningful response to client telling success
        out.println(new Gson().toJson("{message: \"Movies DELETE was successful\"}"));
        response.setStatus(200);
    }
}
