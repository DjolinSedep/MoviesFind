import java.util.List;

public class Movies {
    private String name;
    private int year;
    private Director director;
    private List<Actor> cast;

    // Getters and Setters

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", director=" + director +
                ", cast=" + cast +
                '}';
    }

    public Director getDirector() {
        return director;
    }

    public List<Actor> getCast() {
        return cast;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }
}



