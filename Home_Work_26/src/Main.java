import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        MovieCollectionApp movieCollectionApp = new MovieCollectionApp();
        movieCollectionApp.loadMoviesFromJson("Home_Work_26/src/data/movies.json");

        System.out.println("All movies:");
        movieCollectionApp.printAllMovies();
        System.out.println();

        String actorName = "Martin Freeman";
        System.out.println("Movies with actor " + actorName + ":");
        List<Movie> moviesWithActor = movieCollectionApp.findMoviesByActor(actorName);
        for (Movie movie : moviesWithActor) {
            System.out.println(movie.getName());
        }
        System.out.println();

        String directorName = "Peter Jackson";
        System.out.println("Movies by director " + directorName + ":");
        List<Movie> moviesByDirector = movieCollectionApp.findMoviesByDirector(directorName);
        for (Movie movie : moviesByDirector) {
            System.out.println(movie.getName());
        }
        System.out.println();

        int year = 2019;
        System.out.println("Movies released in " + year + ":");
        List<Movie> moviesByYear = movieCollectionApp.findMoviesByYear(year);
        for (Movie movie : moviesByYear) {
            System.out.println(movie.getName());
        }
        System.out.println();

        String actorNameForRoles = "Benedict Cumberbatch";
        System.out.println("Roles for actor " + actorNameForRoles + ":");
        movieCollectionApp.printRolesForActor(actorNameForRoles);
        System.out.println();


        System.out.println("All actors with roles:");
        movieCollectionApp.printAllActorsWithRoles();
    }
}