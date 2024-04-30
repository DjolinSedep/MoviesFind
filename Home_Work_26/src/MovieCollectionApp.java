import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class MovieCollectionApp {
    private List<Movie> movies;

    public MovieCollectionApp() {
        movies = new ArrayList<>();
    }

    public void loadMoviesFromJson(String jsonFilePath) {
        try (FileReader fileReader = new FileReader(jsonFilePath);
             JsonReader jsonReader = new JsonReader(fileReader)) {
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(jsonReader, JsonObject.class);
            JsonArray jsonMovies = jsonObject.getAsJsonArray("movies");
            for (JsonElement jsonElement : jsonMovies) {
                Movie movie = gson.fromJson(jsonElement, Movie.class);
                movies.add(movie);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printAllMovies() {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public List<Movie> findMoviesByActor(String actorName) {
        List<Movie> result = new ArrayList<>();
        for (Movie movie : movies) {
            for (Actor actor : movie.getCast()) {
                if (actor.getFullName().equalsIgnoreCase(actorName)) {
                    result.add(movie);
                    break; // Найден фильм с участием актера, переходим к следующему фильму
                }
            }
        }
        return result;
    }

    public List<Movie> findMoviesByDirector(String directorName) {
        List<Movie> result = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getDirector().getFullName().equalsIgnoreCase(directorName)) {
                result.add(movie);
            }
        }
        return result;
    }

    public List<Movie> findMoviesByYear(int year) {
        List<Movie> result = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getYear() == year) {
                result.add(movie);
            }
        }
        return result;
    }

    public void printRolesForActor(String actorName) {
        for (Movie movie : movies) {
            for (Actor actor : movie.getCast()) {
                if (actor.getFullName().equalsIgnoreCase(actorName)) {
                    System.out.println(movie.getName() + ": " + actor.getRole());
                    break; // Найдена роль актера, переходим к следующему фильму
                }
            }
        }
    }

    public void printAllActorsWithRoles() {
        Map<String, String> actorRolesMap = new TreeMap<>(); // TreeMap автоматически сортирует по ключу (имени актера)
        for (Movie movie : movies) {
            for (Actor actor : movie.getCast()) {
                actorRolesMap.put(actor.getFullName(), actor.getRole());
            }
        }
        actorRolesMap.forEach((actor, role) -> System.out.println(actor + ": " + role));
    }
}